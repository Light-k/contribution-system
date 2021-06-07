package com.light.contributionSystem.dao;

import com.light.contributionSystem.common.output.ArticleRes;
import com.light.contributionSystem.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author KangXu
 * @description 文稿表数据访问层
 * @className ArticleDao
 * @data 2021/6/3 23:30
 */
@Mapper
@Repository
public interface ArticleDao {
    /**
     * @description 添加文稿
     **/
    void insertArticle(Article article);

    /**
     * @description 删除文稿/审核文稿
     **/
    void updateArticle(Article article);

    /**
     * @description 前台查看全部的文稿/根据用户登录名查询文稿
     **/
    List<ArticleRes> selectArticlesByUserNameToFrontPage(@Param("userName") String userName);

    /**
     * @description 后台台查看全部的文稿/根据用户登录名查询文稿
     **/
    List<ArticleRes> selectArticlesByUserNameToBackPage(@Param("userName") String userName);

    /**
     * @description 根据文稿id查看文稿详情
     **/
    Article selectArticleByUuid(@Param("uuid") String uuid);

    /**
     * @description 用户查看文稿
     **/
    List<ArticleRes> selectArticleBySystemUser(@Param("userId") String userId);

}
