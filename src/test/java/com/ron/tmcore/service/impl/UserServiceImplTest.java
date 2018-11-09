package com.ron.tmcore.service.impl;

import com.ron.tmcore.entity.UserInfo;
import com.ron.tmcore.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserByUserName() {

        String userName = "1";
        UserInfo userInfo = userService.getUserByUserName(userName);

        System.out.println(userInfo.toString());

    }
}