package org.pet.home.service.impl;

<<<<<<< HEAD
import org.pet.home.entity.Department;
import org.pet.home.entity.Employee;
import org.pet.home.mapper.DepartmentMapper;
import org.pet.home.mapper.EmployeeMapper;
import org.pet.home.net.param.LoginParam;
import org.pet.home.service.IEmployeeService;
=======
import org.pet.home.entity.Employee;
import org.pet.home.service.IEmployeeService;
import org.pet.home.entity.Department;
import org.pet.home.mapper.DepartmentMapper;
import org.pet.home.mapper.EmployeeMapper;
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
<<<<<<< HEAD
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/10/31
 **/
@Service
public class EmployeeService implements IEmployeeService {

=======
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/1
 */
@Service
public class EmployeeService implements IEmployeeService {
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
    private EmployeeMapper employeeMapper;
    private DepartmentMapper departmentMapper;

    @Autowired
<<<<<<< HEAD
    public  EmployeeService(EmployeeMapper employeeMapper,DepartmentMapper departmentMapper){
        this.employeeMapper =employeeMapper;
        this.departmentMapper = departmentMapper;
    }
    @Override
    public boolean add(Employee employee) {
        int row = employeeMapper.add(employee);
        if (row==0){
            return false;
        }else {
            Department department = this.departmentMapper.find(employee.getDid());
            employee.setDepartment(department);
            return true;
        }
    }

    @Override
    public int delete(Long id) {
        return employeeMapper.delete(id);
    }

    @Override
    public Employee findIncumbency(Long id) {
        return employeeMapper.findIncumbency(id);
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeMapper.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeMapper.findAll();
    }

    @Override
    public Employee findByUsername(String username) {
        return employeeMapper.findByUsername(username);
    }

    @Override
    public Employee login(LoginParam loginParam) {
        return employeeMapper.login(loginParam);
    }

    @Override
    public Employee select(String phone, String password) {
        return employeeMapper.select(phone, password);
    }
}


=======
    public EmployeeService(EmployeeMapper employeeMapper,DepartmentMapper departmentMapper){
        this.employeeMapper = employeeMapper;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public boolean add(Employee e) {
        int rows = employeeMapper.add(e);
        if(rows == 0){
            //添加失败
            return false;
        }
//        if(employeeMapper.checkPhone(e.getPhone())!=null){
//            //如果号码已被注册 则添加失败
//            return false;
//        }
        else {
            Department department = departmentMapper.find(e.getDid());
            e.setDepartment(department);
            return true;
        }

    }

    @Override
    public Employee checkPhone(String phone) {
        return employeeMapper.checkPhone(phone);
    }

    @Override
    public List< Employee > list() {
        return employeeMapper.list();
    }

    @Override
    public void remove(Long id) {
        employeeMapper.remove(id);
    }

    @Override
    public void update(Employee e) {
        employeeMapper.update(e);
    }
}
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
