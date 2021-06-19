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
        long millisecond = endTime - beginTime;      //毫秒
        long second = millisecond / 1000;
        long minute = second / 60;
        long hour = minute / 60;
        if (Common.NON_DATE_TIME < hour) {
            return hour + "小时" + minute + "分钟" + second + "秒钟" + millisecond + "毫秒";
        }
        if (Common.NON_DATE_TIME < minute) {
            return minute + "分钟" + second + "秒钟" + millisecond + "毫秒";
        }
        if(Common.NON_DATE_TIME < second){
            return second + "秒钟" + millisecond + "毫秒";
        }
        return millisecond + "毫秒";
    }
}
