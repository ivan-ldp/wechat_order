package com.kgc.wechatorder.mall.service;

import org.apache.ibatis.annotations.Param;

public interface DingDanService {
    public boolean getDingDanById(@Param("orderid") Integer orderid);
}
