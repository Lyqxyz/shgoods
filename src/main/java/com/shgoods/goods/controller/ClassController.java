package com.shgoods.goods.controller;

import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.service.ShClassService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@RequestMapping(value = "/class")
@Controller
public class ClassController {


    @Autowired
    ShClassService shClassService;

    @ResponseBody
    @RequestMapping(value = "/info")
    public Object ClassInfo(HttpServletRequest request){

        ResponseVo responseVo = new ResponseVo();
        responseVo.setCode("1");

        responseVo.setDate(new Date());

        responseVo.setMessage("分类信息");

        responseVo.setPath(request.getRequestURI());

        List<ShClass> noPidClass = shClassService.getNoPidClass();

        responseVo.getInfo().put("data",noPidClass);

        return responseVo;

    }



}
