package com.kgc.wechatorder.wechat.service.impl;

import com.kgc.wechatorder.wechat.dao.UserMapper;
import com.kgc.wechatorder.wechat.pojo.User;
import com.kgc.wechatorder.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 9:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User queryByOpenId(String openID) {
        if (null==openID||openID==""){
            return null;
        }
        User user = userMapper.queryByOpenId(openID);
        if (null==user){
            return null;
        }
        return user;
    }

    @Override
    public User queryByUserId(String userId) {
        return userMapper.queryByUserId(userId);
    }
}
