package com.kgc.wechatorder.wechat.service;

import com.kgc.wechatorder.wechat.pojo.User;

/**
 * 用户Service
 * Created By Ivan_ldp@163.com on 2019/9/10 9:55
 */
public interface UserService {
    /**
     * 按openID保存用户信息
     * @param openID
     * @return
     */
    User queryByOpenId(String openID);

    /**
     * 按userId保存用户信息
     * @param userId
     * @return
     */
    User queryByUserId(String userId);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int save(User user);

    /**
     *
     * 更新用户信息
     * @param user
     * @return
     */
    int update(User user);
}
