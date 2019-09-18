package com.kgc.wechatorder.mall.service;

import com.kgc.wechatorder.mall.pojo.DingDanDelivery;
import org.apache.ibatis.annotations.Param;

public interface DingDanDeliveryService {
    public DingDanDelivery getDingDanDeliveryById(@Param("id") Integer id);
}
