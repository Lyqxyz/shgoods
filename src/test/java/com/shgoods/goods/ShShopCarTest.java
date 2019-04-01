package com.shgoods.goods;


import com.shgoods.goods.mapper.ShShopCarMapper;
import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShShopCarService;
import com.shgoods.goods.vo.ResponseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShShopCarTest {

    @Autowired
    ShShopCarMapper shShopCarMapper;

    @Autowired
    ShShopCarService shShopCarService;
    @Test
    public void test(){

        List<ShShopCar> shShopCars = shShopCarMapper.allShopCar();


        shShopCars.stream().forEach(System.out::println);
    }

    @Test
    public void test1(){

        ShUser shUser = new ShUser();

        shUser.setUserId("97977401056690246");

        ResponseVo responseVo = shShopCarService.selectByUser(shUser);

        System.out.println(responseVo);


    }



}
