package com.kgc.wechatorder.mall.pojo;

import java.util.Date;

/**
 * 微信设置
 */
public class WechatSetting {
    private  int id;//主键
    private String AppID;
    private String secret;//密钥
    private String mchKey;//商户密钥
    private String mchId;//商户号
    private Date createTime;//创建时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppID() {
        return AppID;
    }

    public void setAppID(String appID) {
        AppID = appID;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getMchKey() {
        return mchKey;
    }

    public void setMchKey(String mchKey) {
        this.mchKey = mchKey;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "WechatSetting{" +
                "id=" + id +
                ", AppID='" + AppID + '\'' +
                ", secret='" + secret + '\'' +
                ", mchKey='" + mchKey + '\'' +
                ", mchId='" + mchId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
