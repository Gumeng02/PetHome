package org.pet.home;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * (exclude = { DataSourceAutoConfiguration.class })
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/10/26
 **/
@SpringBootApplication
@MapperScan("org.pet.home.mapper")
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

}
