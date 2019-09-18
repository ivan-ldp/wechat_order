package com.kgc.wechatorder.mall.service;

import com.kgc.wechatorder.mall.pojo.DingDan;
import com.kgc.wechatorder.mall.pojo.DingDanDelivery;
import com.kgc.wechatorder.mall.pojo.DingDanDetails;
import com.kgc.wechatorder.mall.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DingDanBornService {
    /**
     * 增加新订单
     * @param dingDan
     * @param dingDanDetails
     * @return
     */
    //产生新订单
    DingDan addDingDan(DingDan dingDan, List<DingDanDetails> dingDanDetails);
    //产生订单配送表的订单
    DingDanDelivery addDingDanDelivery(DingDanDelivery dingDanDelivery);
    //产生订单详情表
    DingDanDetails addDingDanDetails(DingDanDetails dingDanDetails);

    //凭id查询商品
    Goods selectGoodsById(@Param("goodsId") int id ,
                          @Param("goodsName")String name);
}
