package org.pet.home.net.param;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/13
 */
public class Result {
    public static JSONObject StringToJson(String s){
        return JSON.parseObject(s);
    }
}
