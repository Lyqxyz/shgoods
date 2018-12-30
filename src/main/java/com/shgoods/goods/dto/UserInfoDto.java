package com.shgoods.goods.dto;

import com.shgoods.goods.pojo.ShCollege;
import com.shgoods.goods.pojo.ShUser;
import lombok.Data;

/**
 * @author lyq
 * 来自数据库的用户信息
 */
@Data
public class UserInfoDto {

    private ShUser shUser;
    private ShCollege shCollege;

}
