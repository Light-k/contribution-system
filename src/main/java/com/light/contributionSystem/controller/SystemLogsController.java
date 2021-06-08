package com.light.contributionSystem.controller;

import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.service.SystemLogsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author KangXu
 * @description 系统日志表路接口
 * @className SystemLogsController
 * @data 2021/6/9 1:22
 */
@RestController
@RequestMapping("/logs")
public class SystemLogsController {
    private final SystemLogsService systemLogsService;

    public SystemLogsController(SystemLogsService systemLogsService) {
        this.systemLogsService = systemLogsService;
    }
    /**
     * @description  删除日志
     **/
    @DeleteMapping("/{uuid}")
    public BaseResponse delSystemLog(@PathVariable("uuid") String uuid){
        return systemLogsService.delSystemLog(uuid);
    }
}
