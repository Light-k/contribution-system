package com.light.contributionSystem.service.impl;

import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.common.Common;
import com.light.contributionSystem.common.input.RegisterParams;
import com.light.contributionSystem.dao.SystemUserDao;
import com.light.contributionSystem.entity.SystemUser;
import com.light.contributionSystem.service.SystemUserService;
import com.light.contributionSystem.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpSession;

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
    public BaseResponse registerSystemUser(RegisterParams registerParams) {
        SystemUser systemUser = systemUserDao
                .selectSystemUserByUserName(registerParams.getUserName());
        if (ObjectUtils.isEmpty(systemUser)) {
            SystemUser user = new SystemUser();
            //注册
            user
                    .setUuid(IdUtils.getUuid())
                    .setUserName(registerParams.getUserName())
                    .setUserPwd(registerParams.getUserPwd())
                    .setUserRole(registerParams.getUserRole());
            systemUserDao.insertSystemUser(user);
            return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS,
                    user.getUserName(), "注册成功");
        }
        return BaseResponse.resp(Common.ERROR_RESPONSE_STATUS, "该用户已被注册");
    }

    /**
     * @description 登录
     **/
    @Override
    public BaseResponse login(String userName, String userPwd, String userRole, HttpSession session) {
        SystemUser systemUser = systemUserDao.selectSystemUserByUserName(userName);
        if (ObjectUtils.isEmpty(systemUser)) {
            return BaseResponse.resp(Common.ERROR_RESPONSE_STATUS, "该用户不存在");
        }
        if (!systemUser.getUserPwd().equals(userPwd)) {
            return BaseResponse.resp(Common.ERROR_RESPONSE_STATUS, "密码错误");
        }
        session.setAttribute("userName", userName);
        if (SystemUser.ROLE_USER.equals(userRole)) {
            return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "普通用户登录成功");
        }
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "管理员登录成功");
    }

    /**
     * @description 退出
     **/
    @Override
    public BaseResponse exit(HttpSession session) {
        session.removeAttribute("userName");
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "已退出");
    }
}
