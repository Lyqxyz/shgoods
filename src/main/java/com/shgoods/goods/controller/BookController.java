package com.shgoods.goods.controller;

import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.service.ShBookDesService;
import com.shgoods.goods.service.ShBookService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.vo.ResponseVo;
import com.shgoods.goods.vo.book.AddBookVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author lyq
 * 书籍有关信息
 */
@Controller
@RequestMapping(path = "/book")
public class BookController {


    @Autowired
    ShBookService shBookService;

    @Autowired
    ShBookDesService shBookDesService;

    @ResponseBody
    @PostMapping(value = "/add")
    public Object add( @Validated AddBookVo addBookVo, BindingResult result, HttpServletRequest request) throws IOException{

        ResponseVo responseVo = new ResponseVo();

        ShBook shBook  = new ShBook();

        BeanUtils.copyProperties(addBookVo,shBook);

        Map<String, List<String>> errors = BindingErrorUtil.handlerErrors(result);

        if(result.hasErrors()){

            responseVo = BindingErrorUtil.common("添加失败", request.getRequestURI(), result);

        }else{

            responseVo = shBookService.addBook(shBook);

        }

        return responseVo;
    }


    @ResponseBody
    @PostMapping(path = "/addPic/{BookId}")
    public Object addPicToBook(@PathVariable(value = "BookId") String BookId,MultipartFile[] files,HttpServletRequest request) throws IOException {


        ResponseVo responseVo = shBookDesService.addPic(files, BookId);

        responseVo.setPath(request.getRequestURI());

        return responseVo;
    }

    @GetMapping(path = "/addView")
    public String addView(){


        return "book/addBook";
    }


}
