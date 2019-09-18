package com.kgc.wechatorder.mall.dao;

import com.kgc.wechatorder.mall.pojo.Status;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface StatusMapper {
    List<Status>getStatuslist(String typeCode);
}
