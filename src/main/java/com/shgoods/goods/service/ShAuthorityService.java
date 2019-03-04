package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

/**
 * @author lyq
 */
public interface ShAuthorityService {

    public ResponseVo add(ShAuthority shAuthority);

    public List<ShAuthority> info();

    public ResponseVo forbid(ShAuthority shAuthority);

    public ResponseVo del(ShAuthority shAuthority);

}
