package com.light.contributionSystem;

import com.light.contributionSystem.common.Common;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author KangXu
 * @description 启动加载类
 * @className RunInit
 * @data 2021/6/19 17:59
 */
@Configuration
public class RunInit {
    /**
     * @description 初始化缓存
     **/
    @PostConstruct
    public void init() {
        Common.addCache();
    }
}
