package com.ezreal.demo.service.impl;

import com.ezreal.demo.dao.ShopMapper;
import com.ezreal.demo.entity.Shop;
import com.ezreal.demo.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Override
    public Shop selectByPrimaryKey(Integer shopId) {
        if (shopId <= 0){
            throw new RuntimeException("Shop Id 不能为空");
        }
        return shopMapper.selectByPrimaryKey(shopId);
    }

    @Override
    public List<Shop> selectAll() {
        return shopMapper.selectAll();
    }

    /**
     * 增改删或者多步骤查询时等多逻辑步骤时，加入事务管理
     */
    @Transactional
    @Override
    public boolean insert(Shop shop) {
         if (shop.getShopName() != null && !shop.getShopName().endsWith("")){
             try {
                 int insert = shopMapper.insert(shop);
                 if (insert > 0){
                     return true;
                 }else {
                     throw new RuntimeException("插入数据失败！");
                 }
             }catch (Exception e){
                 e.printStackTrace();
                 throw new RuntimeException("插入数据异常:" + e.getMessage());
             }
         }else {
             throw new RuntimeException("区域名称不能为空！");
         }
    }

    @Transactional
    @Override
    public boolean updateByPrimaryKey(Shop shop) {
        if (shop.getShopId() != null && shop.getShopId() > 0
                && shop.getShopName() != null && !shop.getShopName().endsWith("")){
            try {
                int update = shopMapper.updateByPrimaryKey(shop);
                if (update > 0){
                    return true;
                }else {
                    throw new RuntimeException("更新数据失败！");
                }
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("更新数据异常:" + e.getMessage());
            }

        }else {
            throw new RuntimeException("商店 ID 和 名称不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteByPrimaryKey(Integer shopId) {
        if (shopId > 0){
            try {
                int delete = shopMapper.deleteByPrimaryKey(shopId);
                if (delete > 0 ){
                    return true;
                }else {
                    throw new RuntimeException("删除数据失败！");
                }
            }catch (Exception e){
                e.printStackTrace();
                throw new RuntimeException("删除数据异常:" + e.getMessage());
            }
        }else {
            throw new RuntimeException("商店 ID 应大于0");
        }
    }

}
