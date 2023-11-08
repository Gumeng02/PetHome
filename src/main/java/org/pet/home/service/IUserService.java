package org.pet.home.service;

import org.pet.home.net.NetResult;
import org.pet.home.net.param.LoginParam;

/**
 * @description: TODO 类描述
 * @author: 丁真
 * @date: 2023/11/6
 **/
public interface IUserService {

    /**
     * 发送二维码
     */
    NetResult sendRegisterCode(String phone);

    NetResult adminLogin(LoginParam loginParam);
}