package com.vincent.evaluating_system.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.vincent.evaluating_system.entity.EntityUser;
import com.vincent.evaluating_system.service.EntityPermissionService;
import com.vincent.evaluating_system.service.EntityRoleService;
import com.vincent.evaluating_system.service.EntityUserService;
import com.vincent.evaluating_system.util.JwtTokenUtil;
import com.vincent.evaluating_system.util.PasswordUtil;
import com.vincent.evaluating_system.vo.AuthVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by IDEA on 2019/4/4
 * User: Vincent
 * Time：17:29
 */
public class UserRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger(UserRealm.class);

    private final Logger LOGGER = LoggerFactory.getLogger(UserRealm.class);
    @Autowired
    private EntityUserService userService;
    @Autowired
    private EntityRoleService roleService;
    @Autowired
    private EntityPermissionService permService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    private EntityUser getUserByToken(String token) {

        String account = jwtTokenUtil.getUserNameFromToken(token);
        EntityUser user = userService.selectOne(new EntityWrapper<EntityUser>()
                .eq("account", account));
        return user;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //null usernames are invalid
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }
        EntityUser user = getUserByToken((String) principals.getPrimaryPrincipal());
        Set<AuthVO> roles = roleService.getRoleSetByUserId(user.getUserId());
        log.info("获取角色权限信息: roles: {}", roles);
        Set<AuthVO> perms = permService.getPermSetByUserId(user.getUserId());
        log.info("获取角色权限信息: perms: {}", perms);

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setRoles(roles.stream().map(AuthVO::getValue).collect(Collectors.toSet()));
        info.setStringPermissions(perms.stream().map(AuthVO::getValue).collect(Collectors.toSet()));
        return info;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) {

        JwtToken upToken = (JwtToken) token;
        String tokenStr = (String) upToken.getPrincipal();
        String account = jwtTokenUtil.getUserNameFromToken(tokenStr);
        EntityUser userDB = getUserByToken(tokenStr);
        if (userDB == null) {
            throw new AuthenticationException("token失效或者不正确！！！");
        }
        LOGGER.info("用户名：{}", account);
        this.setCredentialsMatcher(new CredentialsMatcher() {
            @Override
            public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
                return true;
            }
        });
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(token.getPrincipal(), token.getCredentials(), getName());
        return info;

    }
}
