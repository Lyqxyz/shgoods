package com.shgoods.goods.exception.concroller;


import com.shgoods.goods.exception.FileUploadException;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 *
 * @author lyq
 */
@ControllerAdvice
public class FileUploadExceptionController {

    @ExceptionHandler(value = FileUploadException.class)
    @ResponseBody
    public Object exInfo(HttpServletRequest request){

        ResponseVo responseVo = new ResponseVo();

        responseVo.setCode("-1");

        responseVo.setDate(new Date());

        responseVo.setMessage("文件上传失败");

        responseVo.setPath(request.getRequestURI());

        return responseVo;

    }

}
