package com.kgc.wechatorder.mall.dao;

import com.kgc.wechatorder.mall.pojo.DingDan;
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


    //生成订单号
    public String addOrderNumber();
}
