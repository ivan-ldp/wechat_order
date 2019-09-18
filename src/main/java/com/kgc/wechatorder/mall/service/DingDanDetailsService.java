package com.kgc.wechatorder.mall.service;

import com.kgc.wechatorder.mall.pojo.DingDanDetails;
import org.apache.ibatis.annotations.Param;

public interface DingDanDetailsService {
    public DingDanDetails getDingDanDetailsById(@Param("id") Integer id);
}
