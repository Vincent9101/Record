package com.vincent.evaluating_system.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.instrument.classloading.jboss.JBossLoadTimeWeaver;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by IDEA on 2019/4/6
 * User: Vincent
 * Time：21:10
 */
@RestController
@Api(tags = "Authentication", description = "用户验证")
public class AuthenticationController {

    //    @Value("${jwt.tokenHead}")
//    private String tokenHead;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private EntityUserService userService;
    @Autowired
    private EntityRoleService roleService;
    @Autowired
    private EntityUserRoleService userRoleService;

    //
//    public HashMap refreshToken(){
//       Subject subject= SecurityUtils.getSubject();
//        if(subject.get)
//        return
//    }
    @ApiOperation("登出")
    @PostMapping("/api/logout")
    @ResponseBody
    public HashMap logout() {
        return ApiResponseVO.builder()
                .buildResponseCode(ApiResponseVO.ResponseCode.SUCCESS_CODE)
                .build();
    }

    @ApiOperation("注销")
    @DeleteMapping("/api/logoff")
    @ResponseBody
    public HashMap logoff() {
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        String account = jwtTokenUtil.getUserNameFromToken(token);
        EntityUser entityUser = userService.selectOne(new EntityWrapper<EntityUser>()
                .eq("account", account));
        userService.deleteById(entityUser.getUserId());
        boolean success = userRoleService.delete(new EntityWrapper<EntityUserRole>()
                .eq("user_id", entityUser.getUserId()));

        if (success)
            return ApiResponseVO.builder()
                    .buildResponseMsg("注销成功")
                    .buildResponseCode(ApiResponseVO.ResponseCode.SUCCESS_CODE)
                    .build();
        return ApiResponseVO.builder()
                .buildResponseMsg("注销失败")
                .buildResponseCode(ApiResponseVO.ResponseCode.SERVER_ERR_CODE)
                .build();
    }

    @ApiOperation("获得权限信息")
    @PostMapping("/api/role")
    @ResponseBody
    public HashMap role() {
        String account = jwtTokenUtil.getUserNameFromToken((String) SecurityUtils.getSubject().getPrincipal());
        EntityUser entityUser = userService.selectOne(new EntityWrapper<EntityUser>().eq("account", account));
        EntityUserRole entityUserRole = userRoleService.selectOne(
                new EntityWrapper<EntityUserRole>()
                        .eq("user_id", entityUser.getUserId()));

        EntityRole entityRole = roleService.selectOne(new EntityWrapper<EntityRole>()
                .eq("role_id"
                        , entityUserRole.getRoleId()));

        return ApiResponseVO.builder()
                .buildResponseCode(ApiResponseVO.ResponseCode.SUCCESS_CODE)
                .builderData("role",entityRole.getRoleValue())
                .build();
    }

    @ApiOperation("登陆，获得token权限和角色")
    @PostMapping("/login")
    @ResponseBody
    public HashMap login(@RequestParam(required = true) String account
            , @RequestParam(required = true) String password) throws Exception {


        if (StringUtils.isEmpty(account)) {
            return ApiResponseVO.builder()
                    .buildResponseMsg("用户名不能为空！")
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .build();
        }
        if (StringUtils.isEmpty(password)) {
            return ApiResponseVO.builder()
                    .buildResponseMsg("密码不能为空！")
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .build();
        }

        EntityUser entityUser = userService.selectOne(new EntityWrapper<EntityUser>()
                .eq("account", account));

        if (entityUser == null) {
//            throw  new Exception("测试拦截器");
            return ApiResponseVO.builder()
                    .buildResponseMsg("用户名不存在！！！")
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .build();
        }


        String token = jwtTokenUtil.generateToken(account);
        if (!PasswordUtil.isRight(entityUser.getSalt(), entityUser.getPassword(), password)) {
            return ApiResponseVO.builder()
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .buildResponseMsg("密码有误！！！")
                    .build();
        }
        EntityUserRole entityUserRole = userRoleService.selectOne(
                new EntityWrapper<EntityUserRole>()
                        .eq("user_id", entityUser.getUserId()));

        EntityRole entityRole = roleService.selectOne(new EntityWrapper<EntityRole>()
                .eq("role_id"
                        , entityUserRole.getRoleId()));


        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("role_value", entityRole.getRoleValue());

        return ApiResponseVO.builder()
                .builderData("token", token)
                .builderData("role_value", entityRole.getRoleValue())
                .builderData("nickname", entityUser.getNickname())
                .builderData("account", entityUser.getAccount())
                .buildResponseCode(ApiResponseVO.ResponseCode.SUCCESS_CODE)
                .build();
    }

    @ApiOperation("刷新token，延长token时间")
    @ResponseBody
    @PutMapping("/api/new_token")
    public HashMap refreshToken() {
        String oldToken = (String) SecurityUtils.getSubject().getPrincipal();
        if (!jwtTokenUtil.canRefresh(oldToken)) {
            return ApiResponseVO.builder()
                    .buildResponseCode(ApiResponseVO.ResponseCode.PARAM_ERROR_CODE)
                    .buildResponseMsg("token 已经过效，请从新登陆")
                    .build();
        }
        String newToken = jwtTokenUtil.refreshToken(oldToken);
        return ApiResponseVO.builder()
                .buildResponseMsg("刷新成功")
                .buildResponseCode(ApiResponseVO.ResponseCode.SUCCESS_CODE)
                .builderData("new_token",newToken)
                .build();
    }
}
