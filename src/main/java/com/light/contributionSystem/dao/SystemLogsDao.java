package com.light.contributionSystem.dao;

import com.light.contributionSystem.entity.SystemLogs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author KangXu
 * @description 系统日志表数据访问层
 * @className SystemLogsDao
 * @data 2021/6/9 0:00
 */
@Mapper
@Repository
public interface SystemLogsDao {
    /**
     * @description 添加日志
     **/
    void insertSystemLog(SystemLogs systemLogs);

    /**
     * @description 查看日志
     **/
    List<SystemLogs> selectAllSystemLogs(@Param("userName") String userName,
                                         @Param("startTime") String startTime,
                                         @Param("endTime") String endTime);

    /**
     * @description 删除日志
     **/
    void deleteSystemLog(@Param("uuid") String uuid);
}
