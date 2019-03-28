package com.shgoods.goods.service;

import com.shgoods.goods.vo.index.GoodsListVo;

import java.util.List;

public interface IndexGoodsListService {

    List<GoodsListVo> all(Integer pageNum,Integer pageSize);

}
