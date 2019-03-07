package com.shgoods.goods.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.service.ShOrderService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

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



}
