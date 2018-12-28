package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ShUserRole {

    private String urId;

    private ShUser urUid;
    private ShRole urRid;

    private Integer urState;
    private Date urCreationTime;
    private Date urUpdateTime;

}
