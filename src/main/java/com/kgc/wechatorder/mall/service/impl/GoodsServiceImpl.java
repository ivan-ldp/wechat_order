package com.kgc.wechatorder.mall.service.impl;

import com.kgc.wechatorder.mall.dao.GoodsMapper;
import com.kgc.wechatorder.mall.pojo.Goods;
import com.kgc.wechatorder.mall.service.GoodsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> findGoodsListById1(Integer sortId) {
        return goodsMapper.findGoodsListById1(sortId);
    }

    @Override
    public List<Goods> findGoodsListById2(String goodsName, Integer status, Integer categoryId) {
        return goodsMapper.findGoodsListById2(goodsName,status,categoryId);
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
    public int getGoodsCount(String goodsName, Integer status, Integer categoryId) {
     return goodsMapper.getGoodsCount(goodsName,status,categoryId);
    }


}
