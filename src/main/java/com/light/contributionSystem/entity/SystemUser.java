package com.light.contributionSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

/**
 * @author KangXu
 * @description 系统用户表
 * @className SystemUser
 * @data 2021/6/3 21:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Alias("systemUser")
public class SystemUser {
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
     * 普通用户---User
     * 管理员---Admin
     **/
    private String userRole;
    public static final String ROLE_USER = "User";
    public static final String ROLE_ADMIN = "Admin";
}
