package com.ezreal.demo.web;

import com.ezreal.demo.entity.Shop;
import com.ezreal.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "listshop" ,method = RequestMethod.GET)
    public Map<String,Object> listShop(){
        Map<String,Object> result = new HashMap<>();
        List<Shop> shops = shopService.selectAll();
        result.put("shopList",shops);
        result.put("success",true);
        return result;
    }

    @RequestMapping(value = "getshopbyid" ,method = RequestMethod.GET)
    public Map<String,Object> getShopById(int shop_id){
        Map<String,Object> result = new HashMap<>();
        Shop shop = shopService.selectByPrimaryKey(shop_id);
        result.put("shop",shop);
        result.put("success",true);
        return result;
    }

}
