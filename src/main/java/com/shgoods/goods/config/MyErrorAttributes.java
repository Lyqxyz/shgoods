package com.shgoods.goods.config;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.validation.ObjectError;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

/**
 * 自定义响应数据
 *
 * @author lyq
 *
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);

        errorAttributes.remove("exception");

        errorAttributes.remove("trace");

        errorAttributes.remove("errors");

        errorAttributes.put("message","服务器错误");

        errorAttributes.put("code","-1");


        return errorAttributes;
    }
}
