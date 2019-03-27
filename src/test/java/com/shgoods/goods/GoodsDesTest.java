package com.shgoods.goods;


import com.shgoods.goods.mapper.ShGoodsDesMapper;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.pojo.ShGoodsDescription;
import com.shgoods.goods.service.ShGoodsDesService;
import com.shgoods.goods.vo.ResponseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsDesTest {

    @Autowired
    ShGoodsDesService shGoodsDesService;

    @Autowired
    ShGoodsDesMapper shGoodsDesMapper;


    @Test
    public void test(){


        ShGoods shGoods = new ShGoods();

        shGoods.setGoodsId("98119134423810051");
        ResponseVo search = shGoodsDesService.search(shGoods);


        System.out.println(search);
    }

    @Test
    public void test1(){
        List<ShGoodsDescription> all = shGoodsDesMapper.all();
        all.stream().forEach(System.out::println);
    }

}
