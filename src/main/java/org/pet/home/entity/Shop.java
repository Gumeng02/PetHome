package org.pet.home.entity;

import lombok.Data;

/**
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/3
 **/
@Data
public class Shop {
    private Long id;
    private String name;
    private String tel;
    private Long registerTime;
    private int state;
    private String address;
    private String logo;
    private Employee admin;
    private Long adminId;
}
