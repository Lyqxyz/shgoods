package com.shgoods.goods.vo.authority;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * @author lyq
 * 收集权限数据
 */
@Data
public class AddAuthVo {

    @NotNull(message = "编号解析异常")
    @NotBlank(message = "编号不能为空")
    private String num;

    @NotNull(message = "名字解析异常")
    @NotBlank(message = "名字不能为空")
    private String name;

    private String des;

}
