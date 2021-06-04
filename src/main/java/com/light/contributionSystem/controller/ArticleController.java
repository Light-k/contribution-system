package com.light.contributionSystem.controller;

import com.light.contributionSystem.common.BaseResponse;
import com.light.contributionSystem.common.input.AuditParams;
import com.light.contributionSystem.common.input.ContributionParams;
import com.light.contributionSystem.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author KangXu
 * @description 文稿表接口
 * @className ArticleController
 * @data 2021/6/3 23:32
 */
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * @description 添加文稿
     **/
    @PostMapping
    public BaseResponse contribution(@RequestBody @Valid ContributionParams contributionParams) {
        return articleService.contribution(contributionParams);
    }

    /**
     * @description 普通用户删除文稿
     **/
    @DeleteMapping("/user")
    public BaseResponse delArticleBySystemUser(String userId) {
        return articleService.delArticleBySystemUser(userId);
    }

    /**
     * @description 管理员删除文稿
     **/
    @DeleteMapping("/admin")
    public BaseResponse delArticleByUuid(String uuid) {
        return articleService.delArticleByUuid(uuid);
    }

    /**
     * @description 审核
     **/
    @PostMapping("/audit")
    public BaseResponse audit(@RequestBody @Valid AuditParams auditParams) {
        return articleService.audit(auditParams.getUuid(),
                auditParams.getAuditStatus(), auditParams.getReason());
    }

    /**
     * @description 查看全部文稿/根据用户登录名查询文稿
     **/
    @GetMapping
    public BaseResponse findAllArticles(@RequestParam(required = false) Integer page,
                                        @RequestParam(required = false) Integer pageSize,
                                        @RequestParam(required = false) String userName) {
        return articleService.findAllArticles(page, pageSize, userName);
    }

    /**
     * @description 管理员查看文稿详情
     **/
    @GetMapping("/admin/{uuid}")
    public BaseResponse findArticleByAdmin(@PathVariable("uuid") String uuid) {
        return articleService.findArticleByAdmin(uuid);
    }

    /**
     * @description 用户查看文稿
     **/
    @GetMapping("/user/{userId}")
    public BaseResponse findArticleBySystemUser(@PathVariable("userId") String userId) {
        return articleService.findArticleBySystemUser(userId);
    }

    /**
     * @description 用户编辑文稿
     **/
    @PutMapping
    public BaseResponse editArticle(String userId, String content) {
        return articleService.editArticle(userId, content);
    }

}
