package com.kgc.wechatorder.mall.dao;

import com.kgc.wechatorder.mall.pojo.DingDan;
import com.kgc.wechatorder.mall.pojo.DingDanDelivery;
import com.kgc.wechatorder.mall.pojo.DingDanDetails;
import com.kgc.wechatorder.mall.pojo.Goods;
import com.kgc.wechatorder.mall.service.DingDanDetailsService;
import com.kgc.wechatorder.wechat.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DingDanBornMapper {

    /**
     * 生成订单
     * @param dingDan
     * @return
     */
    //创建订单表
    DingDan addDingDan(DingDan dingDan);

    //创建配送表
    DingDanDelivery addDingDanDelivery(DingDanDelivery dingDanDelivery);

    //创建订单详情表
    DingDanDetails addDingDanDetails(DingDanDetails dingDanDetails);

    //订单中针对goods中的商品
    Goods selectGoodsById(@Param("goodsId") int id ,
                            @Param("goodsName")String name);
}
