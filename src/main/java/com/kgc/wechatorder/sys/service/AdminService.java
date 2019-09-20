package com.kgc.wechatorder.sys.service;

import com.kgc.wechatorder.sys.pojo.Admin;
import org.apache.ibatis.annotations.Param;

/**
 * 管理员 Service
 * Created By Ivan_ldp@163.com on 2019/9/19 10:50
 */
public interface AdminService {
    /**
     * 修改管理员账户
     * @param admin
     * @return
     */
    int updateAdmin(Admin admin);

    /**
     * 检查用户名
     * @param adminName
     * @return
     */
    int checkAdminName(String adminName);

    /**
     * 检查用户密码
     * @param password
     * @return
     */
    int checkAdminPassword(String password);

    /**
     * 用户登陆
     * @param adminName
     * @param password
     * @return
     */
    Admin login(@Param("adminName") String adminName, @Param("password") String password);
}
