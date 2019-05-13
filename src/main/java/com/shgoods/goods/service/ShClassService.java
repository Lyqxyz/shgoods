package com.shgoods.goods.service;

import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.vo.ResponseVo;

import java.util.List;

/**
 * @author lyq
 * 分类信息
 */
public interface ShClassService {

     ResponseVo addClass(ShClass shClass);

     List<String> checkAttrs(ShClass shClass);

     List<ShClass> getNoPidClass();

     List<ShClass> getClassByPid(ShClass shClass);

     ResponseVo withParentClass();

     ResponseVo del(String classId);

     ResponseVo update(ShClass shClass);

}
