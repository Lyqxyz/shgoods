package com.shgoods.goods.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.shgoods.goods.pojo.ShCollege;
import com.shgoods.goods.pojo.ShUser;
import lombok.Data;

import java.util.Date;

/**
 * @author lyq
 * 来自数据库的用户信息
 */
@Data
public class UserInfoDto {

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

    private ShCollege userCid;

    private Integer userState;


    private String collegeId;
    private String collegeNum;
    private String collegeName;
    private String collegeDes;
    private Integer collegeState;

//
//    private ShUser shUser;
//    private ShCollege shCollege;

}
