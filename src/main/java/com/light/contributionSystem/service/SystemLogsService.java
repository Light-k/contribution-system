package com.light.contributionSystem.service;

import com.github.pagehelper.PageInfo;
import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.entity.SystemLogs;
import org.springframework.stereotype.Service;


/**
 * @author KangXu
 * @description 系统日志表的业务层接口
 * @className SystemLogsService
 * @data 2021/6/9 0:13
 */
@Service
public interface SystemLogsService {
    /**
     * @description 添加日志
     **/
    BaseResponse addSystemLog(SystemLogs systemLogs);

    /**
     * @description 查看日志
     **/
    PageInfo selectAllSystemLogs(Integer pageNum,
                                 Integer pageSize,
                                 String userName,
                                 String startTime,
                                 String endTime);

    /**
     * @description 删除日志
     **/
    BaseResponse delSystemLog(String uuid);
}
