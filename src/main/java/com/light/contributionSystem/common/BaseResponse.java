package com.light.contributionSystem.common;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * @author KangXu
 * @description 基本返回值
 * @className BaseResponse
 * @data 2021/6/3 22:16
 */
@Data
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {
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
     * @description 返回的数据
     **/
    private T data;

    private BaseResponse(String status, Integer statusCode, String msg) {
        this.status = status;
        this.statusCode = statusCode;
        this.msg = msg;
    }

    private BaseResponse(String status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    private BaseResponse(String status, T data) {
        this.status = status;
        this.data = data;
    }

    private BaseResponse(String status) {
        this.status = status;
    }

    /**
     * @description 统一返回方法
     **/
    public static <T> BaseResponse resp(String status, T data, String msg) {
        if (null == msg) {
            return new BaseResponse(status, data);
        }
        return new BaseResponse(status, data, msg);
    }

    /**
     * @description 统一返回方法
     **/
    public static BaseResponse resp(String status, String msg) {
        if (Common.SUCCESS_RESPONSE_STATUS.equals(status)) {
            if (null == msg) {
                return new BaseResponse(status);
            }
            return new BaseResponse(status, Common.SUCCESS_RESPONSE_STATUS_CODE, msg);
        }
        return new BaseResponse(status, Common.ERROR_RESPONSE_STATUS_CODE, msg);
    }
}
