package com.kgc.wechatorder.wechat.dao;

import cn.binarywang.wx.miniapp.api.WxMaService;
import com.kgc.wechatorder.wechat.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created By Ivan_ldp@163.com on 2019/9/11 9:21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {


    @Resource
    private UserMapper userMapper;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void queryByOpenId() {
        System.out.println(userMapper.queryByOpenId("1"));
    }

    @Test
    public void queryByUserId() {
    }

    @Test
    public void update() {
        User user=new User();
        user.setUserId(1);
        user.setOpenID("2");
        user.setLoginInfo("李东坡");
        user.setGender("男");
        user.setCreateTime(new Date());
        user.setHeadImg("撒浪嘿");
        user.setPhoneNumber("17369458423");
        user.setNickName("不吃豆芽儿");
        int update = userMapper.update(user);
        System.out.println(update);
    }

    @Test
    public void save(){
        User user=new User();
        user.setUserId(1);
        user.setOpenID("2");
        user.setLoginInfo("李东坡");
        user.setGender("男");
        user.setCreateTime(new Date());
        user.setHeadImg("撒浪嘿");
        user.setPhoneNumber("17369458423");
        user.setNickName("不吃豆芽儿");
        int save = userMapper.save(user);
        System.out.println(save);
    }
}