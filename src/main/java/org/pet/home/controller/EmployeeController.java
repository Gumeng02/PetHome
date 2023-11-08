package org.pet.home.controller;

<<<<<<< HEAD
import org.pet.home.common.Constants;
import org.pet.home.entity.Department;
import org.pet.home.entity.Employee;
import org.pet.home.net.NetCode;
import org.pet.home.net.NetResult;
import org.pet.home.service.IDepartmentService;
import org.pet.home.service.IEmployeeService;
import org.pet.home.utils.MD5Util;
import org.pet.home.utils.ResultGenerator;
import org.pet.home.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
=======
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.pet.home.entity.Department;
import org.pet.home.entity.Employee;
import org.pet.home.service.IDepartmentService;
import org.pet.home.service.IEmployeeService;
import org.pet.home.utils.*;
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
<<<<<<< HEAD
 * 雇员控制器
 */
=======
 * @description:TODO类描述
 * @author: 顾梦
 * @data: 2023/10/30
 **/
@Api(tags = "员工接口文档")
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private IDepartmentService iDepartmentService;
    private IEmployeeService iEmployeeService;
<<<<<<< HEAD
    private RedisTemplate redisTemplate;

    @Autowired
    public EmployeeController(IDepartmentService iDepartmentService,IEmployeeService iEmployeeService,RedisTemplate redisTemplate){
        this.iDepartmentService = iDepartmentService;
        this.iEmployeeService = iEmployeeService;
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/add")
    public NetResult add(@RequestBody Employee employee){
        Employee employee1 = iEmployeeService.findByUsername(employee.getUsername());
        if(employee1!=null){
            return ResultGenerator.genErrorResult(NetCode.USERNAME_INVALID,"已有该名,不能继续添加");
        }
        if (StringUtils.isEmpty(employee.getPhone())){
            return ResultGenerator.genErrorResult(NetCode.PHONE_INVALID, Constants.PHONE_IS_NULL);
        }
        if (StringUtils.isEmpty(employee.getUsername())){
            return ResultGenerator.genErrorResult(NetCode.USERNAME_INVALID,"用户名不能为空");
        }
        //没有密码默认123456，进行md5加密
        if (StringUtils.isEmpty(employee.getPassword())){
            employee.setPassword(MD5Util.MD5Encode("123456","utf-8"));
        }else {
            employee.setPassword(MD5Util.MD5Encode(employee.getPassword(),"utf-8"));
        }
        if (StringUtils.isEmpty(employee.getEmail())){
            return ResultGenerator.genErrorResult(NetCode.EMAIL_INVALID,"邮箱不能为空");
        }
        Department department = iDepartmentService.find(employee.getDid());
        if(department==null){
            return ResultGenerator.genErrorResult(NetCode.DID_INVALID,"非法部门id");
        }

        boolean result = iEmployeeService.add(employee);
        if (!result){
            return ResultGenerator.genFailResult("添加失败");
=======

    public EmployeeController(IDepartmentService iDepartmentService, IEmployeeService iEmployeeService) {
        this.iDepartmentService = iDepartmentService;
        this.iEmployeeService = iEmployeeService;
    }

    @ApiOperation("添加员工")
    @PostMapping("/add")
    public NetResult add(@RequestBody Employee employee) {
        if (StringUtil.isEmpty(employee.getPhone())) {
            return ResultGenerator.genErrorResult(NetCode.PHONE_INVALID, "手机号不能为空");
        }
        if (StringUtil.isEmpty(employee.getEmail())) {
            return ResultGenerator.genErrorResult(NetCode.EMAIL_INVALID, "邮箱不能为空");
        }
        if (StringUtil.isEmpty(employee.getUsername())) {
            return ResultGenerator.genErrorResult(NetCode.USERNAME_INVALID, "用户名不能为空");
        }
        if (StringUtil.isEmpty(employee.getPassword())) {
            //如果密码为空设置默认密码
            employee.setPassword(MD5Util.MD5Encode("123456", "UTF-8"));
        }
        Department department = iDepartmentService.find(employee.getDid());
        if (department == null) {
            return ResultGenerator.genErrorResult(NetCode.DEPARTMENT_ID_INVALID, "部门id异常");
        }
        Employee e = iEmployeeService.checkPhone(employee.getPhone());
        if(e!=null){
            return ResultGenerator.genErrorResult(NetCode.PHONE_OCCUPANCY, "该手机号已被使用");
        }
        boolean result = iEmployeeService.add(employee);
        if (!result) {
            return ResultGenerator.genFailResult("添加员工失败");
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
        }
        return ResultGenerator.genSuccessResult(employee);
    }

<<<<<<< HEAD
    @PostMapping("/delete")
    public NetResult delete(Long id){

        System.out.println("---------");
        System.out.println(id);
        int result = iEmployeeService.delete(id);
        if (result==1){
            return ResultGenerator.genSuccessResult(id+"删除成功");
        }
        return ResultGenerator.genSuccessResult(id+"删除失败");
    }

    @PostMapping("/edit")
    public NetResult edit(@RequestBody Employee employee){
        System.out.println("-------------");
        System.out.println(employee);
        try {
//            Employee employee1 = iEmployeeService.findById(employee.getId());
//            //密码要md5加密
            if (!StringUtils.isEmpty(employee.getPassword())){
                employee.setPassword(MD5Util.MD5Encode(employee.getPassword(),"utf-8"));
            }
//            if(StringUtils.isEmpty(employee.getUsername())){
//                employee.setUsername(employee1.getUsername());
//            }
//            if(StringUtils.isEmpty(employee.getEmail())){
//                employee.setEmail(employee1.getEmail());
//            }
//            if(StringUtils.isEmpty(employee.getPhone())){
//                employee.setPhone(employee1.getPhone());
//            }
//            if(employee.getAge()!=employee1.getAge()){
//                employee.setAge(employee1.getAge());
//            }
            iEmployeeService.update(employee);
            return ResultGenerator.genSuccessResult("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genErrorResult(NetCode.UPDATE_INVALID_ERROR,"修改信息失败！"+e.getMessage());
        }
    }

    @GetMapping("/find")
    public NetResult find(Long id){
        Employee employee = iEmployeeService.findById(id);
        return  ResultGenerator.genSuccessResult(employee);
    }

    @GetMapping("/findall")
    public NetResult findAll(){
        List<Employee> employees = iEmployeeService.findAll();
        return ResultGenerator.genSuccessResult(employees);
    }

=======
    @GetMapping("/list")
    public NetResult list(){
        List<Employee> employees = iEmployeeService.list();
        return ResultGenerator.genSuccessResult(employees);
    }

    @PostMapping("/delete")
    public NetResult delete(Long id) {
        try {
            iEmployeeService.remove(id);
            return ResultGenerator.genSuccessResult(id);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genErrorResult(NetCode.REMOVE_EMPLOYEE_ERROR,"删除员工失败！"+e.getMessage());
        }
    }

    @PostMapping("/update")
    public NetResult update(@RequestBody Employee employee){
        if (StringUtil.isEmpty(employee.getPhone())) {
            return ResultGenerator.genErrorResult(NetCode.PHONE_INVALID, "手机号不能为空");
        }
        if (StringUtil.isEmpty(employee.getEmail())) {
            return ResultGenerator.genErrorResult(NetCode.EMAIL_INVALID, "邮箱不能为空");
        }
        if (StringUtil.isEmpty(employee.getUsername())) {
            return ResultGenerator.genErrorResult(NetCode.USERNAME_INVALID, "用户名不能为空");
        }
        if (StringUtil.isEmpty(employee.getPassword())) {
            //如果密码为空设置默认密码
            employee.setPassword(MD5Util.MD5Encode("123456", "UTF-8"));
        }
        Department department = iDepartmentService.find(employee.getDid());
        if (department == null) {
            return ResultGenerator.genErrorResult(NetCode.DEPARTMENT_ID_INVALID, "部门id异常");
        }
        Employee e = iEmployeeService.checkPhone(employee.getPhone());
        if(e!=null){
            return ResultGenerator.genErrorResult(NetCode.PHONE_OCCUPANCY, "该手机号已被使用");
        }
        iEmployeeService.update(employee);
        return ResultGenerator.genSuccessResult(employee);
    }

>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
}
