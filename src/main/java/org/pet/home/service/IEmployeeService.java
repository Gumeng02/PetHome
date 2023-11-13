package org.pet.home.service;


import org.pet.home.entity.Employee;
import org.pet.home.net.param.LoginParam;


import java.util.List;

/**
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/10/31
 **/
public interface IEmployeeService {
    boolean add(Employee employee);

    int delete(Long id);

    Employee findIncumbency(Long id);

    void update(Employee employee);

    Employee findById(Long id);

    List<Employee> findAll();

    Employee findByUsername(String username);

    Employee login(LoginParam loginParam);

    Employee select(String phone, String password);
}
