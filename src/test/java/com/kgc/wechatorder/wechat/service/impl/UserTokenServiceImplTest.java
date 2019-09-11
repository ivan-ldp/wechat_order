package com.kgc.wechatorder.wechat.service.impl;

import com.kgc.wechatorder.wechat.dao.UserTokenMapper;
import com.kgc.wechatorder.wechat.pojo.UserToken;
import com.kgc.wechatorder.wechat.service.UserTokenService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created By Ivan_ldp@163.com on 2019/9/11 9:47
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTokenServiceImplTest {
Logger log=null;
    @Resource
    private UserTokenService userTokenService;
    UserToken userToken=new UserToken();
    Date date=null;
    @Before
    public void setUp() throws Exception {
        log=Logger.getLogger(UserTokenServiceImplTest.class);
    }

    @Test
    public void queryByUserId() {
    }

    @Test
    public void queryByToken() {
    }

    @Test
    public void save() {
        userToken.setUserId(1);
        userToken.setToken("ldp");
        date=new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        userToken.setUpdateTime(date);
        cal.add(Calendar.HOUR,2);
        userToken.setExpireTime(date);
        log.info(userTokenService.save(userToken));
    }

    @Test
    public void update() {
        userToken.setUserId(1);
        userToken.setToken("ldp");
        date=new Date();

        userToken.setUpdateTime(date);

        userToken.setExpireTime(date);
        log.info(userTokenService.update(userToken));
    }
}