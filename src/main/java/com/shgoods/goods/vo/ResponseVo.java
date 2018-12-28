package com.shgoods.goods.vo;



import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyq
 * 响应信息
 */
@Data
public class ResponseVo {

    private String code;
    private String message;
    private Map<String,Object> info=new HashMap<>();
    private Map<String,Object> errors= new HashMap<>();
    private Date date;
    private String path;

}
