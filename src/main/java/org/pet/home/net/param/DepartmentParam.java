package org.pet.home.net.param;


import lombok.Data;

/**
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/10/27
 **/

@Data
public class DepartmentParam {


    private String sn;
    private String name;
    private String dirPath;
    private  int state;

    private long parentId;

}
