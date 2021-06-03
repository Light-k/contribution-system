package com.light.contributionSystem.controller;

import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.common.input.RegisterOrLoginParams;
import com.light.contributionSystem.entity.SystemUser;
import com.light.contributionSystem.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KangXu
 * @description 系统用户表接口
 * @className SystemUserController
 * @data 2021/6/3 22:32
 */
@RestController
@RequestMapping("/user")
public class SystemUserController {
    @Autowired
    private SystemUserService systemUserService;

    /**
     * @description 注册用户
     **/
    @PostMapping
    public BaseResponse registerSystemUser(RegisterOrLoginParams registerOrLoginParams) {
        return systemUserService.registerSystemUser(registerOrLoginParams);
    }

    /**
     * @description  登录
     **/
    @GetMapping
    public BaseResponse login(RegisterOrLoginParams registerOrLoginParams) {
        return systemUserService.login(registerOrLoginParams);
    }
}
