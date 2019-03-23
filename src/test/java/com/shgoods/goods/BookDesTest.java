package com.shgoods.goods;


import com.shgoods.goods.mapper.ShBookDesMapper;
import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShBookDescription;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDesTest {


    @Autowired
    ShBookDesMapper shBookDesMapper;

    @Autowired
    ShBookMapper shBookMapper;


    @Test
    public void test(){

        ShBook shBook = new ShBook();

        shBook.setBookId("123456");

        List<ShBookDescription> search = shBookDesMapper.search(shBook);

        search.stream().forEach(System.out::println);


    }

    @Test
    public void test2(){
        ShBook shBook = new ShBook();

        shBook.setBookId("98113987475931137");

        ShBook shBook1 = shBookMapper.hasBook(shBook);

        System.out.println(shBook1);
    }
}
