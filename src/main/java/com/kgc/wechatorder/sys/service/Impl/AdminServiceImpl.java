package com.kgc.wechatorder.sys.service.Impl;

import com.kgc.wechatorder.sys.dao.AdminMappper;
import com.kgc.wechatorder.sys.pojo.Admin;
import com.kgc.wechatorder.sys.service.AdminService;
import com.kgc.wechatorder.tools.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 管理员 Service实现层
 * Created By Ivan_ldp@163.com on 2019/9/19 10:52
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMappper adminMappper;

    /**
     * 更新用户信息
     * @param admin
     * @return
     */
    @Override
    public int updateAdmin(Admin admin) {
        if (null==admin||admin.equals("")){
            return 0;
        }
        //对密码进行加密处理
        String password=admin.getPassword();
        System.out.println(password);
        password=MD5Utils.string2MD5(password);
        System.out.println("************");
        System.out.println(password);
        admin.setPassword(password);
        return adminMappper.updateAdmin(admin);
    }

    /**
     * 检查用户名
     * @param adminName
     * @return
     */
    @Override
    public int checkAdminName(String adminName) {
        if (null==adminName||adminName.equals("")){
            return 0;
        }
        return adminMappper.checkAdminName(adminName);
    }

    /**
     * 检查密码
     * @param password
     * @return
     */
    @Override
    public int checkAdminPassword(String password) {
        if (null==password||password.equals("")){
            return 0;
        }
        password= MD5Utils.string2MD5(password);
        return adminMappper.checkAdminPassword(password);
    }

    /**
     * 登陆验证
     * @param adminName
     * @param password
     * @return
     */
    @Override
    public Admin login(String adminName, String password) {
        if ((null==adminName||adminName.equals(""))&&(null==password||password.equals(""))){
            return null;
        }
        password=MD5Utils.string2MD5(password);
        return adminMappper.login(adminName,password);
    }
}
