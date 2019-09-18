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

    /**
     * 增加商品分类
     * @param
     * @return
     */
    public int add(GoodsCategory goodsCategory);
    /**
     * 删除商品分类
     * @param
     * @return
     */
    public int delete(int categoryId);
    /**
     * 更改商品分类
     * @param
     * @return
     */
    public int modify(GoodsCategory goodsCategory);

    /**
     * 获取所有的商品分类凭借Id
     * @param categoryId
     * @return
     */
    GoodsCategory findGoodsCategory(int categoryId);
}
