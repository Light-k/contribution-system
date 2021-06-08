package com.light.contributionSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author KangXu
 * @description 系统日志表
 * @className SystemLogs
 * @data 2021/6/8 23:57
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Alias("systemLogs")
public class SystemLogs {
    /**
     * @description 主键
     **/
    private String uuid;
    /**
     * @description 用户名
     **/
    private String userName;
    /**
     * @description 访问的请求接口地址
     **/
    private String url;
    /**
     * @description 访问时间
     **/
    private Date visitTime;
    /**
     * @description 累计时长
     **/
    private String duration;
    /**
     * @description 删除标记
     * 未删除---0
     * 已删除---1
     **/
    private Integer del;
}
