package com.kgc.wechatorder.mall.service.impl;

import com.kgc.wechatorder.mall.dao.GoodsMapper;
import com.kgc.wechatorder.mall.pojo.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GoodsMapperImpl implements GoodsMapper {
    @Resource
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> findGoodsListById1(int sortId) {
        return goodsMapper.findGoodsListById1(sortId);
    }

    @Override
    public List<Goods> findGoodsListById2(String goodsName, int status, int xiaoLiang, int currentPageNo, int pageSize) {
        return goodsMapper.findGoodsListById2(goodsName,status,xiaoLiang,currentPageNo,pageSize);
    }

    @Override
    public Goods getGoodsById(int goodsId) {
        return goodsMapper.getGoodsById(goodsId);
    }

    @Override
    public int updateRemaining(int id, int num) {
        return goodsMapper.updateRemaining(id,num);
    }

    @Override
    public int add(Goods goods) {
        return goodsMapper.add(goods);
    }

    @Override
    public int modify(Goods goods) {
        return goodsMapper.modify(goods);
    }

    @Override
    public int deleteGoodsById(int goodsId) {
        return goodsMapper.deleteGoodsById(goodsId);
    }

    @Override
    public int getGoodsCount(String goodsName) {
        return goodsMapper.getGoodsCount(goodsName);
    }
}
