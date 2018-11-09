package com.ron.tmcore.service;

import com.ron.tmcore.entity.Role;
import com.ron.tmcore.entity.UserInfo;

import java.util.List;

public interface UserService {

    /**
     * 根据用户名查找用户信息
     * @param userName 用户名
     * @return 用户信息
     */
    UserInfo getUserByUserName(String userName);

    /**
     * 根据用户ID获取角色信息
     * @param userId 用户Id
     * @return 角色列表
     */
    List<Role> getRolesByUserId(String userId);
}
