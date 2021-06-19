package com.light.contributionSystem.aspect;


import com.light.contributionSystem.common.Common;
import com.light.contributionSystem.entity.SystemLogs;
import com.light.contributionSystem.service.SystemLogsService;
import com.light.contributionSystem.util.CheckCharacterUtils;
import com.light.contributionSystem.util.DateUtils;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author KangXu
 * @description aop的增强
 * @className Aop
 * @data 2021/6/8 11:47
 */
@Component
@Aspect
public class Aop {

    private final HttpServletRequest request;
    private final SystemLogsService systemLogsService;

    public Aop(HttpServletRequest request, SystemLogsService systemLogsService) {
        this.request = request;
        this.systemLogsService = systemLogsService;
    }

    /**
     * @description 访问时间
     **/
    private Date visitTime;


    /**
     * @description 前置任务
     **/
    @Before("execution(* com.light.contributionSystem.controller.*.*(..))")
    public void logBeforeController() {
        visitTime = new Date();
    }

    /**
     * @description 后置任务
     **/
    @After("execution(* com.light.contributionSystem.controller.*.*(..))")
    public void logAfterController() {
        List<String> requestUser = new ArrayList<>();
        requestUser.add("/");
        requestUser.add("/toRegister");
        requestUser.add("/toLogin");
        requestUser.add("/exit");
        if (!requestUser.contains(request.getServletPath())
                && !request.getServletPath().contains("/systemUser")
                && !request.getServletPath().contains("/systemLogs")
                && !request.getServletPath().contains("/logs")) {
            SystemLogs systemLogs = new SystemLogs();
            systemLogs
                    .setUserName((String) request.getSession().getAttribute("userName"))
                    .setUrl(request.getRequestURL().toString())
                    .setVisitTime(visitTime)
                    .setDuration(DateUtils.getTimeDifference(visitTime.getTime(), System.currentTimeMillis()));
            for (Common.BusinessFunction businessFunction : Common.listCache) {
                if (request.getServletPath().contains(businessFunction.getUrl())) {
                    systemLogs.setBusinessFunction(businessFunction.getFunction());
                    break;
                }
            }
            if (null == systemLogs.getBusinessFunction()) {
                if (request.getServletPath().contains(Common.UPDATE_ARTICLE_MANAGEMENT_URL)) {
                    systemLogs.setBusinessFunction(Common.mapCache.get(Common.UPDATE_ARTICLE_MANAGEMENT_URL));
                }
                if (request.getServletPath().contains(Common.UPDATE_ARTICLE_MARKET_URL)) {
                    systemLogs.setBusinessFunction(Common.mapCache.get(Common.UPDATE_ARTICLE_MARKET_URL));
                }
            }
            if (null == systemLogs.getBusinessFunction()) {
                if (request.getServletPath().contains(Common.AUDIT_ARTICLE_URL)) {
                    systemLogs.setBusinessFunction(Common.mapCache.get(Common.AUDIT_ARTICLE_URL));
                }
                if (Common.APPEAR_NUMBER_FOUR.equals(CheckCharacterUtils
                        .getCounts(request.getServletPath(), "/"))) {
                    systemLogs.setBusinessFunction(Common.mapCache.get(Common.UPDATE_ARTICLE_URL));
                }
                if (Common.APPEAR_NUMBER_THREE.equals(CheckCharacterUtils
                        .getCounts(request.getServletPath(), "/"))) {
                    systemLogs.setBusinessFunction(Common.mapCache.get(Common.DELETE_ARTICLE_URL));
                } else {
                    systemLogs.setBusinessFunction(Common.mapCache.get(Common.INSERT_ARTICLE_URL));
                }
            }
            systemLogsService.addSystemLog(systemLogs);
        }
    }

}
