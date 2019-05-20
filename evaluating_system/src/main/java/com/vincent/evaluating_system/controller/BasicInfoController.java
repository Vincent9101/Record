package com.vincent.evaluating_system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vincent.evaluating_system.DTO.UserInfoDTO;
import com.vincent.evaluating_system.entity.EntityRole;
import com.vincent.evaluating_system.entity.EntityUser;
import com.vincent.evaluating_system.entity.EntityUserRole;
import com.vincent.evaluating_system.service.EntityRoleService;
import com.vincent.evaluating_system.service.EntityUserRoleService;
import com.vincent.evaluating_system.service.EntityUserService;
import com.vincent.evaluating_system.util.JwtTokenUtil;
import com.vincent.evaluating_system.util.PasswordUtil;
import com.vincent.evaluating_system.vo.ApiResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IDEA on 2019/4/7
 * User: Vincent
 * Time：17:47
 */

@Api(tags = "Basic Personal Info", description = "基本信息管理")
@RequestMapping("/api")
@RestController
public class BasicInfoController {

    @Autowired
    private EntityRoleService roleService;
    @Autowired
    private EntityUserService userService;
    @Autowired
    private EntityUserRoleService userRoleService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @ResponseBody
    @PutMapping("/info")
    @ApiOperation("更改密码或者昵称")
    public HashMap changePassword(@RequestParam(required = true) String password,
                                  @RequestParam (required = false)String nickname) {
        if (StringUtils.isEmpty(password)) {
            return ApiResponseVO.builder()
                    .buildResponseMsg("密码不能为空")
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .build();
        }
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        String account = jwtTokenUtil.getUserNameFromToken(token);

        EntityUser entityUser = userService.selectOne(new EntityWrapper<EntityUser>()
                .eq("account", account));
        entityUser.setNickname(StringUtils.isEmpty(nickname) ? entityUser.getNickname() : nickname);
        entityUser.setPassword(PasswordUtil.generateHashPassword(password, entityUser.getSalt()));
        boolean success = userService.update(entityUser, new EntityWrapper<EntityUser>().eq("account", account));
        if (success)
            return ApiResponseVO.builder()
                    .buildResponseMsg("更新成功")
                    .buildResponseCode(ApiResponseVO.ResponseCode.SUCCESS_CODE)
                    .build();
        return ApiResponseVO.builder()
                .buildResponseMsg("更新失败")
                .buildResponseCode(ApiResponseVO.ResponseCode.SERVER_ERR_CODE)
                .build();
    }

    @ResponseBody
    @ApiOperation("获取个人信息")
    @GetMapping("/info")
    public HashMap<String, Object> getPersonalInfo() {
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        String account = jwtTokenUtil.getUserNameFromToken(token);
        EntityUser entityUser = userService.selectOne(
                new EntityWrapper<EntityUser>()
                        .eq("account", account));
        String roleValue = roleService.selectOne(new EntityWrapper<EntityRole>()
                .eq("role_id", userRoleService.selectOne(new EntityWrapper<EntityUserRole>()
                        .eq("user_id", entityUser.getUserId()))
                        .getRoleId()))
                .getRoleValue();
        UserInfoDTO userInfoDTO = new UserInfoDTO(roleValue, entityUser.getAccount(), entityUser.getNickname());


        return ApiResponseVO.builder()
                .buildResponseCode(ApiResponseVO.ResponseCode.SUCCESS_CODE)
                .builderData("userinfo",userInfoDTO)
                .buildResponseMsg("成功获取")
                .build();
    }

}
