package com.ron.tmcore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomeController {

    /**
     * 跳转到登陆页面
     * @return 登陆页面
     */
    @RequestMapping(value = "/gotoLogin")
    public ModelAndView gotoLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
