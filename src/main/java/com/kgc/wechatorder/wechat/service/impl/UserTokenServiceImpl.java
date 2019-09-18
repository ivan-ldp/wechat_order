package com.kgc.wechatorder.wechat.service.impl;

import com.kgc.wechatorder.wechat.dao.UserTokenMapper;
import com.kgc.wechatorder.wechat.pojo.UserToken;
import com.kgc.wechatorder.wechat.service.UserTokenService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 16:20
 */
@Service
public class UserTokenServiceImpl implements UserTokenService {


    //12小时后过期
    private final static int EXPIRE = 3600 * 12;

    @Resource
    private UserTokenMapper userTokenMapper;

    @Override
    public UserToken queryByUserId(int userId) {
        return userTokenMapper.queryByUserId(userId);
    }

    @Override
    public UserToken queryByToken(String token) {
        return userTokenMapper.queryByToken(token);
    }

    @Override
    public int save(UserToken userToken) {


        return userTokenMapper.save(userToken);
    }

    @Override
    public int update(UserToken userToken) {
        return userTokenMapper.update(userToken);
    }

    /**
     * 生成token
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> createToken(int userId) {
        //生成一个token
        String token = UUID.randomUUID().toString();
        //当前时间
        Date now = new Date();

        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        //判断是否生成过token
        //方法调用不合适    等下在更改
        // userTokenMapper.queryByToken(token)
        UserToken userToken =userTokenMapper.queryByUserId(userId);
        if (null==userToken){
            userToken=new UserToken();
            userToken.setUserId(userId);
            userToken.setToken(token);
            userToken.setUpdateTime(now);
            userToken.setExpireTime(expireTime);
            //保存token
            userTokenMapper.save(userToken);
        }else {
            userToken.setUserId(userId);
            userToken.setToken(token);
            userToken.setUpdateTime(now);
            userToken.setExpireTime(expireTime);

            //更新token
            userTokenMapper.update(userToken);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("expire", EXPIRE);

        return map;
    }


}
