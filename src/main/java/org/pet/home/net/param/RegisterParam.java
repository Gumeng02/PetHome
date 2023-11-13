package org.pet.home.net.param;

import lombok.Data;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/9
 */
@Data
public class RegisterParam {
    private String username;
    private String phone;
    private String password;
    private int state;
    private int age;
    private Long registertime;
}
