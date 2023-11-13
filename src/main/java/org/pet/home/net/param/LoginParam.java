package org.pet.home.net.param;

import lombok.Data;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/8
 */
@Data
public class LoginParam {
    String phone;
    String password;
    String username;
    //type 1管理员 type 0用户
    private int type;
}
