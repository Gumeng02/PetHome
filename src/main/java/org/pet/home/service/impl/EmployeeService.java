package org.pet.home.service.impl;

import org.pet.home.entity.Department;
import org.pet.home.entity.Employee;
import org.pet.home.mapper.DepartmentMapper;
import org.pet.home.mapper.EmployeeMapper;
import org.pet.home.net.param.LoginParam;
import org.pet.home.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/10/31
 **/
@Service
public class EmployeeService implements IEmployeeService {

    private EmployeeMapper employeeMapper;
    private DepartmentMapper departmentMapper;

    @Autowired
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


