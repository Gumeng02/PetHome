package org.pet.home.utils;

import lombok.Data;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/1
 */
@Data
public class DepartmentParam {
    private String sn;
    private String name;
    private String dirPath;
    private  int state;
    private long parentId;

}
