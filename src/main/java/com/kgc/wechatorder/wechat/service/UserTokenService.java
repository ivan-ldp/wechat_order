package com.kgc.wechatorder.wechat.service;

import com.kgc.wechatorder.wechat.pojo.UserToken;

import java.util.Map;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 16:20
 */
public interface UserTokenService {
    /**
     * 按userId查询UserToken
     * @param userId
     * @return
     */
    UserToken queryByUserId(int userId);

    /**
     * 按token查询UserToken
     * @param token
     * @return
     */
    UserToken queryByToken(String token);

    /**
     * 保存UserToken
     * @param userToken
     * @return
     */
    int save(UserToken userToken);

    /**
     * 更新token
     * @param userToken
     * @return
     */
    int update(UserToken userToken);

    /**
     * 生成token
     * @param userId
     * @return
     */
    Map<String, Object> createToken(int userId);
}
