package com.kgc.wechatorder.wechat.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.alibaba.fastjson.JSONObject;
import com.kgc.wechatorder.wechat.pojo.User;
import com.kgc.wechatorder.wechat.pojo.UserToken;
import com.kgc.wechatorder.wechat.service.UserService;
import com.kgc.wechatorder.wechat.service.UserTokenService;
import com.kgc.wechatorder.wechat.utils.Configure;
import com.kgc.wechatorder.wechat.utils.HttpUtil;
import com.kgc.wechatorder.wechat.utils.JsonUtils;
import com.kgc.wechatorder.wechat.utils.WechatGetUserInfoUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class WeChatLogin {

    @Resource
    private UserTokenService userTokenService;
    @Resource
    private UserService userService;

    @GetMapping("/wxLogin")
    public Map<String, Object> mini_Login(HttpServletRequest request, @Param("code") String code, @Param("encryptedData") String encryptedData, @Param("iv") String iv) throws UnsupportedEncodingException {
        //String c=request.getParameter("code");//也可以通过此语句获取code值
        //System.out.println(code);
        System.out.println(code);
        System.out.println(encryptedData);
        System.out.println(iv);
        Map<String, Object> res = new HashMap<>();//这里是自定义类，用于封装返回的数据，你可以用map替代
        String result = "";
        try {//请求微信服务器，用code换取openid。HttpUtil是工具类，后面会给出实现，Configure类是小程序配置信息，后面会给出代码
            result = HttpUtil.doGet(
                    "https://api.weixin.qq.com/sns/jscode2session?appid="
                            + Configure.mini_appID + "&secret="
                            + Configure.mini_secret + "&js_code="
                            + code
                            + "&grant_type=" + Configure.grant_type, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(result);

        //JSONObject jsonObj = JSONObject.fromObject(result);//解析从微信服务器上获取到的json字符串
        Map<String, Object> jsonObj = JsonUtils.parseJSON2Map(result);
        System.out.println(jsonObj);
        System.out.println("用户的openid为：" + jsonObj.get("openid"));//此处也可以得到session_key的值
        String sessionKey = jsonObj.get("session_key").toString();
        res.put("session_key", sessionKey);
        //这里Miniuser类是自己的业务类，你可以根据自己需要自行定义
        //Miniuser miniuser=miniuserService.isRegister(jsonObj.get("openid").toString());
        // 去数据库判断用户是否存在该用户.
        User user = userService.queryByOpenId(jsonObj.get("openid").toString());

        if (user != null)//如果存在该用户
        {
            System.out.println("存在用户");
            //生成token
            Map<String, Object> map = userTokenService.createToken(user.getUserId());
            res.put("map", map);//将用户id返回
            res.put("openid", user.getOpenID());//将用户openid返回
            res.put("userInfo", user);
            return res;
        }
        //如果是新用户，就添加用户到数据库中
        System.out.println("不存在用户");
//        WxMaUserInfo userMsg = this.wxService.getUserService().getUserInfo(sessionKey, encryptedData, iv);

        JSONObject userMsg = WechatGetUserInfoUtil.getUserInfo(encryptedData, sessionKey, iv);
        System.out.println("*****************");
        System.out.println(userMsg);
        System.out.println(userMsg.get("nickName"));
        //"gender":1,"province":"Henan","city":"Zhoukou","avatarUrl":"
        System.out.println("**************8***");
        User userInfo = new User();//封装小程序对象
        //获取用户信息
        userInfo.setOpenID(jsonObj.get("openid").toString());
        userInfo.setNickName(userMsg.getString("nickName"));
        userInfo.setHeadImg(userMsg.getString("avatarUrl"));
        userInfo.setCreateTime(new Date());
        userInfo.setGender(userMsg.getString("gender"));
        userInfo.setLoginInfo(userMsg.toString());
        //将用户信息保存到数据库中
        userService.save(userInfo);
        //生成token
        Map<String, Object> map = userTokenService.createToken(userService.queryByOpenId(jsonObj.get("openid").toString()).getUserId());
        res.put("map", map);//将用户token返回
        res.put("openid", userService.queryByOpenId(jsonObj.get("openid").toString()).getOpenID());
        res.put("userInfo", userService.queryByOpenId(jsonObj.get("openid").toString()));
        return res;
    }

}
