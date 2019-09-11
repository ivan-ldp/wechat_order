package com.kgc.wechatorder.mall.dao;

import com.kgc.wechatorder.mall.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品接口类
 */
@Mapper
public interface GoodsMapper {
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
                                          @Param("status") int status,
                                          @Param("categoryId") int categoryId,
                                          @Param("uid") int uid,
                                          @Param("currentPageNo") int currentPageNo,
                                          @Param("pageSize") int pageSize);

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
     * @param categoryId
     * @param uid
     * @return
     */
    public int getGoodsCount(@Param("goodsName") String goodsName,
                             @Param("status") int status,
                             @Param("categoryId") int categoryId,
                             @Param("uid") int uid);
}