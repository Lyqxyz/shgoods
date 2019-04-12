package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShOrderGoodsMapper;
import com.shgoods.goods.mapper.ShShopCarMapper;
import com.shgoods.goods.pojo.*;
import com.shgoods.goods.service.ShOrderGoodsService;
import com.shgoods.goods.util.ResponseUtil;
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

    @Autowired
    ShShopCarMapper shShopCarMapper;

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

    @Override
    public ResponseVo addOrderGoods(ShGoodsOrder shGoodsOrder) {

        ResponseVo ok = ResponseUtil.isOk();

        return ok;
    }

    @Override
    public ResponseVo addOrderGoods(ShOrder shOrder,List<ShShopCar> shShopCars) {

        ResponseVo ok = ResponseUtil.isOk();

        ShGoodsOrder shGoodsOrder = new ShGoodsOrder();

        shGoodsOrder.setGoOid(shOrder);

        for (ShShopCar shShopCar :shShopCars){

            shGoodsOrder.setGoIsBook(shShopCar.getShopCarOkBook());

            shGoodsOrder.setGoState(1);

            shGoodsOrder.setGoIdAll(shShopCar.getShopCarGid());

            shGoodsOrder.setGoCount(shShopCar.getShopCarCount());

            Integer integer = shOrderGoodsMapper.shopCarToOrder(shGoodsOrder);

            shShopCarMapper.delShopCar(shShopCar);


        }

        return ok;
    }
}
