package org.pet.home.mapper;

<<<<<<< HEAD
import jdk.nashorn.internal.objects.annotations.Setter;
=======
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
import org.apache.ibatis.annotations.*;
import org.pet.home.common.DepartmentQuery;
import org.pet.home.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

<<<<<<< HEAD
/**
 * @description: TODO 类描述
=======

/**
 * @description:
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
 * @author: 顾梦
 * @date: 2023/10/26
 **/
@Mapper
@Repository
public interface DepartmentMapper {
<<<<<<< HEAD

=======
    /**
     * 创建部门
     * @param d Department
     */
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
    @Insert("insert into t_department(sn,name,manager_id,parent_id,state)" +
            "values(#{sn},#{name},#{manager.id},#{parent.id},#{state})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void add(Department d);

<<<<<<< HEAD
    @Delete("delete from t_department where id=#{id}")
    void remove(Long id);

=======
    /**
     * 删除部门
     * @param id
     */
    @Delete("delete from t_department where id=#{id}")
    void remove(Long id);

    /**
     * 修改部门
     * @param d
     */
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
    @Update("update t_department set " +
            "sn=#{sn},name=#{name},manager_id=#{manager.id}," +
            "parent_id=#{parent.id},state=#{state} " +
            "where id=#{id}")
    void update(Department d);

<<<<<<< HEAD


=======
    /**
     * 查询对应id部门
     * @param id
     * @return
     */
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
    @Select("select * from t_department where id=#{id}")
    @Results({
            @Result(
                    property = "id",
                    column = "id"
            ),
            @Result(
                    property = "parent",
                    column = "parent_id",
                    javaType = Department.class,
                    one = @One(select = "org.pet.home.mapper.DepartmentMapper.findParentDepartment")
            ),
            @Result(
                    property = "children",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "org.pet.home.mapper.DepartmentMapper.findSubDepartments")
            )
    })
    Department find(Long id);

<<<<<<< HEAD
=======
    /**
     * 查询所有部门
     * @return
     */
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
    @Select("select * from t_department")
    @Results({
            @Result(
                    property = "id",
                    column = "id"
            ),
            @Result(
                    property = "parentId",
                    column = "parent_id"
            ),
            @Result(
                    property = "parent",
                    column = "parent_id",
                    javaType = Department.class,
                    one = @One(select = "org.pet.home.mapper.DepartmentMapper.findParentDepartment")
            ),
            @Result(
                    property = "children",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "org.pet.home.mapper.DepartmentMapper.findSubDepartments")
            )
    })
    List<Department> findAll();

    /**
     * 查询id的所有的子部门
     * @param id
     * @return
     */
<<<<<<< HEAD
    @Results({
            @Result(
                    property = "id",
                    column = "id"
            ),
            @Result(
                    property = "parent",
                    column = "parent_id",
                    javaType = Department.class,
                    one = @One(select = "org.pet.home.mapper.DepartmentMapper.findParentDepartment")
=======
    @Results({//@Results批注用于定义查询的结果映射
            @Result(
                    property = "id", //“id”属性映射到结果集中的“id”列
                    column = "id"
            ),
            @Result(
                    property = "parent", //“parent”属性映射到结果集中的“parent_id”列
                    column = "parent_id",
                    javaType = Department.class,//映射类型
                    one = @One(select = "org.pet.home.mapper.DepartmentMapper.findParentDepartment")
                    //one 属性指定这是一对一映射
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
            ),

    })
    @Select("select * from t_department where parent_id=#{id}")
    List<Department> findSubDepartments(Long id);


    /**
     * 查询id = parent_ id的数据，用来查询id的 parent的组织
     * @param parent_id
     * @return
     */
    @Select("select * from t_department where id=#{parent_id}")
    @Results({
            @Result(
                    property = "id",
                    column = "id"
            ),
            @Result(
                    property = "parent",
                    column = "parent_id",
                    javaType = Department.class,
                    one = @One(select = "org.pet.home.mapper.DepartmentMapper.findParentDepartment")
            )
    })
    Department findParentDepartment(Long parent_id);


    @Select("select count(*) from t_department")
    Long queryCount();

    /**
     * 分页查询
     * @param query
     * @return
     */
    @Select("select " +
            "* from " +
            "t_department " +
            "limit #{start},#{pageSize}")
    @Results({
            @Result(
                    property = "id",
                    column = "id"
            ),
            @Result(
                    property = "parent",
                    column = "parent_id",
                    javaType = Department.class,
                    one = @One(select = "org.pet.home.mapper.DepartmentMapper.findParentDepartment")
            ),
            @Result(
                    property = "children",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "org.pet.home.mapper.DepartmentMapper.findSubDepartments")
            )
    })
    List<Department> findDepartmentsByPage(DepartmentQuery query);
<<<<<<< HEAD
}



























=======


}
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
