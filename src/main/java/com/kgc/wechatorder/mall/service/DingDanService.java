package com.kgc.wechatorder.mall.service;

import com.kgc.wechatorder.mall.pojo.DingDan;
import org.apache.ibatis.annotations.Param;

public interface DingDanService {
    public DingDan getDingDanById(@Param("orderid") Integer orderid,
                                    @Param("orderStatus")Integer orderStatus);

    //查询全部订单
    DingDan selectDingDan();

    //对订单进行修改
    DingDan updateDingDan(@Param("orderid") Integer orderid);
}
