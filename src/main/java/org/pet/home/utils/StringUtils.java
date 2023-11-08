package org.pet.home.utils;

/**
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/10/31
 **/
public class StringUtils {
    /**
     * 判断s是否为null
     * @param s
     * @return
     */
    public static boolean isEmpty(String s){
        return s==null||s.isEmpty();
    }

    public static boolean isNullOrNullStr(String s){
        return s==null||s.equals("null");
    }
}
