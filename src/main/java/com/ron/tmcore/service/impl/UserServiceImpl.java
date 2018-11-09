package com.ron.tmcore.service.impl;

import com.ron.tmcore.entity.Role;
import com.ron.tmcore.mapper.UserInfoMapper;
import com.ron.tmcore.entity.UserInfo;
import com.ron.tmcore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserByUserName(String userName) {
        return userInfoMapper.getUserByUserName(userName);
    }

    @Override
    public List<Role> getRolesByUserId(String userId) {
        return null;
    }
}
