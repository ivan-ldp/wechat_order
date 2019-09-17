package com.kgc.wechatorder.mall.service;

import com.kgc.wechatorder.mall.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsService {
    /**
     * 按商品分类id查询
     *
     * @param sortId
     * @return
     */
    public List<Goods> findGoodsListById1(int sortId);

    /**
     * 按商品条件进行分页查询
     *
     * @param goodsName
     * @param status
     * @param currentPageNo
     * @param categoryId
     * @param pageSize
     * @return
     */
    public List<Goods> findGoodsListById2(@Param("goodsName") String goodsName,
                                          @Param("status") Integer status,
                                          @Param("categoryId") Integer categoryId,
                                          @Param("currentPageNo") Integer currentPageNo,
                                          @Param("pageSize") Integer pageSize);

    /**
     * 按商品id查询
     *
     * @param goodsId
     * @return
     */
    public Goods getGoodsById(int goodsId);

    /**
     * 按商品id和num进行操作剩余库存
     *
     * @param id
     * @param num
     * @return
     */
    public int updateRemaining(@Param("id") int id, @Param("num") int num);

    /**
     * 增加商品
     *
     * @param goods
     * @return
     */
    public int add(Goods goods);

    /**
     * 修改商品
     *
     * @param goods
     * @return
     */
    public int modify(Goods goods);

    /**
     * 删除商品
     *
     * @param goodsId
     * @return
     */
    public int deleteGoodsById(int goodsId);

    /**
     * 获取商品数量
     *
     * @param goodsName
     * @param status
     * @return
     */
    public int getGoodsCount(@Param("goodsName") String goodsName,
                             @Param("status") int status,
                             @Param("categoryId") int categoryId);
}
