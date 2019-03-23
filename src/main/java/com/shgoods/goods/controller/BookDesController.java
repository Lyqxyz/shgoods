package com.shgoods.goods.controller;


import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.service.ShBookDesService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/bookDes")
public class BookDesController {


    @Autowired
    ShBookDesService shBookDesService;

    @GetMapping(path = "/search/{bookId}")
    @ResponseBody
    public Object search(@PathVariable(value = "bookId")String bookId, HttpServletRequest request){

        ShBook shBook= new ShBook();

        shBook.setBookId(bookId);

        ResponseVo search = shBookDesService.search(shBook);

        search.setPath(request.getRequestURI());

        return search;

    }

    @GetMapping(path = "/AddPic")
    public String addPic(){

        return "book/bookAddPic";

    }

}
