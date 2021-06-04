package com.light.contributionSystem.common.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author KangXu
 * @description 审核文稿入参
 * @className AuditParams
 * @data 2021/6/4 13:27
 */
@Data
public class AuditParams {
    /**
     * @description 文稿id
     **/
    @NotBlank
    private String uuid;
    /**
     * @description 审核状态
     **/
    @NotBlank
    private String auditStatus;
    /**
     * @description 审核理由
     **/
    private String reason = "";
}
