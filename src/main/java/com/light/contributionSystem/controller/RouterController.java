package com.light.contributionSystem.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.common.output.ArticleRes;
import com.light.contributionSystem.dao.ArticleDao;
import com.light.contributionSystem.dao.SystemUserDao;
import com.light.contributionSystem.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author KangXu
 * @description 路由层
 * @className RouterController
 * @data 2021/6/5 2:27
 */
@Controller
public class RouterController {

    private final ArticleDao articleDao;
    private final SystemUserDao systemUserDao;

    public RouterController(ArticleDao articleDao, SystemUserDao systemUserDao) {
        this.articleDao = articleDao;
        this.systemUserDao = systemUserDao;
    }

    /**
     * @description 注册页面
     **/
    @GetMapping("/toRegister")
    public String register() {
        return "user/register";
    }

    /**
     * @description 登录页面
     **/
    @GetMapping("/toLogin")
    public String toLogin() {
        return "index";
    }

    /**
     * @description 前台主页
     **/
    @GetMapping("/frontPage")
    public String frontPage() {
        return "user/userMain";
    }

    /**
     * @description 后台主页
     **/
    @GetMapping("/backPage")
    public String backPage() {
        return "admin/adminMain";
    }

    /**
     * @description 退出
     **/
    @GetMapping("/exit")
    public String exit(HttpSession session) {
        session.removeAttribute("userName");
        session.removeAttribute("userId");
        return "redirect:/toLogin";
    }

    /**
     * @description 我的文稿页面
     **/
    @GetMapping("/myArticle/{pageNum}/{pageSize}")
    public String myArticle(@PathVariable("pageNum") Integer pageNum,
                            @PathVariable("pageSize") Integer pageSize,
                            HttpSession session,
                            Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleRes> articleRes = articleDao.
                selectArticleBySystemUser(session.getAttribute("userId").toString());
        PageInfo pageInfo = new PageInfo(articleRes);
        model.addAttribute("pageInfo", pageInfo);
        return "user/myArticle";
    }

    /**
     * @description 文稿市场页面
     **/
    @GetMapping("/articleMarket/{pageNum}/{pageSize}")
    public String articleMarket(@PathVariable("pageNum") Integer pageNum,
                                @PathVariable("pageSize") Integer pageSize,
                                @RequestParam(required = false) String userName,
                                Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleRes> articleRes = articleDao.selectArticlesByUserName(userName);
        if (!CollectionUtils.isEmpty(articleRes)) {
            for (ArticleRes articleRe : articleRes) {
                articleRe.setAuthor(systemUserDao.selectSystemUserNameByUserId(articleRe.getUserId()));
            }
        }
        PageInfo pageInfo = new PageInfo(articleRes);
        model.addAttribute("pageInfo", pageInfo);
        return "user/articleMarket";
    }

    /**
     * @description 添加文稿页面
     **/
    @GetMapping("/addArticle")
    public String addArticle() {
        return "user/addArticle";
    }

    /**
     * @description 前台文稿详情页面
     **/
    @GetMapping("/frontPage/articleDetail/{uuid}")
    public String frontPageArticleDetail(@PathVariable("uuid") String uuid, Model model) {
        Article article = articleDao.selectArticleByUuid(uuid);
        model.addAttribute("article", article);
        return "user/articleDetail";
    }

    /**
     * @description 编辑文稿页面
     **/
    @GetMapping("/updArticle/{uuid}")
    public String updArticle(@PathVariable("uuid") String uuid, Model model) {
        Article article = articleDao.selectArticleByUuid(uuid);
        model.addAttribute("article", article);
        return "user/updArticle";
    }

    /**
     * @description 文稿管理页面
     **/
    @GetMapping("/articleManagement/{pageNum}/{pageSize}")
    public String articleManagement(@PathVariable("pageNum") Integer pageNum,
                                    @PathVariable("pageSize") Integer pageSize,
                                    @RequestParam(required = false) String userName,
                                    Model model) {
        PageHelper.startPage(pageNum, pageSize);
        List<ArticleRes> articleRes = articleDao.selectArticlesByUserName(userName);
        if (!CollectionUtils.isEmpty(articleRes)) {
            for (ArticleRes articleRe : articleRes) {
                articleRe.setAuthor(systemUserDao.selectSystemUserNameByUserId(articleRe.getUserId()));
            }
        }
        PageInfo pageInfo = new PageInfo(articleRes);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/articleList";
    }

    /**
     * @description 后台文稿详情页面
     **/
    @GetMapping("/backPage/articleDetail/{uuid}")
    public String backPageArticleDetail(@PathVariable("uuid") String uuid, Model model) {
        Article article = articleDao.selectArticleByUuid(uuid);
        model.addAttribute("article", article);
        return "admin/articleDetail";
    }

}
