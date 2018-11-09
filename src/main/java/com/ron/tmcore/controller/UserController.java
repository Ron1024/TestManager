package com.ron.tmcore.controller;

import com.ron.tmcore.entity.UserInfo;
import com.ron.tmcore.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping(value = "/login")
    public ModelAndView login(@Param("userName")String userName,@Param("password")String password){
        ModelAndView modelAndView = new ModelAndView();
        UserInfo userInfo = userService.getUserByUserName(userName);

        System.out.println(userInfo.toString());
        return modelAndView;
    }
}
