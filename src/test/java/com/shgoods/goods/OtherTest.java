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

    @Test
    public void test(){

        String json = "[{\"shopCarId\":\"98146655819268103\",\"shopCarUid\":\"97995090751913988\",\"shopCarGid\":\"98143670733111299\",\"shopCarCount\":2,\"shopCarState\":1,\"shopCarCreationTime\":\"2019-04-12T02:11:01.000+0000\",\"shopCarUpdateTime\":null,\"shopCarOkBook\":1,\"shGoods\":null,\"shBook\":{\"bookId\":\"98143670733111299\",\"bookName\":\"斗罗大陆\",\"bookIsbn\":\"12345678911\",\"bookAuthor\":null,\"bookPublish\":null,\"bookOriginalPrice\":null,\"bookSellingPrice\":12,\"bookCount\":null,\"bookNao\":null,\"bookDes\":null,\"bookState\":null,\"bookCreationTime\":\"2019-04-09T23:30:13.000+0000\",\"bookUpdateTime\":null,\"bookCid\":null,\"shUser\":null},\"shUser\":null},{\"shopCarId\":\"98146655819268104\",\"shopCarUid\":\"97995090751913988\",\"shopCarGid\":\"98143670733111323\",\"shopCarCount\":1,\"shopCarState\":1,\"shopCarCreationTime\":\"2019-04-12T02:15:24.000+0000\",\"shopCarUpdateTime\":null,\"shopCarOkBook\":0,\"shGoods\":{\"goodsId\":\"98143670733111323\",\"goodsTitle\":\"峰惠厨房用品用具多功能家用放锅架置物转角储物架\",\"goodsOriginalPrice\":null,\"goodsSellingPrice\":22,\"goodsNao\":null,\"goodsState\":null,\"goodsReleaseTime\":null,\"goodsUpdateTime\":null,\"goodsDes\":\"品牌：峰惠类别：收纳层架国产/进口：国产产地：中国广东广州市材质：其他层数：一层\",\"goodsCount\":null,\"goodsCid\":null,\"goodsCid1\":null,\"shUser\":null},\"shBook\":null,\"shUser\":null}]";

        List<ShShopCar> shShopCars = JSONArray.parseArray(json, ShShopCar.class);

        for (ShShopCar shShopCar : shShopCars) {

            System.out.println(shShopCar);
        }


    }
}
