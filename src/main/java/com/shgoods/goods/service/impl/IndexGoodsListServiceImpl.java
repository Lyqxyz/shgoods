package com.shgoods.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.shgoods.goods.mapper.ShBookDesMapper;
import com.shgoods.goods.mapper.ShGoodsDesMapper;
import com.shgoods.goods.pojo.ShBookDescription;
import com.shgoods.goods.pojo.ShGoodsDescription;
import com.shgoods.goods.service.IndexGoodsListService;
import com.shgoods.goods.vo.index.GoodsListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndexGoodsListServiceImpl implements IndexGoodsListService {

    @Autowired
    ShBookDesMapper shBookDesMapper;

    @Autowired
    ShGoodsDesMapper shGoodsDesMapper;


    @Override
    public List<GoodsListVo> all(Integer pageNum,Integer pageSize) {


        PageHelper.startPage(pageNum, pageSize);
        List<ShBookDescription> allBooks = shBookDesMapper.all();


        PageHelper.startPage(pageNum, pageSize);
        List<ShGoodsDescription> allGoods = shGoodsDesMapper.all();

        List<GoodsListVo> all = new ArrayList<>();

        for (ShBookDescription shBookDescription:allBooks){

            GoodsListVo goodsListVo = new GoodsListVo();

            goodsListVo.setId(shBookDescription.getGoodsId().getBookId());

            goodsListVo.setName(shBookDescription.getGoodsId().getBookName());

            goodsListVo.setImage(shBookDescription.getDesSmPath());

            goodsListVo.setPrice(shBookDescription.getGoodsId().getBookSellingPrice());

            goodsListVo.setOkBook(1);

            goodsListVo.setXsImage(shBookDescription.getDesXsPath());

            all.add(goodsListVo);
        }

        for (ShGoodsDescription shGoodsDescription :allGoods){

            GoodsListVo goodsListVo = new GoodsListVo();

            goodsListVo.setId(shGoodsDescription.getGoodsId().getGoodsId());

            goodsListVo.setName(shGoodsDescription.getGoodsId().getGoodsTitle());

            goodsListVo.setImage(shGoodsDescription.getDesSmPath());

            goodsListVo.setPrice(shGoodsDescription.getGoodsId().getGoodsSellingPrice());

            goodsListVo.setOkBook(0);

            goodsListVo.setXsImage(shGoodsDescription.getDesXsPath());

            all.add(goodsListVo);
        }


        return all;

    }
}
