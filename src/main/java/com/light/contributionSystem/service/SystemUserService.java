package com.light.contributionSystem.service;

import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.common.input.RegisterOrLoginParams;
import org.springframework.stereotype.Service;

/**
 * @author KangXu
 * @description 系统用户表的业务层
 * @className SystemUserService
 * @data 2021/6/3 22:10
 */
@Service
public interface SystemUserService {
    /**
     * @description 注册用户
     **/
    BaseResponse registerSystemUser(RegisterOrLoginParams registerOrLoginParams);

    /**
     * @description 登录
     **/
    BaseResponse login(RegisterOrLoginParams registerOrLoginParams);
}
