package org.pet.home.entity;

import lombok.Data;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/13
 */
@Data
public class Location {
    private double longitude;//经度
    private double latitude;//维度
    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
