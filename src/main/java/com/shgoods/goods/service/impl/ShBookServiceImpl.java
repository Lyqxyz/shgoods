package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.service.ShBookService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author lyq
 */
@Service
public class ShBookServiceImpl implements ShBookService {

    @Autowired
    ShBookMapper shBookMapper;

    @Override
    public ResponseVo addBook(ShBook shBook) {


        List<String> errors = checkAttrs(shBook);

        ResponseVo responseVo = new ResponseVo();

        if(errors.size()>0){

            responseVo.getErrors().put("errors",errors);

            responseVo.setCode("-1");

            responseVo.setMessage("添加失败");
        }else{

            Integer integer = shBookMapper.addBook(shBook);

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


    public List<String> checkAttrs(ShBook shBook){

        List<String> errors = new ArrayList<>();

        ShBook shBook1 = shBookMapper.checkISBN(shBook);


        if(!Objects.isNull(shBook1)){

            errors.add("ISBN已经存在");

        }

        return errors;


    }
}
