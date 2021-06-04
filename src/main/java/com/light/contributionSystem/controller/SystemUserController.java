package com.light.contributionSystem.controller;

import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.common.input.RegisterParams;
import com.light.contributionSystem.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public BaseResponse registerSystemUser(@RequestBody @Valid RegisterParams registerParams) {
        return systemUserService.registerSystemUser(registerParams);
    }

    /**
     * @description 登录
     **/
    @GetMapping("/{userName}/{userPwd}/{userRole}")
    public BaseResponse login(@PathVariable("userName") String userName,
                              @PathVariable("userPwd") String userPwd,
                              @PathVariable("userRole") String userRole) {
        return systemUserService.login(userName, userPwd, userRole);
    }
}
