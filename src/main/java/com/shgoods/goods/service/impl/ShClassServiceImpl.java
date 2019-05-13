package com.shgoods.goods.service.impl;

import com.shgoods.goods.exception.FileUploadException;
import com.shgoods.goods.mapper.ShClassMapper;
import com.shgoods.goods.mapper.ShGoodsMapper;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.service.ShClassService;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class ShClassServiceImpl implements ShClassService {


    @Autowired
    ShClassMapper shClassMapper;

    @Override
    public ResponseVo addClass(ShClass shClass) {

        List<String> errors = this.checkAttrs(shClass);

        ResponseVo responseVo= new ResponseVo();

        responseVo.setDate(new Date());

        if(errors.size()>0){

            responseVo.getErrors().put("errors",errors);

            responseVo.setCode("-1");

            responseVo.setMessage("添加失败");
        }else{

            Integer integer = shClassMapper.addClass(shClass);

            if(integer==1){
                responseVo.setCode("1");
                responseVo.setMessage("添加成功");
            }else{
                responseVo.setCode("-1");
                responseVo.setMessage("添加失败");
                responseVo.getErrors().put("errors", Arrays.asList("非法添加"));
            }
        }

        return responseVo;

    }

    @Override
    public List<String> checkAttrs(ShClass shClass) {

        ShClass shClass1 = shClassMapper.checkClassNum(shClass);

        ShClass shClass2 = shClassMapper.checkClassName(shClass);

        List<String> errors = new ArrayList<>();
        if(!Objects.isNull(shClass1)){
            errors.add("编号已经存在了");
        }

        if (!Objects.isNull(shClass2)) {

            errors.add("名字已经存在了");

        }




        return errors;
    }

    @Override
    public List<ShClass> getNoPidClass() {

        List<ShClass> shClasses = shClassMapper.withoutParentClass();

        return shClasses;
    }

    @Override
    public List<ShClass> getClassByPid(ShClass shClass) {

        List<ShClass> shClasses = shClassMapper.selectClassByPid(shClass);

        return shClasses;
    }

    @Override
    public ResponseVo withParentClass() {

        ResponseVo ok = ResponseUtil.isOk();


        List<ShClass> shClasses = shClassMapper.withParentClass();


        ok.getInfo().put("data",shClasses);

        return ok;
    }

    @Override
    public ResponseVo del(String classId) {

        if(Objects.isNull(classId)){

            ResponseVo error = ResponseUtil.isError();
            error.setMessage("参数错误");

            return error;
        }

        Integer del = shClassMapper.del(classId);

        ResponseVo ok = ResponseUtil.isOk();

        ok.setMessage("删除成功");

        return ok;
    }

    @Override
    public ResponseVo update(ShClass shClass) {

        List<String> strings = this.checkAttrs(shClass);

        if(strings.size()>0){

            ResponseVo error = ResponseUtil.isError();

            error.setMessage("添加失败");

            error.getErrors().put("err",strings);

            return error;
        }else{

            Integer update = shClassMapper.update(shClass);

            ResponseVo ok = ResponseUtil.isOk();
            ok.setMessage("修改成功");

            return ok;
        }
    }
}
