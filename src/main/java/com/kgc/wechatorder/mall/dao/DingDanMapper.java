package com.kgc.wechatorder.mall.dao;

import com.kgc.wechatorder.mall.pojo.DingDan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户数据持久化接口
 */
@Mapper
public interface DingDanMapper {
    DingDan getDingDanById(@Param("orderid") Integer orderid);
}
