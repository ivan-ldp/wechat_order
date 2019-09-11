package com.kgc.wechatorder.wechat.pojo;

import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * 用户表
 */
@Alias("User")
public class User {
    private  int userId;//主键
    private String openID;
    private String loginInfo;//登陆信息
    private String gender;//性别
    private Date createTime;//创建时间
    private String headImg;//头像
    private String nickName;//昵称

    private String phoneNumber;//电话

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOpenID() {
        return openID;
    }

    public void setOpenID(String openID) {
        this.openID = openID;
    }

    public String getLoginInfo() {
        return loginInfo;
    }

    public void setLoginInfo(String loginInfo) {
        this.loginInfo = loginInfo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", openID='" + openID + '\'' +
                ", loginInfo='" + loginInfo + '\'' +
                ", gender='" + gender + '\'' +
                ", createTime=" + createTime +
                ", headImg='" + headImg + '\'' +
                ", nickName='" + nickName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
