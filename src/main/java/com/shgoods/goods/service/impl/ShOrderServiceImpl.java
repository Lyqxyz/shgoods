package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShOrderMapper;
import com.shgoods.goods.pojo.ShGoodsOrder;
import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShOrderGoodsService;
import com.shgoods.goods.service.ShOrderService;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ShOrderServiceImpl implements ShOrderService {


    @Autowired
    ShOrderMapper shOrderMapper;

    @Autowired
    ShOrderGoodsService shOrderGoodsService;

    @Override
    public List<ShOrder> info() {

        List<ShOrder> shOrders = shOrderMapper.allOrder();

        return shOrders;


    }

    @Override
    public ResponseVo add(ShOrder shOrder,List<ShShopCar> shShopCars) {

        Integer add = shOrderMapper.add(shOrder);

        if(add==1){

            ResponseVo ok = ResponseUtil.isOk();

            ok.getInfo().put("data",shOrder);

            shOrderGoodsService.addOrderGoods(shOrder,shShopCars);

            return  ok;

        }else{

            ResponseVo error = ResponseUtil.isError();

            return  error;
        }

    }

    @Override
    public ResponseVo selectByUser(ShUser shUser) {

        if(Objects.isNull(shUser)||Objects.isNull(shUser.getUserId())){

            return ResponseUtil.isError();
        }

        List<ShOrder> shOrders = shOrderMapper.searchByUser(shUser);

        ResponseVo ok = ResponseUtil.isOk();

        ok.getInfo().put("data",shOrders);

        return ok;
    }

    @Override
    public ResponseVo updateIsPay(ShOrder shOrder) {


        if(Objects.isNull(shOrder)||Objects.isNull(shOrder.getOrderId())){


            return ResponseUtil.isError();
        }

        Integer integer = shOrderMapper.updateIsPay(shOrder);

        ResponseVo ok = ResponseUtil.isOk();

        return ok;
    }

    @Override
    public ResponseVo updateRecv(ShOrder shOrder) {

        if(Objects.isNull(shOrder)||Objects.isNull(shOrder.getOrderId())){


            return ResponseUtil.isError();
        }

        Integer integer = shOrderMapper.updateRecv(shOrder);

        ResponseVo ok = ResponseUtil.isOk();

        return ok;


    }

    @Override
    public ResponseVo delOrder(ShOrder shOrder) {
        if(Objects.isNull(shOrder)||Objects.isNull(shOrder.getOrderId())){


            return ResponseUtil.isError();
        }

        Integer integer = shOrderMapper.delOrder(shOrder);

        ResponseVo ok = ResponseUtil.isOk();

        return ok;


    }
}
