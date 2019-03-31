package com.shgoods.goods;


import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShBookService;
import com.shgoods.goods.vo.ResponseVo;
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

    @Autowired
    ShBookService shBookService;

    @Test
    public void test(){

        List<ShBook> all = shBookMapper.all();

        all.stream().forEach(System.out::println);

    }

    @Test
    public void test1(){

        ShUser shUser = new ShUser();

        shUser.setUserId("97977401056690242");

        List<ShBook> all = shBookMapper.selectByUser(shUser);

        all.stream().forEach(System.out::println);

    }

    @Test
    public void test2(){

        ShClass shClass = new ShClass();

        shClass.setClassId("98019743847415813");

        ResponseVo responseVo = shBookService.selectByClass(shClass);

        System.out.println(responseVo);


    }
}
