package com.shgoods.goods.controller;

import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.service.ShOrderGoodsService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/GoodsOrder")
public class OrderGoodsController {

    @Autowired
    ShOrderGoodsService shOrderGoodsService;

    @ResponseBody
    @GetMapping(path = "/info/{orderId}")
    public Object infoByRole(@PathVariable(value = "orderId") String orderId, HttpServletRequest request){

        ShOrder shOrder = new ShOrder();

        shOrder.setOrderId(orderId);

        ResponseVo responseVo = shOrderGoodsService.allByorder(shOrder);

        return  responseVo;

    }

    @GetMapping(path = "/search")
    public String search(){

        return "order/orderSearch";
    }
}
