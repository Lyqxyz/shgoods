package com.shgoods.goods;


import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.service.ShOrderService;
import com.shgoods.goods.vo.ResponseVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Autowired
    ShOrderService shOrderService;

    @Test
    public void test(){

        ShOrder shOrder = new ShOrder();

        shOrder.setOrderId("98147021008928773");

        ResponseVo responseVo = shOrderService.updateRecv(shOrder);

        System.out.println(responseVo);


    }
}
