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
     * @description 删除文稿
     **/
    @DeleteMapping("/{uuid}")
    public BaseResponse delArticleByUuid(@PathVariable("uuid") String uuid) {
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
     * @description 用户编辑文稿
     **/
    @PutMapping("/{uuid}/{content}")
    public BaseResponse editArticle(@PathVariable("uuid") String uuid,
                                    @PathVariable("content") String content) {
        return articleService.editArticle(uuid, content);
    }

}
