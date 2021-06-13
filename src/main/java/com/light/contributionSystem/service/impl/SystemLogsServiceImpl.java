package com.light.contributionSystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.common.Common;
import com.light.contributionSystem.dao.SystemLogsDao;
import com.light.contributionSystem.entity.SystemLogs;
import com.light.contributionSystem.service.SystemLogsService;
import com.light.contributionSystem.util.IdUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author KangXu
 * @description 系统日志表的业务层实现
 * @className SystemLogsServiceImpl
 * @data 2021/6/9 0:14
 */
@Service
public class SystemLogsServiceImpl implements SystemLogsService {
    private final SystemLogsDao systemLogsDao;

    public SystemLogsServiceImpl(SystemLogsDao systemLogsDao) {
        this.systemLogsDao = systemLogsDao;
    }

    /**
     * @description 添加日志
     **/
    @Override
    public BaseResponse addSystemLog(SystemLogs systemLogs) {
        systemLogs.setUuid(IdUtils.getUuid());
        systemLogsDao.insertSystemLog(systemLogs);
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "添加成功");
    }

    /**
     * @description 查看日志
     **/
    @Override
    public PageInfo selectAllSystemLogs(Integer pageNum,
                                        Integer pageSize,
                                        String userName,
                                        String startTime,
                                        String endTime) {
        PageHelper.startPage(pageNum, pageSize);
        List<SystemLogs> systemLogs = systemLogsDao
                .selectAllSystemLogs(userName, startTime, endTime);
        return new PageInfo(systemLogs);
    }

    /**
     * @description 删除日志
     **/
    @Override
    public BaseResponse delSystemLog(String uuid) {
        systemLogsDao.deleteSystemLog(uuid);
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "删除成功");
    }
}
