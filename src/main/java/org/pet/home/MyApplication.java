package org.pet.home;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("org.pet.home.mapper")
public class MyApplication {
    //Springboot的启动
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
