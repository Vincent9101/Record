package com.vincent.evaluating_system.shiro;

import com.vincent.evaluating_system.util.JwtTokenUtil;
import org.apache.shiro.authc.AuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by IDEA on 2019/4/4
 * User: Vincent
 * Time：20:32
 */
public class JwtToken implements AuthenticationToken {


    private String token;

    public JwtToken(String token) {
        this.token = token;
    }


    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
