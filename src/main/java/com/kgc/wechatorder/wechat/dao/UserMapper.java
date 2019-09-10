package com.kgc.wechatorder.wechat.dao;


import com.kgc.wechatorder.wechat.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 9:06
 */
@Mapper
public interface UserMapper {
    User info();
}
