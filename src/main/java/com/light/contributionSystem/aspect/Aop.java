package com.light.contributionSystem.aspect;


import com.light.contributionSystem.util.DateUtils;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author KangXu
 * @description aop的增强
 * @className Aop
 * @data 2021/6/8 11:47
 */
@Component
@Aspect
public class Aop {

    @Autowired
    private HttpServletRequest request;
    /**
     * @description 访问时间
     **/
    private long visitTime;


    /**
     * @description 前置任务
     **/
    @Before("execution(* com.light.contributionSystem.controller.*.*(..))")
    public void logBeforeController() {
        visitTime = System.currentTimeMillis();
    }

    /**
     * @description 后置任务
     **/
    @After("execution(* com.light.contributionSystem.controller.*.*(..))")
    public void logAfterController() {
        //执行时长
        String timeDifference = DateUtils.getTimeDifference(visitTime, System.currentTimeMillis());
        //获取请求url
        StringBuffer requestURL = request.getRequestURL();
    }
}
