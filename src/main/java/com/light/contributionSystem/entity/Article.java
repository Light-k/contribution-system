package com.light.contributionSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author KangXu
 * @description 文稿表
 * @className Article
 * @data 2021/6/3 21:34
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Alias("article")
public class Article {
    /**
     * @description 主键
     **/
    private String uuid;
    /**
     * @description 用户id
     **/
    private String userId;
    /**
     * @description 文稿标题
     **/
    private String title;
    /**
     * @description 文稿内容
     **/
    private String content;
    /**
     * @description 审核状态
     * 待审核---ToBeReviewed
     * 审核通过---Passed
     * 审核未通过---Failed
     **/
    private String auditStatus;
    public static final String STATUS_TO_BE_REVIEWED = "ToBeReviewed";
    public static final String STATUS_PASSED = "Passed";
    public static final String STATUS_FAILED = "Failed";
    /**
     * @description 审核理由
     **/
    private String reason;
    /**
     * @description 更新时间
     **/
    private Date updateTime;
    /**
     * @description 删除标记
     * 未删除---0
     * 已删除---1
     **/
    private Integer del;
}
