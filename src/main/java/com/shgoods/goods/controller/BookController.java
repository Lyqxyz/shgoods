package com.shgoods.goods.controller;

import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.vo.book.AddBookVo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author lyq
 * 书籍有关信息
 */
@Controller
@RequestMapping(path = "/book")
public class BookController {


    @ResponseBody
    @PostMapping(value = "/add")
    public Object add(@Validated AddBookVo addBookVo, BindingResult result){

        Map<String, List<String>> errors = BindingErrorUtil.handlerErrors(result);


        return errors;
    }

}
