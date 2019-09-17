package com.kgc.wechatorder.mall.interceptor;

import com.kgc.wechatorder.mall.tools.Contants;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SysInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handle)throws Exception{
        HttpSession session=request.getSession();
        Object object=session.getAttribute(Contants.USER_SESSION);
        if(null==object){
            //说明没有权限，里面没有数值
            response.sendRedirect(request.getContextPath()+"");
            return  false;
        }
        return super.preHandle(request,response,handle);
    }

}
