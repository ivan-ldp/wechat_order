package com.kgc.wechatorder.wechat.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 9:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;
    @Test
    public void save() {
    }

    @Test
    public void count() {
        System.out.println(userMapper.info().toString());
    }
}