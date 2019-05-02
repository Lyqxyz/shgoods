package com.shgoods.goods.controller;

import com.shgoods.goods.dto.ClassInfoDto;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.service.ShClassService;
import com.shgoods.goods.service.dto.ClassInfoDtoService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.vo.ResponseVo;
import com.shgoods.goods.vo.classinfo.AddClassVo;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    ClassInfoDtoService classInfoDtoService;

    @GetMapping(value ="/addView")
    public String addView(){
        return "classInfo/addClass";
    }
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

    @ResponseBody
    @RequestMapping(value = "/add")
    public Object add(@Validated AddClassVo addClassVo, BindingResult result,HttpServletRequest request){

        ShClass shClass = new ShClass();

        shClass.setClassNum(addClassVo.getClassInfoNum());

        shClass.setClassName(addClassVo.getClassInfoName());

        shClass.setClassPid(addClassVo.getClassInfoPid());

        ResponseVo responseVo;

        if(result.hasErrors()){

            responseVo = BindingErrorUtil.common("添加失败", request.getRequestURI(), result);

        }else{

            responseVo = shClassService.addClass(shClass);

        }
        responseVo.setPath(request.getRequestURI());
        return responseVo;

    }

    @ResponseBody
    @GetMapping(value ="/allInfo")
    public Object info(HttpServletRequest request){

        List<ClassInfoDto> all = classInfoDtoService.findAll();

        ResponseVo responseVo = new ResponseVo();

        responseVo.setMessage("所有信息");

        responseVo.setDate(new Date());

        responseVo.setCode("1");

        responseVo.setPath(request.getRequestURI());

        responseVo.getInfo().put("data",all);

        return responseVo;
    }

    @ResponseBody
    @GetMapping(value ="/InfoWithoutPid")
    public Object noPidClassInfo(HttpServletRequest request){
        List<ShClass> noPidClass = shClassService.getNoPidClass();

        ResponseVo responseVo = new ResponseVo();

        responseVo.setMessage("所有信息");

        responseVo.setDate(new Date());

        responseVo.setCode("1");

        responseVo.setPath(request.getRequestURI());

        responseVo.getInfo().put("data",noPidClass);

        return responseVo;
    }


    @ResponseBody
    @GetMapping(value = "/pid/{pid}")
    public Object findClassByPid(@PathVariable("pid") String pid,HttpServletRequest request){
        ResponseVo responseVo = new ResponseVo();

        responseVo.setCode("1");

        responseVo.setDate(new Date());

        responseVo.setMessage("请求成功");

        responseVo.setPath(request.getRequestURI());

        if(pid==null){
            responseVo.setCode("-1");
            responseVo.setMessage("请求失败");
        }else{

            ShClass shClass = new ShClass();

            shClass.setClassPid(pid);

            List<ShClass> classByPid = shClassService.getClassByPid(shClass);

            responseVo.getInfo().put("data",classByPid);

        }

        return responseVo;

    }

    @ResponseBody
    @GetMapping(path = "/withParentClass")
    public Object withParentClass(HttpServletRequest request){

        ResponseVo responseVo = shClassService.withParentClass();


        responseVo.setPath(request.getRequestURI());


        return responseVo;
    }


}
