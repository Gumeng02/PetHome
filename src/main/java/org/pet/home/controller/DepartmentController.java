package org.pet.home.controller;

<<<<<<< HEAD
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.pet.home.entity.Department;
import org.pet.home.net.NetCode;
import org.pet.home.net.NetResult;
import org.pet.home.net.param.DepartmentParam;
import org.pet.home.service.IDepartmentService;
import org.pet.home.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
=======

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.pet.home.entity.Department;
import org.pet.home.service.IDepartmentService;
import org.pet.home.utils.DepartmentParam;
import org.pet.home.utils.NetCode;
import org.pet.home.utils.NetResult;
import org.pet.home.utils.ResultGenerator;
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD
=======

>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
/**
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/10/26
 **/
@Api(tags = "部门接口文档")
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private IDepartmentService iDepartmentService;

<<<<<<< HEAD
    @Autowired
    public DepartmentController(IDepartmentService iDepartmentService){
=======
    public DepartmentController(IDepartmentService iDepartmentService) {
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
        this.iDepartmentService = iDepartmentService;
    }

    @ApiOperation("添加部门")
    @PostMapping("/add")
    public NetResult add(@RequestBody  DepartmentParam departmentParam){
        System.out.println("--------------"+departmentParam);
        try {
            Department department = new Department();
            department.setSn(departmentParam.getSn());
            department.setName(departmentParam.getName());

            long parent_id = departmentParam.getParentId();
            Department parentDepartment = new Department();
            parentDepartment.setId(parent_id);
            department.setParent(parentDepartment);

            iDepartmentService.add(department);
            return ResultGenerator.genSuccessResult(department);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genErrorResult(NetCode.CREATE_DEPARTMENT_ERROR,"保存部门失败！"+e.getMessage());
        }
    }

    @PostMapping("/delete")
<<<<<<< HEAD
    public NetResult delete(Long id){
        System.out.println(id);
        try {
            iDepartmentService.remove(id);
            return ResultGenerator.genSuccessResult(id);
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genErrorResult(NetCode.REMOVE_DEPARTMENT_ERROR,"删除部门失败！"+e.getMessage());
=======
    public NetResult delete(Long id) {
        try {
            iDepartmentService.remove(id);
            return ResultGenerator.genSuccessResult(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genErrorResult(NetCode.REMOVE_DEPARTMENT_ERROR, "删除部门失败！" + e.getMessage());
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
        }
    }

    @PostMapping("/update")
<<<<<<< HEAD
    public NetResult update(@RequestBody Department department){
        try {
            iDepartmentService.update(department);
            return ResultGenerator.genSuccessResult();
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genErrorResult(NetCode.UPDATE_DEPARTMENT_ERROR,"更新部门失败！"+e.getMessage());
=======
    public NetResult update(@RequestBody Department department) {
        try {
            iDepartmentService.update(department);
            return ResultGenerator.genSuccessResult();
        } catch (Exception e) {
            e.printStackTrace();
            return ResultGenerator.genErrorResult(NetCode.UPDATE_DEPARTMENT_ERROR, "更新部门失败！" + e.getMessage());
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
        }
    }

    @GetMapping("/get")
<<<<<<< HEAD
    public NetResult get(Long id){
=======
    public NetResult get(Long id) {
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
        Department department = iDepartmentService.find(id);
        return ResultGenerator.genSuccessResult(department);
    }

    @GetMapping("/list")
<<<<<<< HEAD
    public NetResult list(){
=======
    public NetResult list() {
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
        List<Department> department = iDepartmentService.findAll();
        return ResultGenerator.genSuccessResult(department);
    }

    @GetMapping("/tree")
<<<<<<< HEAD
    public NetResult tree(){
        List<Department> departments = iDepartmentService.getDepartmentTreeData();
        return ResultGenerator.genSuccessResult(departments);
=======
    public NetResult tree() {
        List<Department> department = iDepartmentService.getDepartmentTreeData();
        return ResultGenerator.genSuccessResult(department);
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
    }
}
