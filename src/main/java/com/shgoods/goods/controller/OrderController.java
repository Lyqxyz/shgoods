package com.shgoods.goods.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShOrder;
import com.shgoods.goods.pojo.ShUser;
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
import java.util.Date;
import java.util.List;
import java.util.Map;

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

        String s = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYYMMddHH"));

        ShOrder shOrder = new ShOrder();

        ShUser shUser = new ShUser();

        String uid = addOrderVo.getOrderUid();

        String substring = uid.substring(5,uid.length());

        shUser.setUserId(uid);

        BeanUtils.copyProperties(addOrderVo,shOrder);

        shOrder.setOrderUid(shUser);

        shOrder.setOrderNum(substring+s);

        ResponseVo responseVo;

        Map<String, List<String>> errors = BindingErrorUtil.handlerErrors(result);

        if(result.hasErrors()){

            responseVo = BindingErrorUtil.common("添加失败", request.getRequestURI(), result);

        }else{

            responseVo = shOrderService.add(shOrder);

            responseVo.getInfo().put("data",shOrder);

        }

        responseVo.setPath(request.getRequestURI());

        return responseVo;




    }



}
