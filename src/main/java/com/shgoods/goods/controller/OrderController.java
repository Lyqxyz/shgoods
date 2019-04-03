package com.shgoods.goods.controller;

import com.alibaba.fastjson.JSONArray;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shgoods.goods.pojo.*;
import com.shgoods.goods.service.ShOrderService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.vo.ResponseVo;
import com.shgoods.goods.vo.order.AddOrderVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author lyq
 * 订单详情
 */
@Controller
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    ShOrderService shOrderService;

    @GetMapping(path = "/infoView")
    public String infoView(){

        return "order/orderInfo";

    }

    @ResponseBody
    @RequestMapping(path = "/info/{pageNum}/{pageSize}")
    public Object info(@PathVariable(value = "pageNum")Integer pageNum,
                       @PathVariable(value = "pageSize")Integer pageSize,
                       HttpServletRequest request){

        PageHelper.startPage(pageNum,pageSize);

        List<ShOrder> info = shOrderService.info();

        PageInfo<ShOrder> ShAuthorityInfo = new PageInfo<>(info, 3);

        ResponseVo responseVo = new ResponseVo();

        responseVo.setCode("1");

        responseVo.setPath(request.getRequestURI());

        responseVo.setDate(new Date());

        responseVo.setMessage("请求成功");

        responseVo.getInfo().put("data",ShAuthorityInfo);

        return responseVo;

    }

    @ResponseBody
    @PostMapping(value = "/add")
    public Object add(@Validated AddOrderVo addOrderVo, BindingResult result, HttpServletRequest request){

        ResponseVo responseVo;

        if(result.hasErrors()){

            responseVo = BindingErrorUtil.common("添加失败", request.getRequestURI(), result);

        }else{

            String s = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMddHH"));

            ShOrder shOrder = new ShOrder();

            ShUser shUser = new ShUser();

            String uid = addOrderVo.getOrderUid();

            String substring = uid.substring(5,uid.length());

            shUser.setUserId(uid);

            BeanUtils.copyProperties(addOrderVo,shOrder);

            shOrder.setOrderUid(shUser);

            shOrder.setOrderNum(substring+s);

            String shopcars = addOrderVo.getShopcars();

            List<ShShopCar> shShopCars = JSONArray.parseArray(shopcars, ShShopCar.class);

            responseVo = shOrderService.add(shOrder,shShopCars);

            responseVo.getInfo().put("data",shOrder);

        }

        responseVo.setPath(request.getRequestURI());

        return responseVo;




    }



}
