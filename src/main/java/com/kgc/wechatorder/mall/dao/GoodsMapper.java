package com.kgc.wechatorder.mall.dao;

import com.kgc.wechatorder.mall.pojo.Goods;
import com.sun.deploy.ui.AppInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品接口类
 */
public interface GoodsMapper {
    /**
     * 按商品分类id查询
     *
     * @param sortId
     * @return
     */
    public List<Goods> findGoodsListById1(int sortId) throws Exception;

    /**
     * 按商品条件进行分页查询
     *
     * @param goodsName
     * @param status
     * @param xiaoLiang
     * @param currentPageNo
     * @param goodsName
     * @param pageSize
     * @return
     */
    public List<Goods> findGoodsListById2(@Param("goodsName") String goodsName,
                                          @Param("status") int status,
                                          @Param("xiaoLiang") int xiaoLiang,
                                          @Param("currentPageNo") int currentPageNo,
                                          @Param("pageSize") int pageSize) throws Exception;

    /**
     * 按商品id查询
     *
     * @param goodsId
     * @return
     */
    public Goods getGoodsById(int goodsId) throws Exception;

    /**
     * 按商品id和num进行操作剩余库存
     *
     * @param id
     * @param num
     * @return
     */
    public int updateRemaining(@Param("id") int id, @Param("num") int num) throws Exception;

    /**
     * 增加商品
     *
     * @param goods
     * @return
     */
    public int add(Goods goods) throws Exception;

    /**
     * 修改商品
     *
     * @param goods
     * @return
     */
    public int modify(Goods goods) throws Exception;

    /**
     * 删除商品
     *
     * @param goodsId
     * @return
     */
    public int deleteGoodsById(@Param(value = "id") int goodsId) throws Exception;

    /**
     * 获取商品数量
     *
     * @param
     * @return
     */
    public int getGoodsCount(String goodsName) throws Exception;
}
