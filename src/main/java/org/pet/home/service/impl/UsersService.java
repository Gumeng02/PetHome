package org.pet.home.service.impl;

import org.pet.home.entity.Users;
import org.pet.home.mapper.UsersMapper;
import org.pet.home.net.param.RegisterParam;
import org.pet.home.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/9
 */
@Service
public class UsersService implements IUsersService {

    private UsersMapper usersMapper;

    @Autowired
    public UsersService(UsersMapper usersMapper){
        this.usersMapper = usersMapper;
    }

    @Override
    public int add(RegisterParam registerParam) {
        return usersMapper.add(registerParam);
    }

    @Override
    public Users getUser(String phone, String password) {
        return usersMapper.getUser(phone, password);
    }

    @Override
    public Users getAdmin(String phone, String password) {
        return usersMapper.getAdmin(phone, password);
    }

    @Override
    public Users selectPhone(String phone) {
        return usersMapper.selectPhone(phone);
    }

    @Override
    public Users findById(long id) {
        return usersMapper.findById(id);
    }
}
