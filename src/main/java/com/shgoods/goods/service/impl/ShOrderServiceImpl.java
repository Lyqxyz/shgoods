package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShOrderMapper;
import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.service.ShOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShOrderServiceImpl implements ShOrderService {


    @Autowired
    ShOrderMapper shOrderMapper;

    @Override
    public List<ShOrder> info() {

        List<ShOrder> shOrders = shOrderMapper.allOrder();

        return shOrders;


    }
}
