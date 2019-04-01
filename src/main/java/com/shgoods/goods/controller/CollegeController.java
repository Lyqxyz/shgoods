package com.shgoods.goods.controller;


import com.shgoods.goods.pojo.ShCollege;
import com.shgoods.goods.service.ShCollegeService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;
import java.util.Date;
import java.util.List;

/**
 * 学院信息表
 * @author lyq
 */


@Controller
@RequestMapping(value = "/college")
public class CollegeController {

    @Autowired
    ShCollegeService shCollegeService;

    @GetMapping(value = "/info")
    @ResponseBody
    public Object allCollege(HttpServletRequest request){

        List<ShCollege> shColleges = shCollegeService.allCollege();

        ResponseVo responseVo = new ResponseVo();

        responseVo.setCode("1");

        responseVo.setDate(new Date());

        responseVo.setMessage("学院信息");

        responseVo.setPath(request.getRequestURI());

        responseVo.getInfo().put("data",shColleges);

        return responseVo;
    }


}
