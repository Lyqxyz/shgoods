package com.shgoods.goods;


import com.shgoods.goods.mapper.ShGoodsMapper;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShGoodsService;
import com.shgoods.goods.vo.ResponseVo;
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

    @Autowired
    ShGoodsService shGoodsService;

    @Test
    public void test1(){

        List<ShGoods> all = shGoodsMapper.all();


        all.stream().forEach(System.out::println);

    }

    @Test
    public void test2(){


        ShUser shUser = new ShUser();

        shUser.setUserId("97995090751913987");

        List<ShGoods> all = shGoodsMapper.selectByUser(shUser);

        all.stream().forEach(System.out::println);

    }

    @Test
    public void test3(){

        ShClass shClass = new ShClass();

        shClass.setClassId("98024116862320642");

        ResponseVo responseVo = shGoodsService.selectByClass(shClass);


        System.out.println(responseVo);


    }
}
