package com.vincent.evaluating_system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.vincent.evaluating_system.DTO.UserInfoDTO;
import com.vincent.evaluating_system.entity.EntityRole;
import com.vincent.evaluating_system.entity.EntityUser;
import com.vincent.evaluating_system.entity.EntityUserRole;
import com.vincent.evaluating_system.service.EntityRoleService;
import com.vincent.evaluating_system.service.EntityUserRoleService;
import com.vincent.evaluating_system.service.EntityUserService;
import com.vincent.evaluating_system.shiro.JwtToken;
import com.vincent.evaluating_system.util.JwtTokenUtil;
import com.vincent.evaluating_system.util.PasswordUtil;
import com.vincent.evaluating_system.vo.ApiResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by IDEA on 2019/4/5
 * User: Vincent
 * Time：21:50
 */
@RestController
@RequiresRoles("super")
@RequiresPermissions("auth:super:user_management")
@RequestMapping("/api/user_management")
@Api(tags = "user_management", description = "管理用户")
public class UserManagementController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserManagementController.class);

    @Autowired
    private EntityRoleService roleService;
    @Autowired
    private EntityUserService userService;
    @Autowired
    private EntityUserRoleService userRoleService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @ApiOperation("获取用户信息列表,不会获得本人信息")
    @GetMapping("/user")
    public HashMap listUserInfo() {
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        String account = jwtTokenUtil.getUserNameFromToken(token);
        EntityRole superRole = roleService.selectOne(
                new EntityWrapper<EntityRole>().eq("role_value", "super"));
        List<UserInfoDTO> dtoSuperUserList = userService
                .getUserListByRoleId(superRole.getRoleId())
                .stream()
                .filter(entityUser -> !entityUser.getAccount().equals(account))
                .map(entityUser -> new UserInfoDTO("super", entityUser.getAccount(), entityUser.getNickname()))
                .collect(Collectors.toList());


        EntityRole normalRole = roleService.selectOne(
                new EntityWrapper<EntityRole>().eq("role_value", "normal"));

        List<UserInfoDTO> dtoNormalUserList = userService
                .getUserListByRoleId(normalRole.getRoleId())
                .stream()
                .sorted(new Comparator<EntityUser>() {
                    @Override
                    public int compare(EntityUser o1, EntityUser o2) {
                        return o1.getCreated().before(o2.getCreated()) ? 0 : 1;
                    }
                })
                .map(entityUser -> new UserInfoDTO("normal",
                        entityUser.getAccount(),
                        entityUser.getNickname()))
                .collect(Collectors.toList());


        return ApiResponseVO.builder()
                .buildResponseCode(ApiResponseVO.ResponseCode.SUCCESS_CODE)
                .buildResponseMsg("获取成功")
                .builderData("normal_users", dtoNormalUserList)
                .builderData("super_users", dtoSuperUserList)
                .build();
    }

    @ApiOperation("删除用户")
    @DeleteMapping("/user")
    public HashMap deleteUser(@RequestParam(required = true) String account) {
        if (StringUtils.isEmpty(account)) {
            return ApiResponseVO.builder()
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .buildResponseMsg("用户名不可为空")
                    .build();
        }

        EntityUser entityUser = userService.selectOne(new EntityWrapper<EntityUser>()
                .eq("account", account));
        if (entityUser == null) {
            return ApiResponseVO.builder()
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .buildResponseMsg("用户名不存在")
                    .build();
        }
        userService.deleteById(entityUser.getUserId());
        boolean success = userRoleService.delete(new EntityWrapper<EntityUserRole>()
                .eq("user_id", entityUser.getUserId()));

        if (success)
            return ApiResponseVO.builder()
                    .buildResponseMsg("删除成功")
                    .buildResponseCode(ApiResponseVO.ResponseCode.SUCCESS_CODE)
                    .build();
        return ApiResponseVO.builder()
                .buildResponseMsg("删除失败")
                .buildResponseCode(ApiResponseVO.ResponseCode.SERVER_ERR_CODE)
                .build();
    }

    @ApiOperation("添加新用户")
    @PostMapping("/user")
    @ResponseBody
    public HashMap<String, Object> addUser(@RequestParam(required = true, defaultValue = "normal") String roleValue,
                                           @RequestParam(required = true) String nickname,
                                           @RequestParam(required = true) String account) {
        if (StringUtils.isEmpty(account)) {
            return ApiResponseVO.builder()
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .buildResponseMsg("account 不能为空")
                    .build();
        }
        if (StringUtils.isEmpty(nickname))
            nickname = account;
        EntityRole entityRole = new EntityRole();
        entityRole = roleService.selectOne(new EntityWrapper<EntityRole>()
                .eq("role_value", roleValue));
        //check role_value
        if (entityRole == null) {
            return ApiResponseVO.builder()
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .buildResponseMsg("role_value,不存在,系统默认只有super,normal值")
                    .build();
        }
        //check account
        if (userService.selectOne(new EntityWrapper<EntityUser>()
                .eq("account", account)) != null) {
            return ApiResponseVO
                    .builder()
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .buildResponseMsg("用户名:" + account + "不可用")
                    .build();
        }


        //insert into table_user
        String password = account;
        String salt = PasswordUtil.generateSalt();
        String hashedPwd = PasswordUtil.generateHashPassword(password, salt);
        //保存新用户数据
        EntityUser user = new EntityUser();
        user.setAccount(account);
        user.setNickname(nickname);
        user.setSalt(salt);
        user.setPassword(hashedPwd);
        user.setCreated(new Date());

        boolean successful = userService.insert(user);

        if (successful) {

            //insert into table_user_role
            EntityUserRole entityUserRole = new EntityUserRole();
            entityUserRole.setRoleId(entityRole.getRoleId());
            entityUserRole.setUserId(user.getUserId());
            successful = userRoleService.insert(entityUserRole);

        }

        LOGGER.info("user.info{}", user);

        user.getUserId();

        return ApiResponseVO.builder()
                .buildResponseCode((successful == true ? ApiResponseVO.ResponseCode.SUCCESS_CODE : ApiResponseVO.ResponseCode.SERVER_ERR_CODE))
                .buildResponseMsg(successful ? "add succeeded" : "add failed")
                .build();
    }


}
