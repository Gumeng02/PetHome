package org.pet.home.entity;

import lombok.Data;
<<<<<<< HEAD
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
=======
import org.pet.home.entity.Department;
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63

/**
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/10/26
 **/
<<<<<<< HEAD
@Getter
@Setter
@Data
public class Employee implements Serializable {
    public Long id;
    //员工部门id
    private Long did;
    //员工名称
    private String username;
    //邮箱
    private String email;
    //手机号
    private String phone;
    //密码
    private String password;
    //年龄
    private int age;
    //状态0正常 1离职
    private int state;
    //方便传数据的
    private Department department;

    private String token;

}
=======
@Data
public class Employee {
    /*主键*/
    private Long id;
    /* 对应部门id 关联表 department 中的id */
    private Long did;
    /*员工名称*/
    private String username;
    /*员工邮箱*/
    private String email;
    /*员工手机号码*/
    private String phone;
    /*员工密码*/
    private String password;
    /*员工年龄*/
    private int age;
    /* 部门 状态0正常，-1 停用*/
    private int state;
    /* 所属部门 */
    private Department department;
}

>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
