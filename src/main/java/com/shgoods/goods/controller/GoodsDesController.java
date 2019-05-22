package com.shgoods.goods.controller;

import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShBookDescription;
import com.shgoods.goods.pojo.ShGoods;
import com.shgoods.goods.pojo.ShGoodsDescription;
import com.shgoods.goods.service.ShGoodsDesService;
import com.shgoods.goods.util.FileUploadUtil;
import com.shgoods.goods.util.ResponseUtil;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(path = "/goodsDes")
public class GoodsDesController {


    @Autowired
    ShGoodsDesService shGoodsDesService;

    @Autowired
    FileUploadUtil fileUploadUtil;

    @GetMapping(path = "/search/{goodsId}")
    @ResponseBody
    public Object search(@PathVariable(value = "goodsId")String goodsId, HttpServletRequest request){


        ShGoods shGoods = new ShGoods();

        shGoods.setGoodsId(goodsId);

        ResponseVo search = shGoodsDesService.search(shGoods);

        search.setPath(request.getRequestURI());

        return search;

    }

    @ResponseBody
    @PostMapping(path = "/addPic/{goodsId}")
    public Object addPicToBook(@PathVariable(value = "goodsId") String goodsId, MultipartFile[] files, HttpServletRequest request) throws IOException {

        ResponseVo responseVo = shGoodsDesService.addPicToGoods(files, goodsId);

        responseVo.setPath(request.getRequestURI());

        return responseVo;
    }

    @ResponseBody
    @GetMapping(path = "/del/{goodsDesId}")
    public Object del(@PathVariable(value = "goodsDesId") String goodsDesId,HttpServletRequest request){

        ShGoodsDescription shGoodsDescription = new ShGoodsDescription();

        shGoodsDescription.setDesId(goodsDesId);

        ResponseVo del = shGoodsDesService.del(shGoodsDescription);


        return del;

    }


    @GetMapping(path = "/AddPic")
    public String addPic(){

        return "goods/GoodsAddPic";

    }


    @GetMapping(path = "/AddPic/{goodsId}")
    public String addPic(@PathVariable String goodsId, Model model){

        model.addAttribute("goodsId",goodsId);
        return "goods/GoodsAddPic";

    }

    @ResponseBody
    @PostMapping("/updatePic")
    public Object updatePic(@RequestParam("id")String gid,
                            @RequestParam("file")MultipartFile file){

        try {

            ShGoodsDescription shGoodsDescription = new ShGoodsDescription();

            ShGoods shGoods = new ShGoods();

            shGoods.setGoodsId(gid);

            shGoodsDescription.setGoodsId(shGoods);

            List<String> bookImage = fileUploadUtil.upload(file, "goodsImage");

            for(String image : bookImage){

                if(image.contains("5050")){

                    shGoodsDescription.setDesSmPath(image);

                }else if(image.contains("100200")){

                    shGoodsDescription.setDesMdPath(image);

                }else if(image.contains("300500")){

                    shGoodsDescription.setDesXsPath(image);

                }else{

                    shGoodsDescription.setDesInfo(image);
                }

            }
            ResponseVo responseVo = shGoodsDesService.updatePic(shGoodsDescription);

            return responseVo;

        } catch (IOException e) {


            ResponseVo error = ResponseUtil.isError();

            error.setMessage("文件上传失败，请换一张试试");

            return error;

        }

    }


}
