package com.light.contributionSystem.util;

import java.util.UUID;

/**
 * @author KangXu
 * @description 自动生产uuid工具
 * @className IdUtils
 * @data 2021/6/3 23:07
 */
public class IdUtils {
    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
