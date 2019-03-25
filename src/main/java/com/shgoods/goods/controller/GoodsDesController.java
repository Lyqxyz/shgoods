package com.shgoods.goods.controller;

import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.pojo.ShGoodsDescription;
import com.shgoods.goods.service.ShGoodsDesService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequestMapping(path = "/goodsDes")
public class GoodsDesController {


    @Autowired
    ShGoodsDesService shGoodsDesService;

    @GetMapping(path = "/search/{goodsId}")
    @ResponseBody
    public Object search(@PathVariable(value = "goodsId")String goodsId, HttpServletRequest request){


        ShGoods shGoods = new ShGoods();

        shGoods.setGoodsId(goodsId);

        ResponseVo search = shGoodsDesService.search(shGoods);

        search.setPath(request.getRequestURI());

        return search;

    }

    @ResponseBody
    @PostMapping(path = "/addPic/{goodsId}")
    public Object addPicToBook(@PathVariable(value = "goodsId") String goodsId, MultipartFile[] files, HttpServletRequest request) throws IOException {

        ResponseVo responseVo = shGoodsDesService.addPicToGoods(files, goodsId);

        responseVo.setPath(request.getRequestURI());

        return responseVo;
    }

    @ResponseBody
    @GetMapping(path = "/del/{goodsDesId}")
    public Object del(@PathVariable(value = "goodsDesId") String goodsDesId,HttpServletRequest request){

        ShGoodsDescription shGoodsDescription = new ShGoodsDescription();

        shGoodsDescription.setDesId(goodsDesId);

        ResponseVo del = shGoodsDesService.del(shGoodsDescription);


        return del;

    }


    @GetMapping(path = "/AddPic")
    public String addPic(){

        return "goods/GoodsAddPic";

    }

}
