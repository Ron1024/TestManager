package com.ron.tmcore.config;

import com.ron.tmcore.entity.Role;
import com.ron.tmcore.entity.UserInfo;
import com.ron.tmcore.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    /**
     * 授权
     *
     * @param principalCollection
     * @return 凭证信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("doGetAuthorizationInfo+" + principalCollection.toString());


        UserInfo userInfo = userService.getUserByUserName((String) principalCollection.getPrimaryPrincipal());

        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(userInfo.getId()),
                SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        //赋予角色
//        for (Role role:userInfo.getRoles){
//
//        }

        //赋予权限


        return null;
    }

    /**
     * 认证
     *
     * @param authenticationToken 前端传回认证信息
     * @return 认证信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        //1、从前端获取需要认证的用户名信息
        logger.info(usernamePasswordToken.getUsername() + usernamePasswordToken.getPassword());
        //2、从数据库中获取用户详细信息
        UserInfo userInfo = userService.getUserByUserName(usernamePasswordToken.getUsername());
        if (userInfo == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", userInfo);
        return new SimpleAuthenticationInfo(usernamePasswordToken.getUsername(), userInfo.getPassword(), getName());
    }
}
