package org.pet.home.service;

import org.pet.home.net.NetResult;
import org.pet.home.net.param.LoginParam;
import org.pet.home.net.param.RegisterParam;

/**
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/6
 **/
public interface IUserService {

    /**
     * 发送二维码
     */
    NetResult sendRegisterCode(String phone);

    NetResult adminLogin(LoginParam loginParam);

    NetResult login(LoginParam loginParam) throws Exception;

    NetResult register(RegisterParam registerParam);
}
