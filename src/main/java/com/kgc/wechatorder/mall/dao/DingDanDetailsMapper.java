package com.kgc.wechatorder.mall.dao;

import com.kgc.wechatorder.mall.pojo.DingDanDetails;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DingDanDetailsMapper {
    DingDanDetails getDingDanDetailsById(@Param("id") Integer id);
}
