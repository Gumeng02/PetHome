package org.pet.home.utils;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/1
 */
public class StringUtil {
    /**
     * 判断字符串 s 是否为空 或者为null
     * @param s
     * @return
     */
    public static boolean isEmpty(String s){
        return s == null || s.isEmpty() || s.equals("null");
    }
}
