package com.shgoods.goods;


import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.service.ShOrderService;
import com.shgoods.goods.vo.ResponseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class OrderTest {

    @Test
    public void test1(){


        for(int i=1;i<100;i++){

            String s = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMddHHmmss"));

            String s1 = UUID.randomUUID().toString();

            System.out.println(s1);

            String substring = s1.substring(9, 18);

            System.out.println(substring+s);
        }

    }
}
