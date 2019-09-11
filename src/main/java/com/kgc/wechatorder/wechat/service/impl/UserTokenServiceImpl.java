package com.kgc.wechatorder.wechat.service.impl;

import com.kgc.wechatorder.wechat.dao.UserTokenMapper;
import com.kgc.wechatorder.wechat.pojo.UserToken;
import com.kgc.wechatorder.wechat.service.UserTokenService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 16:20
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {


    @Resource
    private UserTokenMapper userTokenMapper;
    @Override
    public UserToken queryByUserId(String userId) {
        return userTokenMapper.queryByUserId(userId);
    }

    @Override
    public UserToken queryByToken(String token) {
        return userTokenMapper.queryByToken(token);
    }

    @Override
    public int save(UserToken userToken) {
        System.out.println(userToken.toString());
        return userTokenMapper.save(userToken);
    }

    @Override
    public int update(UserToken userToken) {
        return userTokenMapper.update(userToken);
    }
}
