package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShOrderGoodsMapper;
import com.shgoods.goods.pojo.*;
import com.shgoods.goods.service.ShOrderGoodsService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ShOrderGoodsServiceImpl implements ShOrderGoodsService {

    @Autowired
    ShOrderGoodsMapper shOrderGoodsMapper;


    @Override
    public ResponseVo allByorder(ShOrder shOrder) {

        ResponseVo responseVo = new ResponseVo();

        ShGoodsOrder shGoodsOrder = new ShGoodsOrder();

        if(shOrder!=null&&shOrder.getOrderId()!=null){

            shGoodsOrder.setGoOid(shOrder);

            List<ShGoodsOrder> shGoodsOrders = shOrderGoodsMapper.selectByGoodsOrder(shGoodsOrder);

            if(shGoodsOrders!=null){

                responseVo.getInfo().put("info",shGoodsOrders);

                responseVo.setCode("1");

                responseVo.setMessage("请求成功");


            }else{

                responseVo.setCode("-1");
                responseVo.setMessage("请求失败");

            }

        }else{
            responseVo.setCode("-1");
            responseVo.setMessage("请求失败");
        }
        responseVo.setDate(new Date());


        return responseVo;


    }
}
