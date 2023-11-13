package org.pet.home.service;

import org.apache.ibatis.annotations.Param;
import org.pet.home.entity.Users;
import org.pet.home.net.param.RegisterParam;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/9
 */
public interface IUsersService {
    int add(RegisterParam registerParam);

    Users getUser(@Param("phone") String phone, @Param("password") String password);

    Users getAdmin(String phone, String password);

    Users selectPhone(String phone);

    Users findById(long id);
}
