package com.light.contributionSystem.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author KangXu
 * @description 基本返回值
 * @className BaseResponse
 * @data 2021/6/3 22:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse implements Serializable {
    /**
     * @description 返回的状态
     **/
    private String status;
    /**
     * @description 返回的状态码
     **/
    private Integer statusCode;
    /**
     * @description 返回的提示信息
     **/
    private String msg;

    /**
     * @description 统一返回方法
     **/
    public static BaseResponse resp(String status, String msg) {
        if (Common.SUCCESS_RESPONSE_STATUS.equals(status)) {
            return new BaseResponse(status, Common.SUCCESS_RESPONSE_STATUS_CODE, msg);
        }
        return new BaseResponse(status, Common.ERROR_RESPONSE_STATUS_CODE, msg);
    }
}
