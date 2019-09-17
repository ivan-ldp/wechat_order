package com.kgc.wechatorder.wechat.service.impl;

import com.kgc.wechatorder.wechat.pojo.UserToken;
import com.kgc.wechatorder.wechat.service.UserTokenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTokenServiceImplTest {

    @Resource
    private UserTokenService userTokenService;
    @Test
    public void queryByUserId() {
    }

    @Test
    public void queryByToken() {
    }

    @Test
    public void save() {
        UserToken userToken=new UserToken();
        userToken.setUserId(1);
        userToken.setToken("clw");
        userToken.setUpdateTime(new Date());
        userToken.setExpireTime(new Date());
        int save = userTokenService.save(userToken);
        System.out.println(save);
    }

    @Test
    public void update() {
    }
}