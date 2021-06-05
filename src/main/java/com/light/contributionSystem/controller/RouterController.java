package com.light.contributionSystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author KangXu
 * @description 路由层
 * @className RouterController
 * @data 2021/6/5 2:27
 */
@Controller
public class RouterController {
    /**
     * @description 注册页面
     **/
    @GetMapping("/toRegister")
    public String register() {
        return "user/register";
    }

    /**
     * @description 登录页面
     **/
    @GetMapping("/toLogin")
    public String toLogin() {
        return "index";
    }
}
