package com.kgc.wechatorder.wechat.pojo;

import java.util.Date;

/**
 * 用户Token表
 */
public class UserToken {
    private  int id;
    private int userId;//关联用户主键
    private String token;//令牌
    private Date expireTime;//过期时间
    private Date updateTime;//更新时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "id=" + id +
                ", userId=" + userId +
                ", token='" + token + '\'' +
                ", expireTime=" + expireTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
