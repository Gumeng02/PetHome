package org.pet.home.controller;

import org.pet.home.entity.Location;
import org.pet.home.entity.Shop;
import org.pet.home.entity.UserMsg;
import org.pet.home.net.NetCode;
import org.pet.home.net.NetResult;
import org.pet.home.service.IEmployeeService;
import org.pet.home.service.IShopService;
import org.pet.home.service.IUserMsgService;
import org.pet.home.service.IUsersService;
import org.pet.home.utils.AddressDistanceComparator;
import org.pet.home.utils.GaoDeMapUtil;
import org.pet.home.utils.ResultGenerator;
import org.pet.home.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


/**
 * @description:TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private IUserMsgService iUserMsgService;

    private IEmployeeService iEmployeeService;

    private IShopService iShopService;

    private IUsersService iUsersService;

    @Autowired
    public UserController (IUserMsgService iUserMsgService,IEmployeeService iEmployeeService,IShopService iShopService,IUsersService iUsersService){
        this.iUserMsgService = iUserMsgService;
        this.iEmployeeService = iEmployeeService;
        this.iShopService = iShopService;
        this.iUsersService = iUsersService;
    }

    @PostMapping("/publish")
    public NetResult Publish(@RequestBody UserMsg userMsg){
        if (StringUtil.isEmpty(userMsg.getName())){
            return ResultGenerator.genErrorResult(NetCode.PET_NAME_INVALID, "宠物名不能空");
        }

        if (StringUtil.isEmpty(userMsg.getAddress())){
            return ResultGenerator.genErrorResult(NetCode.ADDRESS_INVALID, "地址不能空");
        }

        if (StringUtil.isEmpty(userMsg.getSex())){
            return ResultGenerator.genErrorResult(NetCode.SEX_INVALID, "性别不能空");
        }

        if (userMsg.getIsinoculation()<0){
            return ResultGenerator.genErrorResult(NetCode.ISINOCULATION_INVALID, "接种信息错误");
        }

        if (userMsg.getBirth()<0){
            return  ResultGenerator.genErrorResult(NetCode.BIRTH_INVALID, "生日错误");
        }

        if (iUsersService.findById(userMsg.getUserId())==null){
            return ResultGenerator.genErrorResult(NetCode.ID_INVALID, "没有这个用户id");
        }

        List<Shop> shopList = iShopService.list();
        List<Location> locations = new ArrayList<>();

        try {
            for (int i=0;i<shopList.size();i++){
                locations.add( GaoDeMapUtil.getLngAndLag(shopList.get(i).getAddress()));
            }
            Location userLocation = GaoDeMapUtil.getLngAndLag(userMsg.getAddress());
            Location latest = AddressDistanceComparator.findNearestAddress(userLocation,locations);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
