package org.pet.home.entity;

import io.swagger.annotations.ApiModel;
<<<<<<< HEAD
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
=======
import lombok.Data;
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63

import java.util.ArrayList;
import java.util.List;

/**
<<<<<<< HEAD
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/10/26
 **/
@ApiModel(value = "部门对象",description = "新增部门参数对象")
@Data
public class Department {
    @ApiModelProperty(value = "部门id",required = true,example = "1")
    private Long id;

    @ApiModelProperty(value = "部门sn",required = true,example = "008")
    private String sn;

    @ApiModelProperty(value = "部门name",required = true,example = "研发部")
    private String name;

    private String dirPath;

    @ApiModelProperty(value = "部门状态",required = true,example = "0")
    private  int state;

    private Employee manager;

    private Long parentId;

    @ApiModelProperty(value = "部门上级",example = "{\"id\":3}")
    private Department parent;

    private List<Department> children = new ArrayList<>();

=======
 * @description: 部门
 * @author: 22866
 * @date: 2023/10/26
 **/
@ApiModel(value = "部门对象",description = "新增部门对象")
@Data
public class Department {
        /*主键*/
        private Long id;
        /*部门编号*/
        private String sn;
        /*部门名称*/
        private String name;
        /*暂时不用*/
        private String dirPath;
        /* 部门 状态0正常，-1 停用*/
        private int state;
        /*部门经理 和员工关联*/
        private Employee manager;
        /*开发部门*/
        private Department parent;

        private long parentId;
        /* 开发部门的子部门 */
        private List<Department> children = new ArrayList<>();
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
}
