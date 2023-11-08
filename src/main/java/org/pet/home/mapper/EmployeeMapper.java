package org.pet.home.mapper;

import org.apache.ibatis.annotations.*;
import org.pet.home.entity.Employee;
<<<<<<< HEAD
import org.pet.home.net.param.LoginParam;
=======
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
import org.springframework.stereotype.Repository;

import java.util.List;

/**
<<<<<<< HEAD
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/10/31
 **/
@Mapper
@Repository
public interface EmployeeMapper {
    @Insert("insert into t_employee(did,username,email,phone,password,age,state)" +
            "values(#{did},#{username},#{email},#{phone},#{password},#{age},#{state})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int add(Employee d);

    @Delete("delete from t_employee where id=#{id}")
    int delete(Long id);

    @Select("select * from t_employee where username=#{username}")
    Employee findByUsername(String username);

    /**
     * 找在职人员的
     * @param id
     * @return
     */
    @Select("select * from t_employee where id=#{id} and state=0")
    Employee findIncumbency(Long id);

    @Update("update t_employee set " +
            " username=#{username},email=#{email},phone=#{phone},password=#{password},age=#{age},state=#{state} " +
            " where id=#{id}")
    void update(Employee employee);

    @Select("select * from t_employee where id=#{id}")
    Employee findById(Long id);

    @Select("select * from t_employee")
    List<Employee> findAll();

    @Select("select * from t_employee where username=#{username} and password=#{password}")
    Employee login(LoginParam loginParam);

    @Select("select * from t_employee where phone=#{phone} and password=#{password}")
    Employee select(String phone,String password);
=======
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/1
 */
@Mapper
@Repository
public interface EmployeeMapper {
    /**
     * 添加员工
     * @param e 员工信息
     */

    @Insert("insert into t_employee(username,email,phone,password,age,state,did)" +
            "values(#{username},#{email},#{phone},#{password},#{age},#{state},#{did})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int add(Employee e);

    /**
     * 查询某号码是否被使用
     * @param phone
     * @return
     */
    @Select("SELECT * FROM t_employee WHERE phone = #{phone}")
    Employee checkPhone(String phone);

    /**
     * 查询所有员工
     * @return
     */
    @Select("SELECT * FROM t_employee")
    List<Employee> list();

    /**
     * 查询员工数量
     * @return
     */
    @Select("SELECT COUNT(*) FROM t_employee")
    int count();

    @Delete("delete from t_employee where id=#{id}")
    void remove(Long id);

    @Update("update t_employee set " +
            "username=#{username},phone=#{phone},email=#{email},password=#{password}," +
            "age=#{age},state=#{state},did=#{did} " +
            "where id=#{id}")
    void update(Employee e);
>>>>>>> a404dd12f68581c06ccc88dc08aa276f47f07f63
}
