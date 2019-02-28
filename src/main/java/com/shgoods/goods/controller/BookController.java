package com.shgoods.goods.controller;

import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.service.ShBookService;
import com.shgoods.goods.util.BindingErrorUtil;
import com.shgoods.goods.util.FileUploadUtil;
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

    @ResponseBody
    @PostMapping(value = "/add")
    public Object add(@RequestParam(value = "files") MultipartFile[] files ,@Validated AddBookVo addBookVo, BindingResult result, HttpServletRequest request) throws IOException{


        FileUploadUtil fileUploadUtil = new FileUploadUtil();

        ResponseVo responseVo = new ResponseVo();

        List<List<String>> bookImages = fileUploadUtil.upload(files, "bookImage");

        ShBook shBook  = new ShBook();

        BeanUtils.copyProperties(addBookVo,shBook);

        Map<String, List<String>> errors = BindingErrorUtil.handlerErrors(result);

        if(result.hasErrors()){

            responseVo = BindingErrorUtil.common("添加失败", request.getRequestURI(), result);

        }else{

            responseVo = shBookService.addBook(shBook);

            responseVo.getInfo().put("imagePaths",bookImages);

        }

        return responseVo;
    }

}
