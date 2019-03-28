package com.shgoods.goods;


import com.alibaba.fastjson.JSONArray;
import com.shgoods.goods.service.IndexGoodsListService;
import com.shgoods.goods.vo.index.GoodsListVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsListTest {

    @Autowired
    IndexGoodsListService indexGoodsListService;

    @Test
    public void test(){

//        List<GoodsListVo> all = indexGoodsListService.all();
//
//        all.stream().forEach(System.out::println);



    }

}
