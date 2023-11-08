package org.pet.home.service;

import org.pet.home.entity.Employee;
<<<<<<< HEAD
import org.pet.home.net.param.LoginParam;
=======
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63

import java.util.List;

/**
<<<<<<< HEAD
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
    Employee select(String phone,String password);
=======
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
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
}
