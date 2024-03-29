package com.light.contributionSystem.dao;

import com.light.contributionSystem.entity.SystemUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author KangXu
 * @description 系统用户表的数据访问层
 * @className SystemUserDao
 * @data 2021/6/3 21:58
 */
@Mapper
@Repository
public interface SystemUserDao {
    /**
     * @description 添加用户
     **/
    void insertSystemUser(SystemUser systemUser);

    /**
     * @description 根据登录名查询用户
     **/
    SystemUser selectSystemUserByUserName(@Param("userName") String userName);

    /**
     * @description 根据用户id查询用户名
     **/
    String selectSystemUserNameByUserId(@Param("userId") String userId);
}
