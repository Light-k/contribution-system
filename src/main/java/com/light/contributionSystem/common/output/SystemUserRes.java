package com.light.contributionSystem.common.output;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author KangXu
 * @description 系统用户表返回值
 * @className SystemUserRes
 * @data 2021/6/3 21:30
 */
@Data
public class SystemUserRes {
    /**
     * @description 主键
     **/
    private String uuid;
    /**
     * @description 登录名
     **/
    private String userName;
    /**
     * @description 登录密码
     **/
    private String userPwd;
    /**
     * @description 用户角色
     **/
    private String userRole;
}
