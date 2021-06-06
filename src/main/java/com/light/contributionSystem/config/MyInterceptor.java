package com.light.contributionSystem.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author KangXu
 * @description 自定义拦截器
 * @className MyInterceptor
 * @data 2021/6/4 23:30
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userName = (String) request.getSession().getAttribute("userName");
        List<String> requestUser = new ArrayList<>();
        requestUser.add("/");
        requestUser.add("/systemUser");
        requestUser.add("/toRegister");
        requestUser.add("/toLogin");
        if (requestUser.contains(request.getServletPath()) ||
                null != userName || request.getServletPath().contains("/systemUser")) {
            return true;
        }
        response.sendRedirect("/index.html");
        return false;
    }
}
