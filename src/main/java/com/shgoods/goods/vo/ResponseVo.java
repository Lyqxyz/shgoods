package com.shgoods.goods.vo;



import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lyq
 * 响应信息
 */
@Data
public class ResponseVo implements Serializable {

    private String code;
    private String message;
    @JSONField(format = "YYYY-MM-dd HH:mm:ss")
    private Date date;
    private String path;
    private Map<String,Object> info=new HashMap<>();
    private Map<String,Object> errors= new HashMap<>();

}
