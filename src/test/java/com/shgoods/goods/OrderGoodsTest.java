package com.shgoods.goods;


import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.mapper.ShGoodsMapper;
import com.shgoods.goods.mapper.ShOrderGoodsMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.pojo.ShGoodsOrder;
import com.shgoods.goods.pojo.ShOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderGoodsTest {

    @Autowired
    ShOrderGoodsMapper shOrderGoodsMapper;

    @Autowired
    ShBookMapper shBookMapper;

    @Autowired
    ShGoodsMapper shGoodsMapper;

    @Test
    public void test(){

        ShOrder shOrder = new ShOrder();

        shOrder.setOrderId("98147021008928777");

        ShGoodsOrder shGoodsOrder = new ShGoodsOrder();

        shGoodsOrder.setGoOid(shOrder);

        List<ShGoodsOrder> shGoodsOrders = shOrderGoodsMapper.selectByGoodsOrder(shGoodsOrder);

        ShBook shBook = new ShBook();

        ShGoods shGoods = new ShGoods();

        for (ShGoodsOrder goodsOrder : shGoodsOrders) {

            if(goodsOrder.getGoIsBook().equals(1)){

                shBook.setBookId(goodsOrder.getGoIdAll());

                ShBook shBook1 = shBookMapper.selectById(shBook);

                goodsOrder.setGoBid(shBook1);
            }else{

                shGoods.setGoodsId(goodsOrder.getGoIdAll());

                ShGoods shGoods1 = shGoodsMapper.selectById(shGoods);

                shGoodsOrder.setGoGid(shGoods1);


            }


        }

        shGoodsOrders.stream().forEach(System.out::println);
    }


}
