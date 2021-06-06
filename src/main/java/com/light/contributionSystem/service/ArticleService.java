package com.light.contributionSystem.service;

import com.github.pagehelper.PageInfo;
import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.common.input.ContributionParams;
import com.light.contributionSystem.entity.Article;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

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

    /**
     * @description 我的文稿
     **/
    PageInfo myArticle(Integer pageNum, Integer pageSize, HttpSession session);

    /**
     * @description 文稿市场页面
     **/
    PageInfo articleMarket(Integer pageNum, Integer pageSize, String userName);

    /**
     * @description 查看文稿详情
     **/
    Article findArticleDetail(String uuid);

    /**
     * @description 文稿管理页面
     **/
    PageInfo articleManagement(Integer pageNum, Integer pageSize, String userName);

}
