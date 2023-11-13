package org.pet.home.mapper;

import org.apache.ibatis.annotations.*;
import org.pet.home.entity.Users;
import org.pet.home.net.param.RegisterParam;
import org.springframework.stereotype.Repository;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/9
 */
@Mapper
@Repository
public interface UsersMapper {
    @Insert("insert into t_user(username,phone,password,state,age,registertime)  " +
            "values(#{username},#{phone},#{password},#{state},#{age},#{registertime})")
    int add(RegisterParam registerParam);

    @Select("select * from t_user where phone=#{phone} and password=#{password}")
    Users getUser(@Param("phone") String phone, @Param("password") String password);

    @Select("select * from t_employee where phone=#{phone} and password=#{password}")
    Users getAdmin(String phone, String password);

    @Select("select * from t_user where phone=#{phone}")
    Users selectPhone(String phone);

    @Select("select * from t_user where id=#{id}")
    Users findById(long id);
}
