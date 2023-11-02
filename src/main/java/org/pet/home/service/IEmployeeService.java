package org.pet.home.service;

import org.pet.home.entity.Employee;

import java.util.List;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/1
 */
public interface IEmployeeService {

    /**
     * 添加用户
     * @param e
     * @return
     */
    boolean add(Employee e);

    /**
     * 检查某号码对应的用户是否存在
     * @param phone
     * @return
     */
    Employee checkPhone(String phone);

    List<Employee> list();

    void remove(Long id);

    void update(Employee e);
}
