package com.light.contributionSystem.util;

import com.light.contributionSystem.common.Common;


/**
 * @author KangXu
 * @description 时间工具类
 * @className DateUtils
 * @data 2021/6/8 18:01
 */
public class DateUtils {
    /**
     * @description 计算时间差
     **/
    public static String getTimeDifference(Long beginTime, Long endTime) {
        long timeDifference = endTime - beginTime;      //毫秒
        long second = timeDifference / 1000;
        long minute = second / 60;
        long hour = minute / 60;
        if (Common.non_dateTime < hour) {
            return hour + "h" + minute + "m" + second + "s";
        }
        if (Common.non_dateTime < minute) {
            return minute + "m" + second + "s";
        }
        return second + "s";
    }
}
