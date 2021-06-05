package com.light.contributionSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author KangXu
 * @description 接受form参数
 * @className MyFormConfig
 * @data 2021/6/5 23:01
 */
@Configuration
public class MyFormConfig extends WebMvcConfigurationSupport {
    @Bean
    public FormContentFilter httpPutFormContentFilter() {
        return new FormContentFilter();
    }
}
