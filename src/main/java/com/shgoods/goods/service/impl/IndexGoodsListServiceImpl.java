package com.shgoods.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.shgoods.goods.mapper.ShBookDesMapper;
import com.shgoods.goods.mapper.ShBookMapper;
import com.shgoods.goods.mapper.ShGoodsDesMapper;
import com.shgoods.goods.mapper.ShGoodsMapper;
import com.shgoods.goods.pojo.ShBook;
import com.shgoods.goods.pojo.ShBookDescription;
import com.shgoods.goods.pojo.ShClass;
import com.shgoods.goods.pojo.ShGoodsDescription;
import com.shgoods.goods.service.IndexGoodsListService;
import com.shgoods.goods.vo.index.GoodsListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class IndexGoodsListServiceImpl implements IndexGoodsListService {

    @Autowired
    ShBookDesMapper shBookDesMapper;

    @Autowired
    ShGoodsDesMapper shGoodsDesMapper;


    @Mapper
    ShBookMapper shBookMapper;

    @Mapper
    ShGoodsMapper shGoodsMapper;

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

            goodsListVo.setImage(shGoodsDescription.getDesInfo());

            goodsListVo.setPrice(shGoodsDescription.getGoodsId().getGoodsSellingPrice());

            goodsListVo.setOkBook(0);

            goodsListVo.setXsImage(shGoodsDescription.getDesXsPath());

            all.add(goodsListVo);
        }


        return all;

    }

    @Override
    public List<GoodsListVo> selectByClass(ShClass shClass) {

        List<ShBookDescription> shBookDescriptions = shBookDesMapper.selectByClass(shClass);

        List<ShGoodsDescription> shGoodsDescriptions = shGoodsDesMapper.selectByClass(shClass);

        List<GoodsListVo> all = new ArrayList<>();

        if(Objects.isNull(shBookDescriptions)||shBookDescriptions.size()<=0 ){

            System.out.println("没有书籍");
        }else {

            for (ShBookDescription shBookDescription:shBookDescriptions){

                GoodsListVo goodsListVo = new GoodsListVo();

                goodsListVo.setId(shBookDescription.getGoodsId().getBookId());

                goodsListVo.setName(shBookDescription.getGoodsId().getBookName());

                goodsListVo.setImage(shBookDescription.getDesInfo());

                goodsListVo.setPrice(shBookDescription.getGoodsId().getBookSellingPrice());

                goodsListVo.setOkBook(1);

                goodsListVo.setXsImage(shBookDescription.getDesXsPath());

                all.add(goodsListVo);
            }
        }




        if(Objects.isNull(shGoodsDescriptions)||shGoodsDescriptions.size()<=0 ){
            System.out.println("没有用品");

        }else{
            for (ShGoodsDescription shGoodsDescription :shGoodsDescriptions){

                GoodsListVo goodsListVo = new GoodsListVo();

                goodsListVo.setId(shGoodsDescription.getGoodsId().getGoodsId());

                goodsListVo.setName(shGoodsDescription.getGoodsId().getGoodsTitle());

                goodsListVo.setImage(shGoodsDescription.getDesInfo());

                goodsListVo.setPrice(shGoodsDescription.getGoodsId().getGoodsSellingPrice());

                goodsListVo.setOkBook(0);

                goodsListVo.setXsImage(shGoodsDescription.getDesXsPath());

                all.add(goodsListVo);
            }

        }


        return all;
    }
}
