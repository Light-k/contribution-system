package com.light.contributionSystem.service;

import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.common.input.ContributionParams;
import org.springframework.stereotype.Service;

/**
 * @author KangXu
 * @description 文稿表业务层
 * @className ArticleService
 * @data 2021/6/3 23:33
 */
@Service
public interface ArticleService {
    /**
     * @description 投稿
     **/
    BaseResponse contribution(ContributionParams contributionParams);

    /**
     * @description 删除文稿
     **/
    BaseResponse delArticleByUuid(String uuid);

    /**
     * @description 审核
     **/
    BaseResponse audit(String uuid, String auditStatus, String reason);

    /**
     * @description 用户编辑文稿
     **/
    BaseResponse editArticle(String uuid, String content);

}
