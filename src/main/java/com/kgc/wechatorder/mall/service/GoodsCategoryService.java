package com.kgc.wechatorder.mall.service;

import com.kgc.wechatorder.mall.pojo.GoodsCategory;

import java.util.List;

public interface GoodsCategoryService {
    /**
     * 获取所有的商品分类
     * @param
     * @return
     */
    List<GoodsCategory> findAllGoodsCategory();

}
