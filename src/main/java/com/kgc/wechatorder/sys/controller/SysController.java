package com.kgc.wechatorder.sys.controller;

import com.kgc.wechatorder.sys.pojo.Admin;
import com.kgc.wechatorder.sys.service.AdminService;
import org.apache.ibatis.annotations.Param;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 管理员登陆验证控制层
 * Created By Ivan_ldp@163.com on 2019/9/18 16:44
 */
@Controller
public class SysController {

    @Resource
    private AdminService adminService;
    @RequestMapping("tologin")
    public String toLogin(){
        return "login";
    }

    /**
     * 检查用户名
     * @param AdminName
     * @return
     */
    @ResponseBody
    @PostMapping("/checkAdminName")
    public int checkAdminName(@Param("AdminName") String AdminName){
        int i = adminService.checkAdminName(AdminName);
        return i;
    }

    /**
     * 登陆验证
     * @param adminName
     * @param password
     * @param session
     * @return
     */
    @PostMapping("/adminLogin")
    public String login(@Param("adminName") String adminName, @Param("password") String password, HttpSession session){
        Admin admin = adminService.login(adminName, password);
        if (null==admin){
            return "redirect:/tologin";//失败后重定向
        }
        session.setAttribute("admin",admin);
        return "design";
    }





    /**
     * 更新用户信息
     * @param admin
     * @return
     */
    @ResponseBody
    @PostMapping("/updateAdmin")
    public int updateAdmin(@RequestBody Admin admin){
        System.out.println(admin.toString());
        int i = adminService.updateAdmin(admin);
        return i;
    }


}
