package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

/**
 * @author lyq
 * 分类信息
 */
public interface ShClassService {

    public ResponseVo addClass(ShClass shClass);

    public List<String> checkAttrs(ShClass shClass);

    public List<ShClass> getNoPidClass();


}
