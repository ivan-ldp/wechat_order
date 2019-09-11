package com.kgc.wechatorder.mall.dao;

import com.kgc.wechatorder.mall.pojo.GoodsCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 商品分类接口类
 */
@Mapper
public interface GoodsCategoryMapper {
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
}
