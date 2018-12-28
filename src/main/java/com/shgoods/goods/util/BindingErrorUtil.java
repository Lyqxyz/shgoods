package com.shgoods.goods.util;


import com.shgoods.goods.vo.ResponseVo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

/**
 * @author lyq
 * 处理 BindingResult
 * @see BindingResult
 */
public class BindingErrorUtil {

    public final static Map<String, List<String>> handlerErrors(BindingResult bindingResult){

        if(bindingResult.hasErrors()){

            Map<String,List<String>> errorMap = new HashMap<>();

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            for (FieldError fieldError : fieldErrors) {

                String field = fieldError.getField();

                List<String> strings =errorMap.get(field);
                if(strings!=null){
                    String defaultMessage = fieldError.getDefaultMessage();
                    strings.add(defaultMessage);
                }else {
                    List<String> message = new ArrayList<>();
                    String defaultMessage = fieldError.getDefaultMessage();
                    message.add(defaultMessage);
                    errorMap.put(field,message);
                }

            }
            return errorMap;
        }
        return null;
    }

    public final static ResponseVo common(String message,String url,BindingResult bindingResult){

        ResponseVo responseVo = new ResponseVo();
        Map<String, List<String>> errors = handlerErrors(bindingResult);
        responseVo.setCode("-1");
        responseVo.setDate(new Date());
        responseVo.setMessage(message);
        responseVo.setPath(url);
        responseVo.getErrors().put("AllError",errors);
        return responseVo;

    }

}
