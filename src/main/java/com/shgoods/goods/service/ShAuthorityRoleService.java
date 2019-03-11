package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.vo.ResponseVo;
import org.apache.tomcat.util.http.parser.Authorization;

public interface ShAuthorityRoleService {


    ResponseVo Authorization(ShRole shRole);

}
