package com.shgoods.goods;


import com.shgoods.goods.mapper.ShClassMapper;
import com.shgoods.goods.pojo.ShClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@RunWith(SpringRunner.class)
@SpringBootTest
public class ShClassTest {

    @Autowired
    ShClassMapper shClassMapper;

    @Test
    public void test2(){



        for (int i = 1;i<10;i++){

            ShClass shClass = new ShClass();

            shClass.setClassNum(String.valueOf(i));

            shClass.setClassName("分类"+i);

            shClassMapper.addClass(shClass);

        }


    }
}
