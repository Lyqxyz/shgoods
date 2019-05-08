package com.shgoods.goods.controller;


import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShBookDescription;
import com.shgoods.goods.pojo.ShGoodsDescription;
import com.shgoods.goods.service.ShBookDesService;
import com.shgoods.goods.util.FileUploadUtil;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path = "/bookDes")
public class BookDesController {

    @Autowired
    ShBookDesService shBookDesService;

    @Autowired
    FileUploadUtil fileUploadUtil;

    @GetMapping(path = "/search/{bookId}")
    @ResponseBody
    public Object search(@PathVariable(value = "bookId")String bookId, HttpServletRequest request){

        ShBook shBook= new ShBook();

        shBook.setBookId(bookId);

        ResponseVo search = shBookDesService.search(shBook);

        search.setPath(request.getRequestURI());

        return search;

    }

    @ResponseBody
    @GetMapping(path = "/del/{bookDesId}")
    public Object del(@PathVariable(value = "bookDesId") String bookDesId,HttpServletRequest request){

        ShBookDescription shBookDescription = new ShBookDescription();

        shBookDescription.setDesId(bookDesId);

        ResponseVo del = shBookDesService.del(shBookDescription);

        return del;

    }


    @ResponseBody
    @PostMapping("/updatePic")
    public Object updatePic(@RequestParam("id")String bookId, @RequestParam(value = "file")MultipartFile file){

        try {

            ShBookDescription shBookDescription = new ShBookDescription();

            ShBook shBook = new ShBook();

            shBook.setBookId(bookId);

            shBookDescription.setGoodsId(shBook);

            List<String> bookImage = fileUploadUtil.upload(file, "bookImage");

            for(String image : bookImage){

                if(image.contains("5050")){

                    shBookDescription.setDesSmPath(image);

                }else if(image.contains("100200")){

                    shBookDescription.setDesMdPath(image);

                }else if(image.contains("300500")){

                    shBookDescription.setDesXsPath(image);

                }else{

                    shBookDescription.setDesInfo(image);
                }

            }
            ResponseVo responseVo = shBookDesService.updatePic(shBookDescription);

            return responseVo;

        } catch (IOException e) {


            ResponseVo error = ResponseUtil.isError();

            error.setMessage("文件上传失败，请换一张试试");

            return error;

        }

    }

    @GetMapping(path = "/AddPic")
    public String addPic(){

        return "book/bookAddPic";

    }

}
