package com.kgc.wechatorder.wechat.dao;

import com.kgc.wechatorder.wechat.pojo.UserToken;
import com.kgc.wechatorder.wechat.service.impl.UserTokenServiceImplTest;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created By Ivan_ldp@163.com on 2019/9/11 11:46
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTokenMapperTest {
    Logger log = Logger.getLogger(UserTokenMapperTest.class);
    @Resource
    private UserTokenMapper userTokenMapper;
    UserToken userToken = new UserToken();
    Date date = null;

    @Before
    public void setUp() throws Exception {
        log = Logger.getLogger(UserTokenServiceImplTest.class);
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

        userToken.setUpdateTime(date);

        userToken.setExpireTime(date);
        log.info(userTokenMapper.save(userToken));
    }

    @Test
    public void update() {
    }
}