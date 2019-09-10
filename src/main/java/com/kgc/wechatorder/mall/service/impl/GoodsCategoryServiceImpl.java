package com.kgc.wechatorder.mall.service.impl;

import com.kgc.wechatorder.mall.dao.GoodsCategoryMapper;
import com.kgc.wechatorder.mall.pojo.GoodsCategory;
import com.kgc.wechatorder.mall.service.GoodsCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class GoodsCategoryServiceImpl implements GoodsCategoryService {
    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;
    @Override
    public List<GoodsCategory> findAllGoodsCategory() {
        return goodsCategoryMapper.findAllGoodsCategory();
    }
}
