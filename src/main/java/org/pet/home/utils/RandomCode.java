package org.pet.home.utils;
import java.util.concurrent.ThreadLocalRandom;
/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/12
 */
public class RandomCode {
    public static String getCode(){
        return String.format("%06d", ThreadLocalRandom.current().nextInt(1000000));
    }
}
