package com.shgoods.goods.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class ShAuthorityRole {

    private String arId;
    private ShAuthority arAid;
    private ShRole arRid;
    private Integer arState;
    private Date arCreationTime;
    private Date arUpdateTime;
}
