package com.shgoods.goods.service.impl;

import com.shgoods.goods.mapper.ShAuthorityMapper;
import com.shgoods.goods.pojo.ShAuthority;
import com.shgoods.goods.pojo.ShRole;
import com.shgoods.goods.service.ShAuthorityService;
import com.shgoods.goods.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author lyq
 * 权限实现类
 */

@Service
public class ShAuthorityServiceImpl implements ShAuthorityService {

    @Autowired
    ShAuthorityMapper shAuthorityMapper;


    @Override
    public ResponseVo add(ShAuthority shAuthority) {

        List<String> errors = this.checkAttrs(shAuthority);

        ResponseVo responseVo= new ResponseVo();

        responseVo.setDate(new Date());

        if(errors.size()>0){

            responseVo.getErrors().put("errors",errors);

            responseVo.setCode("-1");

            responseVo.setMessage("添加失败");
        }else {

            Integer integer = shAuthorityMapper.insertAuthority(shAuthority);

            responseVo.setCode("1");

            responseVo.setMessage("添加成功");

        }

        return responseVo;
    }
    public List<String> checkAttrs(ShAuthority shAuthority){
        List<String> errors = new ArrayList<>();

        ShAuthority shAuthority1 = shAuthorityMapper.checkAuthNum(shAuthority);

        ShAuthority shAuthority2 = shAuthorityMapper.checkAuthName(shAuthority);

        if(!Objects.isNull(shAuthority1)){
            errors.add("编号已经存在了");
        }
        if (!Objects.isNull(shAuthority2)){
            errors.add("权限名已经存在了");
        }
        return errors;


    }
}
