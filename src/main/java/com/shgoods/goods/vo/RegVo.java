package com.shgoods.goods.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;


/**
 * @author lyq
 * 注册参数封装
 */
@Data
public class RegVo {

    @NotBlank(message = "学号不能为空")
    @NotNull(message = "学号解析异常")
    private String num;

    @Length(min = 4,max = 8,message = "名字4-8位")
    @NotBlank(message = "名字不能为空")
    private String name;

    @NotBlank(message = "密码不能为空")
    @NotNull(message = "密码解析异常")
    private String password;

    @NotBlank(message = "邮箱不能为空")
    @NotNull(message = "邮箱解析异常")
    @Email(message = "邮箱格式不正确")
    private String email;

    @NotBlank(message = "电话不能为空")
    @NotNull(message = "电话解析异常")
    private String phone;

    private Integer gender;

    @NotBlank(message = "验证码不能为空")
    @NotNull(message = "验证码解析异常")
    private String code;


}
