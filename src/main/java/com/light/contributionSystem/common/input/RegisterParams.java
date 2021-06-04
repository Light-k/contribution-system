package com.light.contributionSystem.common.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author KangXu
 * @description 注册或登录入参
 * @className RegisterOrLoginParams
 * @data 2021/6/3 22:40
 */
@Data
public class RegisterParams {
    /**
     * @description 登录名
     **/
    @NotBlank
    private String userName;
    /**
     * @description 登录密码
     **/
    @NotBlank
    private String userPwd;
    /**
     * @description 用户角色
     **/
    @NotBlank
    private String userRole;
}
