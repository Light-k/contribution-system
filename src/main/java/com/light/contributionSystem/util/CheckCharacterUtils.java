package com.light.contributionSystem.util;

/**
 * @author KangXu
 * @description 检测字符出现的次数
 * @className CheckCharacter
 * @data 2021/6/19 23:37
 */
public class CheckCharacterUtils {
    /**
     * @description 初始化次数
     **/
    private static Integer counts = 0;

    /**
     * @description 检测字符出现的次数
     **/
    public static Integer getCounts(String sourceStr, String character) {
        char[] array = sourceStr.toCharArray();
        for (char c : array) {
            if (character.equals(String.valueOf(c))){
                counts++;
            }
        }
        return counts;
    }
}
