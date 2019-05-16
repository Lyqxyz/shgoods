package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.mapper.ShGoodsMapper;
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

    @Autowired
    ShBookMapper shBookMapper;

    @Autowired
    ShGoodsMapper shGoodsMapper;


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

    @Override
    public ResponseVo selectByOrderGoods(ShGoodsOrder shGoodsOrder) {

        ResponseVo ok = ResponseUtil.isOk();

        List<ShGoodsOrder> shGoodsOrders = shOrderGoodsMapper.selectByGoodsOrder(shGoodsOrder);

        for (ShGoodsOrder goodsOrder : shGoodsOrders) {

            if(goodsOrder.getGoIsBook().equals(1)){

                ShBook shBook = new ShBook();

                shBook.setBookId(goodsOrder.getGoIdAll());

                ShBook shBook1 = shBookMapper.selectById(shBook);

                goodsOrder.setGoBid(shBook1);

            }else{


                ShGoods shGoods = new ShGoods();

                shGoods.setGoodsId(goodsOrder.getGoIdAll());

                ShGoods shGoods1 = shGoodsMapper.selectById(shGoods);

                goodsOrder.setGoGid(shGoods1);

            }
        }

        ok.getInfo().put("data",shGoodsOrders);

        return ok;


    }

    @Override
    public ResponseVo selectByUser(ShUser shUser) {


        List<ShGoodsOrder> shGoodsOrders = shOrderGoodsMapper.selectByUser(shUser);

        for (ShGoodsOrder goodsOrder : shGoodsOrders) {

            if (goodsOrder.getGoIsBook().equals(1)) {

                ShBook shBook = new ShBook();

                shBook.setBookId(goodsOrder.getGoIdAll());

                ShBook shBook1 = shBookMapper.selectById(shBook);

                goodsOrder.setGoBid(shBook1);

            } else {

                ShGoods shGoods = new ShGoods();

                shGoods.setGoodsId(goodsOrder.getGoIdAll());

                ShGoods shGoods1 = shGoodsMapper.selectById(shGoods);

                goodsOrder.setGoGid(shGoods1);

            }
        }
            ResponseVo ok = ResponseUtil.isOk();

            ok.getInfo().put("data",shGoodsOrders);

            return ok;
    }

    @Override
    public ResponseVo updataById(ShGoodsOrder shGoodsOrder) {

        Integer integer = shOrderGoodsMapper.updateById(shGoodsOrder);


        if(integer.equals(1)){


            return ResponseUtil.isOk();
        }


        return ResponseUtil.isError();
    }

    @Override
    public ResponseVo resetById(ShGoodsOrder shGoodsOrder) {


        Integer integer = shOrderGoodsMapper.resetById(shGoodsOrder);

        ResponseVo ok = ResponseUtil.isOk();

        ok.setMessage("取消成功");

        return ok;
    }

    @Override
    public ResponseVo del(String id) {


        Integer del = shOrderGoodsMapper.del(id);

        ResponseVo ok = ResponseUtil.isOk();

        ok.setMessage("删除成功");

        return ok;


    }
}
