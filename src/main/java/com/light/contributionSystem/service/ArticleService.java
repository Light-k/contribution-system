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
     * @description 普通用户删除文稿
     **/
    BaseResponse delArticleBySystemUser(String userId);

    /**
     * @description 管理员删除文稿
     **/
    BaseResponse delArticleByUuid(String uuid);

    /**
     * @description 审核
     **/
    BaseResponse audit(String uuid, String auditStatus, String reason);

    /**
     * @description 查看全部文稿/根据用户登录名查询文稿
     **/
    BaseResponse findAllArticles(Integer page, Integer pageSize, String userName);

    /**
     * @description 管理员查看文稿详情
     **/
    BaseResponse findArticleByAdmin(String uuid);

    /**
     * @description 用户编辑文稿
     **/
    BaseResponse editArticle(String userId, String content);

    /**
     * @description 用户查看文稿
     **/
    BaseResponse findArticleBySystemUser(String userId);

}
