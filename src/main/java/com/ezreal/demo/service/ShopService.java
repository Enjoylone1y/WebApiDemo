package com.ezreal.demo.service;

import com.ezreal.demo.entity.Shop;

import java.util.List;

public interface ShopService {

    boolean deleteByPrimaryKey(Integer shopId);

    boolean insert(Shop record);

    Shop selectByPrimaryKey(Integer shopId);

    List<Shop> selectAll();

    boolean updateByPrimaryKey(Shop record);
}
