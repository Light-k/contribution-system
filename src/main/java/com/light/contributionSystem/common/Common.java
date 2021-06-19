package com.light.contributionSystem.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.*;

/**
 * @author KangXu
 * @description 公共常量
 * @className Common
 * @data 2021/6/3 22:24
 */
public class Common {

    /**
     * @description 响应成功
     **/
    public static final String SUCCESS_RESPONSE_STATUS = "success";

    /**
     * @description 响应失败
     **/
    public static final String ERROR_RESPONSE_STATUS = "error";

    /**
     * @description 响应成功状态码
     **/
    public static final Integer SUCCESS_RESPONSE_STATUS_CODE = 0;

    /**
     * @description 响应失败状态码
     **/
    public static final Integer ERROR_RESPONSE_STATUS_CODE = 500;

    /**
     * @description 标志是否存在该时间
     **/
    public static final Long NON_DATE_TIME = 0L;

    /**
     * @description 用户昵称的长度
     **/
    public static final Integer USER_NAME_LENGTH = 2;

    /**
     * @description 字符出现的次数
     **/
    public static final Integer APPEAR_NUMBER_FOUR = 4;
    public static final Integer APPEAR_NUMBER_THREE = 3;

    /**
     * @description 文稿的请求操作
     **/
    public static final String INSERT_ARTICLE_URL = "/article";
    public static final String DELETE_ARTICLE_URL = "/article/";
    public static final String AUDIT_ARTICLE_URL = "/article/audit";
    public static final String UPDATE_ARTICLE_URL = "/article//";
    public static final String UPDATE_ARTICLE_MANAGEMENT_URL = "/articleManagement";
    public static final String UPDATE_ARTICLE_MARKET_URL = "/articleMarket";

    /**
     * @description 请求接口对应的功能集合
     **/
    public static final List<BusinessFunction> listCache = Collections.synchronizedList(new ArrayList<>());
    public static final Map<String, String> mapCache = Collections.synchronizedMap(new HashMap<>());

    /**
     * @description 初始化缓存
     **/
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Accessors(chain = true)
    public static class BusinessFunction {
        /**
         * @description 请求的地址
         **/
        private String url;
        /**
         * @description 对应的功能
         **/
        private String function;
    }

    /**
     * @description 请求对应的功能列表
     **/
    public static final String[] businessFunctions = {
            "/frontPage:前往前台首页", "/backPage:前往后台首页", "/addArticle:前往添加页面",
            "/myArticle:前往我的文稿页面", "/frontPage/articleDetail/:前往前台文稿详情页面",
            "/updArticle/:前往编辑文稿页面", "/backPage/articleDetail/:前往后台文稿详情页面"
    };

    /**
     * @description 添加缓存
     **/
    public static void addCache() {
        for (int i = 0; i < businessFunctions.length; i++) {
            BusinessFunction businessFunction = new BusinessFunction();
            businessFunction
                    .setUrl(businessFunctions[i].split(":")[0])
                    .setFunction(businessFunctions[i].split(":")[1]);
            listCache.add(businessFunction);
        }
        mapCache.put("/articleMarket", "前往文稿市场页面");
        mapCache.put("/articleManagement", "前往文稿管理页面");
        mapCache.put("/article", "添加文稿功能");
        mapCache.put("/article/", "删除文稿功能");
        mapCache.put("/article/audit", "审核文稿功能");
        mapCache.put("/article//", "编辑文稿功能");
    }

}
