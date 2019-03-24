package com.shgoods.goods;


import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.service.ShGoodsDesService;
import com.shgoods.goods.vo.ResponseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsDesTest {

    @Autowired
    ShGoodsDesService shGoodsDesService;

    @Test
    public void test(){


        ShGoods shGoods = new ShGoods();

        shGoods.setGoodsId("98119134423810051");
        ResponseVo search = shGoodsDesService.search(shGoods);


        System.out.println(search);
    }

}
