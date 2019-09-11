package com.kgc.wechatorder.wechat.service;

import com.kgc.wechatorder.wechat.pojo.UserToken;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 16:20
 */
public interface UserTokenService {
    UserToken queryByUserId(String userId);
    UserToken queryByToken(String token);
    int save(UserToken userToken);
    int update(UserToken userToken);
}
