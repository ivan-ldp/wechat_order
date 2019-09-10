package com.kgc.wechatorder.wechat.service.impl;

import com.kgc.wechatorder.wechat.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 10:18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceImplTest {

    @Resource
    private UserService userService;
    @Test
    public void info() {
        System.out.println(userService.info().toString());
    }
}