package com.shgoods.goods.vo.role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author lyq
 * 采集增加角色页面的数据
 */
public class RoleAddVo {


    @NotBlank(message = "编号不能为空")
    @NotNull(message = "编号解析异常")
    private String roleNum;

    @NotBlank(message = " 角色名不能为空")
    @NotNull(message = "角色名解析异常")
    private String roleName;

    private String roleDes;

}
