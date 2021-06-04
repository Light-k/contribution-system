package com.light.contributionSystem.common.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author KangXu
 * @description 投稿入参
 * @className ContributionParams
 * @data 2021/6/4 10:10
 */
@Data
public class ContributionParams {
    /**
     * @description 用户id
     **/
    @NotBlank
    private String userId;
    /**
     * @description 文稿标题
     **/
    @NotBlank
    private String title;
    /**
     * @description 文稿内容
     **/
    @NotBlank
    private String content;
}
