package com.shgoods.goods;


import com.shgoods.goods.mapper.ShGoodsMapper;
import com.shgoods.goods.pojo.ShGoods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.EnabledIf;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTest {

    @Autowired
    ShGoodsMapper shGoodsMapper;

    @Test
    public void test1(){

        List<ShGoods> all = shGoodsMapper.all();


        all.stream().forEach(System.out::println);

    }
}