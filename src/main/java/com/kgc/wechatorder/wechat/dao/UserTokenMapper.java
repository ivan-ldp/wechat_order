package com.kgc.wechatorder.wechat.dao;

import com.kgc.wechatorder.wechat.pojo.UserToken;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 16:15
 */
@Mapper
public interface UserTokenMapper {
    UserToken queryByUserId(Integer userId);
    UserToken queryByToken(String token);
    int save(UserToken userToken);
    int update(UserToken userToken);


}
