package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

/**
 * @author lyq
 */
public interface ShAuthorityService {

     ResponseVo add(ShAuthority shAuthority);

     List<ShAuthority> info();

     ResponseVo forbid(ShAuthority shAuthority);

     ResponseVo del(ShAuthority shAuthority);

     ResponseVo active(ShAuthority shAuthority);

}
