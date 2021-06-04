package com.light.contributionSystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;

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
     * @description 普通用户删除文稿
     **/
    @Override
    public BaseResponse delArticleBySystemUser(String userId) {
        Article article = articleDao.selectArticleByUserId(userId);
        article.setDel(0);
        articleDao.updateArticle(article);
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "删除成功");
    }

    /**
     * @description 管理员删除文稿
     **/
    @Override
    public BaseResponse delArticleByUuid(String uuid) {
        Article article = articleDao.selectArticleByUuid(uuid);
        article.setDel(0);
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
     * @description 查看全部文稿/根据用户登录名查询文稿
     **/
    @Override
    public BaseResponse findAllArticles(Integer page, Integer pageSize, String userName) {
        List<ArticleRes> articleRes;
        PageHelper.startPage(page, pageSize, true);
        if (null == userName || "".equals(userName)) {
            articleRes = articleDao.selectAllArticle();
        } else {
            articleRes = articleDao.selectArticlesByUserName(userName);
        }
        if (CollectionUtils.isEmpty(articleRes)) {
            return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "暂无文稿");
        }
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, PageInfo.of(articleRes), null);
    }

    /**
     * @description 根据文稿id查看文稿详情
     **/
    @Override
    public BaseResponse findArticleByAdmin(String uuid) {
        ArticleRes articleRes = articleDao.selectArticleByAdmin(uuid);
        if (ObjectUtils.isEmpty(articleRes)) {
            return BaseResponse.resp(Common.ERROR_RESPONSE_STATUS, "文稿不存在");
        }
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, articleRes, null);
    }

    /**
     * @description 用户编辑文稿
     **/
    @Override
    public BaseResponse editArticle(String userId, String content) {
        Article article = articleDao.selectArticleByUserId(userId);
        if (!Article.STATUS_PASSED.equals(article.getAuditStatus())) {
            article.setContent(content);
            return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "编辑成功");
        }
        return BaseResponse.resp(Common.ERROR_RESPONSE_STATUS, "不能编辑已过审的文稿");
    }

    /**
     * @description 用户查看文稿
     **/
    @Override
    public BaseResponse findArticleBySystemUser(String userId) {
        ArticleRes articleRes = articleDao.selectArticleBySystemUser(userId);
        if (ObjectUtils.isEmpty(articleRes)) {
            return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, "暂无文稿");
        }
        return BaseResponse.resp(Common.SUCCESS_RESPONSE_STATUS, articleRes, null);
    }

}
