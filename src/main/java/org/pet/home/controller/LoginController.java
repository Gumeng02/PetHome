package org.pet.home.controller;

import org.pet.home.common.Constants;
import org.pet.home.interceptor.TokenInterceptor;
import org.pet.home.net.NetCode;
import org.pet.home.net.NetResult;
import org.pet.home.net.param.LoginParam;
import org.pet.home.service.IEmployeeService;
import org.pet.home.service.impl.RedisService;
import org.pet.home.service.impl.UserService;
import org.pet.home.utils.RegexUtil;
import org.pet.home.utils.ResultGenerator;
import org.pet.home.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;



/**
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/6
 **/
@RestController
public class LoginController {
    private RedisService redisService;
    private UserService userService;
    private IEmployeeService iEmployeeService;
    private RedisTemplate redisTemplate;
    private Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);



    @Autowired
    public  LoginController(RedisService redisService,UserService userService,IEmployeeService iEmployeeService,RedisTemplate redisTemplate){
        this.redisService = redisService;
        this.userService = userService;
        this.iEmployeeService =iEmployeeService;
        this.redisTemplate = redisTemplate;
    }

    @PostMapping(value = "/login" ,produces = {"application/json", "application/xml"})
    public NetResult login(@RequestBody LoginParam loginParam){

        System.out.println(loginParam);
        try {
            NetResult netResult = userService.adminLogin(loginParam);
            return netResult;
        }catch (Exception e){
            return ResultGenerator.genFailResult("未知异常"+e.getMessage());
        }


    }

    //登录
    @GetMapping("/getverifycode")
    public NetResult sendVerifyCode(@RequestParam String phone){
        return userService.sendRegisterCode(phone);

    }

    //验证
    @GetMapping("/verifycode")
    public NetResult verifyCode(@RequestParam String phone,@RequestParam String code){
        if (StringUtils.isEmpty(phone)){
            return ResultGenerator.genErrorResult(NetCode.PHONE_INVALID, Constants.PHONE_IS_NULL);
        }
        if(!RegexUtil.isMobileExact(phone)){
            return ResultGenerator.genErrorResult(NetCode.PHONE_INVALID,"手机号不合法");
        }
        String expiredV = redisService.getValue(phone+phone);

//        String e = new ArrayList(expiredV).get(0).toString();
//        System.out.println(e);
//        System.out.println(expiredV.toString());
//        System.out.println(StringUtils.isNullOrNullStr(expiredV.toString()));
        if(StringUtils.isNullOrNullStr(expiredV)){
            return  ResultGenerator.genFailResult("验证码过期");
        }else {
            if (expiredV.equals(code)){
                return  ResultGenerator.genSuccessResult("验证码正常");
            }else {
                return ResultGenerator.genFailResult("验证码不存在");
            }
        }
    }



    //注册
    public void register(){

    }
}
