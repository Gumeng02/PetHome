package org.pet.home.controller;


import io.swagger.annotations.Api;
import org.pet.home.entity.Employee;
import org.pet.home.entity.Shop;
import org.pet.home.net.NetCode;
import org.pet.home.net.NetResult;
import org.pet.home.service.IShopService;
import org.pet.home.utils.ResultGenerator;
import org.pet.home.utils.ShopUtil;
import org.pet.home.utils.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: TODO 类描述
 * @author: 顾梦
 * @date: 2023/11/3
 **/
@Api(tags = "shop接口文档")
@RestController
@RequestMapping("/shop")
public class ShopController {

    private IShopService iShopService;

    public ShopController(IShopService iShopService){
        this.iShopService = iShopService;
    }

    @PostMapping("/register")
    public NetResult ShopRegister(@RequestBody Shop shop){
        if (StringUtils.isEmpty(shop.getName())){
            return ResultGenerator.genErrorResult(NetCode.SHOP_NAME_INVALID,"店铺名不能空");
        }
        if (StringUtils.isEmpty(shop.getTel())){
            return ResultGenerator.genErrorResult(NetCode.PHONE_NAME_INVALID,"手机号不能空");
        }
        if (StringUtils.isEmpty(shop.getLogo())){
            return ResultGenerator.genErrorResult(NetCode.LOGO_NAME_INVALID,"店铺名不能空");
        }
        if (StringUtils.isEmpty(shop.getAddress())){
            return ResultGenerator.genErrorResult(NetCode.ADDRESS_NAME_INVALID,"logo不能空");
        }

        shop.setRegisterTime(System.currentTimeMillis());
        if (shop.getAdmin() == null){
            Employee employee = new Employee();
            employee.setId(0l);
            shop.setAdmin(employee);
        }

        int result = iShopService.add(shop);
        if(result!=1){
            return ResultGenerator.genFailResult("添加失败");
        }

        return ResultGenerator.genSuccessResult("添加成功");
    }

    @RequestMapping("/list")
    public NetResult list(){
        return ResultGenerator.genSuccessResult(iShopService.list());
    }

    @PostMapping("/out")
    public NetResult out(@RequestBody Shop shop){
        System.out.println("----------");
        System.out.println(shop.getId());
        try {
            iShopService.updateAdminId(shop.getId());
            return ResultGenerator.genSuccessResult("ok");
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("失败");
        }
    }

    @PostMapping("/delete")
    public NetResult delete(Long id){

        System.out.println("---------");
        System.out.println(id);
        int result = iShopService.delete(id);
        if (result==1){
            return ResultGenerator.genSuccessResult(id+"删除成功");
        }
        return ResultGenerator.genSuccessResult(id+"删除失败");
    }

    @PostMapping("/edit")
    public NetResult edit(@RequestBody Shop shop){
        System.out.println("---------");
        System.out.println(shop);
        try {
            iShopService.update(shop);
            return ResultGenerator.genSuccessResult("修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    @PostMapping("/paginationList")
    public NetResult list(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize){

        // 获取总记录数
        int count = iShopService.count();
        int offset = (page-1) * pageSize;
        List<Shop> shops = iShopService.paginationList(offset,pageSize);
        ShopUtil shopUtil = new ShopUtil();
        shopUtil.shops=shops;
        shopUtil.total = count;
        return ResultGenerator.genSuccessResult(shopUtil);
    }
}