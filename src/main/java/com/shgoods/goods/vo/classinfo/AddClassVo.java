package com.shgoods.goods.vo.classinfo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lyq
 */
@Data
public class AddClassVo {


    @NotBlank(message = "编号不能为空")
    @NotNull(message = "编号解析异常")
    private String classInfoNum;

    @NotBlank(message = "分类名不能为空")
    @NotNull(message = "分类名解析异常")
    private String classInfoName;
    private String classInfoPid;

}
