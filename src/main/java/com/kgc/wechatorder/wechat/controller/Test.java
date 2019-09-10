package com.kgc.wechatorder.wechat.controller;

import com.kgc.wechatorder.wechat.pojo.User;
import com.kgc.wechatorder.wechat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 10:35
 */
@RestController
public class Test {
    @Autowired
    private UserService userService;
    @RequestMapping("hello")
    public User test(){
        return userService.info();
    }
}
