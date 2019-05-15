package com.shgoods.goods.controller;

import com.shgoods.goods.pojo.ShGoodsOrder;
import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShOrderGoodsService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.HttpsURLConnection;
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

    @ResponseBody
    @GetMapping(path = "/order/{id}")
    public Object selectByOrderGoods(@PathVariable(value = "id")String id, HttpServletRequest request){

        ShOrder shOrder = new ShOrder();

        shOrder.setOrderId(id);

        ShGoodsOrder shGoodsOrder = new ShGoodsOrder();

        shGoodsOrder.setGoOid(shOrder);

        ResponseVo responseVo = shOrderGoodsService.selectByOrderGoods(shGoodsOrder);

        responseVo.setPath(request.getRequestURI());

        return responseVo;

    }


    @ResponseBody
    @GetMapping(path = "/User/{id}")
    public Object selectByUser(@PathVariable(value = "id")String id, HttpServletRequest request){

        ShUser shUser = new ShUser();

        shUser.setUserId(id);

        ResponseVo responseVo = shOrderGoodsService.selectByUser(shUser);

        responseVo.setPath(request.getRequestURI());

        return responseVo;

    }

    @ResponseBody
    @GetMapping(path = "/update/{id}")
    public Object updateById(@PathVariable(value = "id")String id,HttpServletRequest request){


        ShGoodsOrder shGoodsOrder = new ShGoodsOrder();

        shGoodsOrder.setGoId(id);

        ResponseVo responseVo = shOrderGoodsService.updataById(shGoodsOrder);

        responseVo.setPath(request.getRequestURI());

        return responseVo;

    }

    @ResponseBody
    @GetMapping("/del/{id}")
    public Object del(@PathVariable String id){

        ResponseVo del = shOrderGoodsService.del(id);

        return del;
    }


    @GetMapping(path = "/search/{orderNum}")
    public String search(@PathVariable("orderNum")String orderNum, Model model){

        model.addAttribute("orderNum",orderNum);

        return "order/orderSearch";
    }
    @GetMapping(path = "/search")
    public String search1(){

        return "order/orderSearch";
    }
}

