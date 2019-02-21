package com.shgoods.goods;


import com.shgoods.goods.mapper.ShClassMapper;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.service.ShClassService;
import com.shgoods.goods.vo.ResponseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.rowset.serial.SerialJavaObject;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ShClassTest {

    @Autowired
    ShClassMapper shClassMapper;

    @Autowired
    ShClassService shClassService;


    @Test
    public void test2(){



        for (int i = 1;i<10;i++){

            ShClass shClass = new ShClass();

            shClass.setClassNum(String.valueOf(i));

            shClass.setClassName("分类"+i);

            shClassMapper.addClass(shClass);

        }


    }

    @Test
    public void test3(){

        List<ShClass> shClasses = shClassMapper.withoutParentClass();

        shClasses.stream().forEach(System.out::println);


    }

    @Test
    public void test4(){


        ShClass shClass = new ShClass();

        shClass.setClassNum("1");

        shClass.setClassName("分类2");

        ShClass shClass1 = shClassMapper.checkClassNum(shClass);

        ShClass shClass2 = shClassMapper.checkClassName(shClass);

        System.out.println(shClass1);
        System.out.println(shClass2);


    }

    @Test
    public void test6(){


        ShClass shClass = new ShClass();

        shClass.setClassNum("1");

        shClass.setClassName("分类2");

        List<String> strings = shClassService.checkAttrs(shClass);

        System.out.println(strings);


    }

    @Test
    public void test7(){


        ShClass shClass = new ShClass();

        shClass.setClassNum("11");

        shClass.setClassName("分类11");

        ResponseVo responseVo = shClassService.addClass(shClass);


        System.out.println(responseVo);


    }

    @Test
    public void test8(){

        ShClass shClass = new ShClass();

        shClass.setClassPid("98019743847415817");

        List<ShClass> shClasses = shClassMapper.selectClassByPid(shClass);

        shClasses.stream().forEach(System.out::println);



    }





}
