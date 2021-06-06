package com.light.contributionSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author KangXu
 * @description mvc配置类
 * @className MyMvcConfig
 * @data 2021/6/4 23:35
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/fonts/**", "/js/**", "/plugins/**");
    }

    /**
     * @description 接受put和delete请求的
     **/
    @Bean
    public FormContentFilter httpPutFormContentFilter() {
        return new FormContentFilter();
    }
}
