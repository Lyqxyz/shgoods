package com.shgoods.goods.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shgoods.goods.dto.UserInfoDto;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.service.IndexGoodsListService;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import com.shgoods.goods.vo.index.GoodsListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "/index")
public class IndexGoodsListController {

    @Autowired
    IndexGoodsListService indexGoodsListService;


    @GetMapping(value = "/list/{pageNum}/{pageSize}")
    public Object allUser(@PathVariable(value = "pageNum") Integer pageNum, @PathVariable(name = "pageSize") Integer pageSize, HttpServletRequest request){

        List<GoodsListVo> all = indexGoodsListService.all(pageNum,pageSize);

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
    @GetMapping(value = "/class/{id}")
    public Object selectByClass(@PathVariable(value = "id")String id,HttpServletRequest request){

        ResponseVo ok = ResponseUtil.isOk();

        ShClass shClass = new ShClass();

        shClass.setClassId(id);

        List<GoodsListVo> goodsListVos = indexGoodsListService.selectByClass(shClass);

        ok.setPath(request.getRequestURI());

        ok.getInfo().put("data",goodsListVos);

        return ok;


    }



}
