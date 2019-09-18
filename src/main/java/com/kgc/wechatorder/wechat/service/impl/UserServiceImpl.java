package com.kgc.wechatorder.wechat.service.impl;

import com.kgc.wechatorder.wechat.dao.UserMapper;
import com.kgc.wechatorder.wechat.pojo.User;
import com.kgc.wechatorder.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户Service实现层
 * Created By Ivan_ldp@163.com on 2019/9/10 9:55
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 按openID查询用户信息
     * @param openID
     * @return
     */
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

    /**
     * 按userId查询用户信息
     * @param userId
     * @return
     */
    @Override
    public User queryByUserId(String userId) {
        return userMapper.queryByUserId(userId);
    }

    /**
     * 添加用户信息
     * @param user
     * @return
     */
    @Override
    public int save(User user) {
        return userMapper.save(user);
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Override
    public int update(User user) {
        return userMapper.update(user);
    }
}
