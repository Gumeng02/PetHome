package org.pet.home.service.impl;

import org.pet.home.entity.UserMsg;
import org.pet.home.mapper.UserMsgMapper;
import org.pet.home.service.IUserMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/13
 */
@Service
public class UserMsgService implements IUserMsgService {

    private UserMsgMapper userMsgMapper;

    @Autowired
    public UserMsgService(UserMsgMapper userMsgMapper){
        this.userMsgMapper = userMsgMapper;
    }
    @Override
    public int add(UserMsg userMsg) {
        return userMsgMapper.add(userMsg);
    }
}
