package com.shgoods.goods;


import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.pojo.ShBook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookTest {

    @Autowired
    ShBookMapper shBookMapper;

    @Test
    public void test(){

        List<ShBook> all = shBookMapper.all();

        all.stream().forEach(System.out::println);

    }
}
