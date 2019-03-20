package com.shgoods.goods;


import com.shgoods.goods.mapper.ShOrderGoodsMapper;
import com.shgoods.goods.pojo.ShGoodsOrder;
import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.service.ShOrderGoodsService;
import com.shgoods.goods.vo.ResponseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsOrderTest {

    @Autowired
    ShOrderGoodsMapper shOrderGoodsMapper;


    @Autowired
    ShOrderGoodsService shOrderGoodsService;

    @Test
    public void test(){

        ShGoodsOrder shGoodsOrder = new ShGoodsOrder();

        ShOrder shOrder = new ShOrder();

        shOrder.setOrderId("98092238432632833");

        shGoodsOrder.setGoOid(shOrder);
        ResponseVo responseVo = shOrderGoodsService.allByorder(shOrder);

        System.out.println(responseVo);


    }

}
