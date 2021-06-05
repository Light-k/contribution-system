package com.light.contributionSystem.service.impl;

import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.common.Common;
import com.light.contributionSystem.common.input.ContributionParams;
import com.light.contributionSystem.common.output.ArticleRes;
import com.light.contributionSystem.dao.ArticleDao;
import com.light.contributionSystem.entity.Article;
import com.light.contributionSystem.service.ArticleService;
import com.light.contributionSystem.util.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


/**
 * @author KangXu
 * @description 文稿表业务层实现
 * @className ArticleServiceImpl
 * @data 2021/6/3 23:33
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;

    /**
     * @description 投稿
     **/
    @Override
    public BaseResponse contribution(ContributionParams contributionParams) {
        Article article = new Article();
        article
                .setUuid(IdUtils.getUuid())
                .setUserId(contributionParams.getUserId())
                .setTitle(contributionParams.getTitle())
                .setContent(contributionParams.getContent());
        articleDao.insertArticle(article);
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "投稿成功");
    }

    /**
     * @description 删除文稿
     **/
    @Override
    public BaseResponse delArticleByUuid(String uuid) {
        Article article = articleDao.selectArticleByUuid(uuid);
        article.setDel(1);
        articleDao.updateArticle(article);
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "删除成功");
    }

    /**
     * @description 审核
     **/
    @Override
    public BaseResponse audit(String uuid, String auditStatus, String reason) {
        Article article = articleDao.selectArticleByUuid(uuid);
        article
                .setAuditStatus(auditStatus)
                .setReason(reason);
        articleDao.updateArticle(article);
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "完成审核");
    }

    /**
     * @description 用户编辑文稿
     **/
    @Override
    public BaseResponse editArticle(String uuid, String content) {
        Article article = articleDao.selectArticleByUuid(uuid);
        article.setContent(content);
        articleDao.updateArticle(article);
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "编辑成功");
    }

}
