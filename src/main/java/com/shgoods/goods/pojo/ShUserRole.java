package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ShUserRole {

    private String urId;
    private Integer urState;
    private Date urCreationTime;
    private Date urUpdateTime;
    private ShUser urUid;
    private ShRole urRid;
//    private List<ShRole> shRoles;
//    private List<ShUser> shUsers;
}
