package com.shgoods.goods.bean;

import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.pojo.ShUser;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author lyq
 * 用户角色权限信息
 */
@Data
public class UserRoleAuth implements Serializable {

    private ShUser shUser;

    private List<ShRole> shRoles;

    private List<ShAuthority> shAuthorities;

}
