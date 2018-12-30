package com.shgoods.goods.pojo;


import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.support.spring.annotation.FastJsonView;
import lombok.Data;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lyq
 */
@Data
public class ShUser implements Serializable {

    private String userId;

    private String userNum;

    private String userName;

    private Integer userGender;

    private String userPwd;

    private String userPhone;

    private String userEmail;

    @JSONField(format = "YYYY-mm-dd HH:MM:SS")
    private Date userRegtime;
    @JSONField(format = "YYYY-mm-dd HH:MM:SS")
    private Date userLogintime;

    private Integer userIsactive;

    private String userRegip;

    private String userLoginip;

    private String userPhoto;

    //private String userCid;
    private ShCollege userCid;

    private Integer userState;

}
