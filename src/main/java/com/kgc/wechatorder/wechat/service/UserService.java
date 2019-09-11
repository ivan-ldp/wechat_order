package com.kgc.wechatorder.wechat.service;

import com.kgc.wechatorder.wechat.pojo.User;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 9:55
 */
public interface UserService {
    User queryByOpenId(String openID);
    User queryByUserId(String userId);
}
