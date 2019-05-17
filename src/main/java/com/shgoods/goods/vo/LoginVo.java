package com.shgoods.goods.vo;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lyq
 */
@Data
public class LoginVo {

    /**
     *  用户名
     */
    @NotBlank(message = "用户名不能为空")
    @NotNull(message = "用户名解析错误")
    private String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @NotNull(message = "密码解析错误")
    private String pwd;
//    /**
//     * token检验
//     */
//    @NotBlank(message = "错误提交")
//    @NotNull(message = "非法提交")
//    private String token;
}
