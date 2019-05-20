package com.vincent.evaluating_system.controller;

import com.vincent.evaluating_system.vo.ApiResponseVO;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;

/**
 * Created by IDEA on 2019/4/7
 * User: Vincent
 * Time：14:05
 */
@ControllerAdvice(basePackages = "com.vincent.evaluating_system")
@Order( value = Ordered.HIGHEST_PRECEDENCE )
public class GlobalExceptionController extends ResponseEntityExceptionHandler {


    @ResponseBody
    @ExceptionHandler(value = AuthenticationException.class)
    public HashMap ShiroExceptionHandler(AuthenticationException e) {
        e.printStackTrace();
        return ApiResponseVO.builder()
                .buildResponseMsg(e.getMessage())
                .buildResponseCode(ApiResponseVO.ResponseCode.UNAUTHENTICATED_CODE)
                .build();
    }
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public HashMap ExceptionHandler(Exception e) {
        e.printStackTrace();
        return ApiResponseVO.builder()
                .buildResponseMsg(e.getMessage())
                .buildResponseCode(ApiResponseVO.ResponseCode.SERVER_ERR_CODE)
                .build();
    }
}
