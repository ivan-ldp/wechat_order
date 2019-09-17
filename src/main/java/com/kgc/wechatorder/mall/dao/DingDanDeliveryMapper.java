package com.kgc.wechatorder.mall.dao;

import com.kgc.wechatorder.mall.pojo.DingDanDelivery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DingDanDeliveryMapper {
    DingDanDelivery getDingDanDeliveryById(@Param("id") Integer id);
}
