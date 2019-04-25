package com.shgoods.goods.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shgoods.goods.mapper.ShGoodsMapper;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.pojo.ShUser;
import com.shgoods.goods.service.ShBookService;
import com.shgoods.goods.service.ShGoodsService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import com.shgoods.goods.vo.goods.GoodsVo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/goods")
public class GoodsController {

    @Autowired
    ShGoodsService shGoodsService;

    @Autowired
    ShGoodsMapper shGoodsMapper;

    @GetMapping(path = "/addView")
    public String addView(){


        return "goods/addGoods";
    }

    @ResponseBody
    @PostMapping(path = "/add")
    public Object add(@Validated GoodsVo goodsVo, BindingResult result, HttpServletRequest request){

        ResponseVo responseVo = null;

        ShUser shUser = new ShUser();

        shUser.setUserId(goodsVo.getUid());

        ShGoods shGoods = new ShGoods();

        BeanUtils.copyProperties(goodsVo,shGoods);

        shGoods.setShUser(shUser);

        Map<String, List<String>> errors = BindingErrorUtil.handlerErrors(result);

        if(result.hasErrors()){

            responseVo = BindingErrorUtil.common("添加失败", request.getRequestURI(), result);

        }else{

            responseVo=shGoodsService.add(shGoods);

        }

        return responseVo;

    }


    @GetMapping(path="info")
    public String info(){

        return  "goods/goodsInfo";
    }

    @ResponseBody
    @GetMapping(value = "/{pageNum}/{pageSize}")
    public Object allUser(@PathVariable(value = "pageNum") Integer pageNum, @PathVariable(name = "pageSize") Integer pageSize, HttpServletRequest request){


        PageHelper.startPage(pageNum, pageSize);

        List<ShGoods> all = shGoodsService.all();

        PageInfo page = new PageInfo(all,10);

        ResponseVo responseVo = new ResponseVo();

        responseVo.setDate(new Date());

        responseVo.setMessage("请求成功");

        responseVo.setPath(request.getRequestURI());

        responseVo.setCode("1");

        responseVo.getInfo().put("data",page);

        return responseVo;

    }

    @ResponseBody
    @GetMapping(path = "/user/{id}")
    public Object selectByUser(@PathVariable(value = "id")String id,HttpServletRequest request){

        ShUser shUser = new ShUser();

        shUser.setUserId(id);

        ResponseVo responseVo = shGoodsService.selectByUser(shUser);

        responseVo.setPath(request.getRequestURI());

        return  responseVo;
    }

    @ResponseBody
    @GetMapping(value = "/{id}")
    public Object selectWithUser(@PathVariable(value = "id") String id,HttpServletRequest request){


        ShGoods shGoods = new ShGoods();

        shGoods.setGoodsId(id);

        ResponseVo responseVo = shGoodsService.selectWithUser(shGoods);

        responseVo.setPath(request.getRequestURI());

        return responseVo;
    }

    @ResponseBody
    @GetMapping(value = "/del/{id}")
    public Object del(@PathVariable(value = "id")String id,HttpServletRequest request){

        ShGoods shGoods = new ShGoods();

        shGoods.setGoodsId(id);

        ResponseVo responseVo = shGoodsService.delById(shGoods);

        return responseVo;


    }

    @ResponseBody
    @PostMapping(path = "/updateState")
    public Object updateState(ShGoods shGoods){

        Integer integer = shGoodsMapper.updateState(shGoods);

        ResponseVo ok = ResponseUtil.isOk();

        ok.setMessage("更新成功");

        return ok;

    }

}
