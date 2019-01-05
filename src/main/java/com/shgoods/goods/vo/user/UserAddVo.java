package com.shgoods.goods.vo.user;

import lombok.Data;
import org.hibernate.validator.constraints.pl.REGON;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 收集来自用户增加页面的数据
 * @author lyq
 *
 */
@Data
public class UserAddVo {

    @NotBlank(message = "学号不能为空")
    @NotNull(message = "学号解析错误")
    private String userNum;

    @NotBlank(message = "昵称不能为空")
    @NotNull(message = "昵称解析错误")
    private String userName;

    @Pattern(regexp = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$",message = "电话格式不正确")
    @NotBlank(message = "电话不能为空")
    @NotNull(message = "电话解析错误")
    private String userPhone;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @NotNull(message = "邮箱解析错误")
    private String userEmail;

    private String userGender;
    private String userCollege;

    @NotNull(message = "密码解析错误")
    @NotBlank(message = "密码不能为空")
    private String userPwd;
}
