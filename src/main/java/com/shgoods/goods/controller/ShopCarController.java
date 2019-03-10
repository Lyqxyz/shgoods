package com.shgoods.goods.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.pojo.ShShopCar;
import com.shgoods.goods.service.ShShopCarService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.soap.Addressing;
import java.util.Date;
import java.util.List;

/**
 * @author lyq
 */
@Controller
@RequestMapping(path = "/shopcar")
public class ShopCarController {


    @Autowired
    ShShopCarService shShopCarService;

    @GetMapping(path = "infoView")
    public String infoView(){

        return "shopcar/ShopCarInfo";
    }



    @ResponseBody
    @GetMapping(value = "/delete/{shopCarId}")
    public Object delUser(@PathVariable(value = "shopCarId") String shopCarId,HttpServletRequest request){

        ShShopCar shShopCar = new ShShopCar();

        shShopCar.setShopCarId(shopCarId);

        ResponseVo del = shShopCarService.del(shShopCar);

        del.setPath(request.getRequestURI());

        return  del;

    }



    @ResponseBody
    @RequestMapping(value = "/info/{pageNum}/{pageSize}")
    public Object info(@PathVariable(value = "pageNum") Integer pageNum,
                       @PathVariable(value = "pageSize") Integer pageSize,
                       HttpServletRequest request){

        PageHelper.startPage(pageNum,pageSize);

        List<ShShopCar> all = shShopCarService.all();

        PageInfo<ShShopCar> shRolePageInfo = new PageInfo<>(all, 3);

        ResponseVo responseVo = new ResponseVo();

        responseVo.setCode("1");

        responseVo.setPath(request.getRequestURI());

        responseVo.setDate(new Date());

        responseVo.setMessage("请求成功");

        responseVo.getInfo().put("data",shRolePageInfo);

        return responseVo;
    }
}
