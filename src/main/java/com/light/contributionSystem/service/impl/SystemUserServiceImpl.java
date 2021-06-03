package com.light.contributionSystem.service.impl;

import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.common.Common;
import com.light.contributionSystem.common.input.RegisterOrLoginParams;
import com.light.contributionSystem.common.output.SystemUserRes;
import com.light.contributionSystem.dao.SystemUserDao;
import com.light.contributionSystem.entity.SystemUser;
import com.light.contributionSystem.service.SystemUserService;
import com.light.contributionSystem.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @author KangXu
 * @description 系统用户表业务层实现
 * @className SystemUserServiceImpl
 * @data 2021/6/3 22:46
 */
@Service
public class SystemUserServiceImpl implements SystemUserService {
    @Autowired
    private SystemUserDao systemUserDao;

    /**
     * @description 注册用户
     **/
    @Override
    public BaseResponse registerSystemUser(RegisterOrLoginParams registerOrLoginParams) {
        SystemUserRes systemUserRes = systemUserDao
                .selectSystemUserByUserName(registerOrLoginParams.getUserName());
        if (ObjectUtils.isEmpty(systemUserRes)) {
            //注册
            SystemUser systemUser = new SystemUser();
            systemUser
                    .setUuid(IdUtils.getUuid())
                    .setUserName(registerOrLoginParams.getUserName())
                    .setUserPwd(registerOrLoginParams.getUserPwd())
                    .setUserRole(registerOrLoginParams.getUserRole());
            systemUserDao.insertSystemUser(systemUser);
            return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "注册成功");
        }
        return BaseResponse.resp(Common.ERROR_RESPONSE_STATUS, "该用户已被注册");
    }

    /**
     * @description 登录
     **/
    @Override
    public BaseResponse login(RegisterOrLoginParams registerOrLoginParams) {
        SystemUserRes systemUserRes = systemUserDao
                .selectSystemUserByUserName(registerOrLoginParams.getUserName());
        if (ObjectUtils.isEmpty(systemUserRes)) {
            return BaseResponse.resp(Common.ERROR_RESPONSE_STATUS, "该用户不存在");
        }
        if (!systemUserRes.getUserPwd().equals(registerOrLoginParams.getUserPwd())) {
            return BaseResponse.resp(Common.ERROR_RESPONSE_STATUS, "密码错误");
        }
        if (SystemUser.ROLE_USER.equals(registerOrLoginParams.getUserRole())) {
            return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "普通用户登录成功");
        }
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "管理员登录成功");
    }
}
