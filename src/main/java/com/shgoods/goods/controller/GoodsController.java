package com.shgoods.goods.controller;

import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.service.ShGoodsService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.vo.ResponseVo;
import com.shgoods.goods.vo.goods.GoodsVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/goods")
public class GoodsController {

    @Autowired
    ShGoodsService shGoodsService;


    @GetMapping(path = "/addView")
    public String addView(){


        return "goods/addGoods";
    }

    @ResponseBody
    @PostMapping(path = "/add")
    public Object add(@Validated GoodsVo goodsVo, BindingResult result, HttpServletRequest request){

        ResponseVo responseVo = null;

        ShGoods shGoods = new ShGoods();

        BeanUtils.copyProperties(goodsVo,shGoods);

        Map<String, List<String>> errors = BindingErrorUtil.handlerErrors(result);

        if(result.hasErrors()){

            responseVo = BindingErrorUtil.common("添加失败", request.getRequestURI(), result);

        }else{

            responseVo=shGoodsService.add(shGoods);

        }

        return responseVo;

    }

}
