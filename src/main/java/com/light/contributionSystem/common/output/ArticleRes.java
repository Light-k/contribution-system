package com.light.contributionSystem.common.output;

import lombok.Data;

/**
 * @author KangXu
 * @description 文稿返回值
 * @className ArticleRes
 * @data 2021/6/4 9:53
 */
@Data
public class ArticleRes {
    /**
     * @description 主键
     **/
    private String id;
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
     **/
    private String auditStatus;
    /**
     * @description 审核理由
     **/
    private String reason;
    /**
     * @description 删除标记
     **/
    private Integer del;
    /**
     * @description 文稿作者
     **/
    private String author;
}
