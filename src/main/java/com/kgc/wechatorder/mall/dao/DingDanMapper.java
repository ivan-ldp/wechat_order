package com.kgc.wechatorder.mall.dao;

import com.kgc.wechatorder.mall.pojo.DingDan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户数据持久化接口
 */
@Mapper
public interface DingDanMapper {
    //凭id或者订单状态获取值
    DingDan getDingDanById(@Param("orderid") Integer orderid,
                           @Param("orderStatus")Integer orderStatus);
    //查询全部订单
    DingDan selectDingDan();

    //对订单进行修改
    DingDan updateDingDan(@Param("orderid") Integer orderid);

}
