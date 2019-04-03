package com.shgoods.goods;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.shgoods.goods.pojo.ShShopCar;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


public class OtherTest {


    @Test
    public void test1(){

        List<ShShopCar> shShopCars = new ArrayList<>();

        for (int i =0;i<3;i++){

            ShShopCar shShopCar = new ShShopCar();

            shShopCar.setShopCarCount(10);

            shShopCar.setShopCarOkBook(1);

            shShopCar.setShopCarGid("123123123456");

            shShopCars.add(shShopCar);
        }

        String s = JSONArray.toJSONString(shShopCars);

        Object parse2 = JSON.parse(s);

        List<ShShopCar> parse = (List<ShShopCar>) JSONArray.parse(s);

        System.out.println(parse2 instanceof List);
        System.out.println(parse);
        System.out.println(parse2);

    }
}
