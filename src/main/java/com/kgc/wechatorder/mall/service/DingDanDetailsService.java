package com.kgc.wechatorder.mall.service;

import org.apache.ibatis.annotations.Param;

public interface DingDanDetailsService {
    public  boolean getDingDanDetailsById(@Param("id") Integer id);
}
