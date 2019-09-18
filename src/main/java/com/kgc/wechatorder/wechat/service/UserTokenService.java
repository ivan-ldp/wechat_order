package com.kgc.wechatorder.wechat.service;

import com.kgc.wechatorder.wechat.pojo.UserToken;

import java.util.Map;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 16:20
 */
public interface UserTokenService {
    UserToken queryByUserId(int userId);
    UserToken queryByToken(String token);
    int save(UserToken userToken);
    int update(UserToken userToken);
    Map<String, Object> createToken(int userId);
}
