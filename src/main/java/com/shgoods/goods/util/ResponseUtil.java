package com.shgoods.goods.util;

import com.shgoods.goods.vo.ResponseVo;

import java.util.Date;

/**
 * @author lyq
 * 返回的结果
 */
public class ResponseUtil {

    public static  ResponseVo isOk(){

        ResponseVo responseVo= new ResponseVo();

        responseVo.setCode("1");

        responseVo.setMessage("请求成功");

        responseVo.setDate(new Date());

        return responseVo;

    }

    public static  ResponseVo isError(){

        ResponseVo responseVo= new ResponseVo();

        responseVo.setCode("-1");

        responseVo.setMessage("请求失败");

        responseVo.setDate(new Date());

        return responseVo;

    }

}
