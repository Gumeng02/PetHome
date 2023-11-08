package org.pet.home;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

<<<<<<< HEAD
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

=======

@SpringBootApplication
@MapperScan("org.pet.home.mapper")
public class MyApplication {
    //Springboot的启动
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
}
