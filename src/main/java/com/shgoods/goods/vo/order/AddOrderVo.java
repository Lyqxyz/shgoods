package com.shgoods.goods.vo.order;

import com.shgoods.goods.pojo.ShUser;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class AddOrderVo {

    private String orderNum;

    @NotBlank(message = "用户不能为空")
    @NotNull(message = "用户解析错误")
    private String orderUid;

    private Double orderPrice;

    @NotBlank(message = "地址不能为空")
    @NotNull(message = "地址解析错误")
    private String orderAddress;

}
