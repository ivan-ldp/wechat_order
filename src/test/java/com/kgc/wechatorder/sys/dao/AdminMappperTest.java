package com.kgc.wechatorder.sys.dao;

import com.kgc.wechatorder.sys.pojo.Admin;
import com.kgc.wechatorder.tools.MD5Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created By Ivan_ldp@163.com on 2019/9/19 10:32
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminMappperTest {

    @Resource
    private AdminMappper adminMappper;

    @Test
    public void updateAdmin() {
        Admin admin=new Admin();
        admin.setAdminId(1001);
        admin.setAdminName("root");
        admin.setPhone("1383838338");
        String password="12306";
        String string2MD5 = MD5Utils.string2MD5(password);
        admin.setPassword(string2MD5);
        admin.setCreateTime(new Date());
        int updateAdmin = adminMappper.updateAdmin(admin);
        System.out.println(updateAdmin+"更新用户信息");
    }
    @Test
    public void checkAdminName() {
        int admin = adminMappper.checkAdminName("root");
        System.out.println(admin+"检查用户名是否存在");
    }
    @Test
    public void checkAdminPassword() {
        String password="12306";
        String string2MD5 = MD5Utils.string2MD5(password);
        System.out.println(string2MD5);
        int adminPassword = adminMappper.checkAdminPassword(string2MD5);
        System.out.println(adminPassword+"检查密码是否正确");
    }
    @Test
    public void login(){
        Admin admin = adminMappper.login("root", "12581");
        System.out.println("登陆成功，返回用户信息");
        System.out.println(admin.toString());
    }
}