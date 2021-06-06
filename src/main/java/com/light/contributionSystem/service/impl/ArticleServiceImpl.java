package com.light.contributionSystem.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.common.Common;
import com.light.contributionSystem.common.input.ContributionParams;
import com.light.contributionSystem.common.output.ArticleRes;
import com.light.contributionSystem.dao.ArticleDao;
import com.light.contributionSystem.dao.SystemUserDao;
import com.light.contributionSystem.entity.Article;
import com.light.contributionSystem.service.ArticleService;
import com.light.contributionSystem.util.IdUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author KangXu
 * @description 文稿表业务层实现
 * @className ArticleServiceImpl
 * @data 2021/6/3 23:33
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleDao articleDao;
    private final SystemUserDao systemUserDao;

    public ArticleServiceImpl(ArticleDao articleDao, SystemUserDao systemUserDao) {
        this.articleDao = articleDao;
        this.systemUserDao = systemUserDao;
    }

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

    /**
     * @description 我的文稿
     **/
    @Override
    public PageInfo myArticle(Integer pageNum, Integer pageSize, HttpSession session) {
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleRes> articleRes = articleDao.
                selectArticleBySystemUser(session.getAttribute("userId").toString());
        return new PageInfo(articleRes);
    }

    /**
     * @description 文稿市场页面
     **/
    @Override
    public PageInfo articleMarket(Integer pageNum, Integer pageSize, String userName) {
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleRes> articleRes = articleDao.selectArticlesByUserName(userName);
        if (!CollectionUtils.isEmpty(articleRes)) {
            for (ArticleRes articleRe : articleRes) {
                articleRe.setAuthor(systemUserDao.selectSystemUserNameByUserId(articleRe.getUserId()));
            }
        }
        return new PageInfo(articleRes);
    }

    /**
     * @description 查看文稿详情
     **/
    @Override
    public Article findArticleDetail(String uuid) {
        return articleDao.selectArticleByUuid(uuid);
    }

    /**
     * @description 文稿管理页面
     **/
    @Override
    public PageInfo articleManagement(Integer pageNum, Integer pageSize, String userName) {
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleRes> articleRes = articleDao.selectArticlesByUserName(userName);
        if (!CollectionUtils.isEmpty(articleRes)) {
            for (ArticleRes articleRe : articleRes) {
                articleRe.setAuthor(systemUserDao.selectSystemUserNameByUserId(articleRe.getUserId()));
            }
        }
        return new PageInfo(articleRes);
    }

}
