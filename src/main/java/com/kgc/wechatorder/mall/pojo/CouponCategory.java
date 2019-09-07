package com.kgc.wechatorder.mall.pojo;

import java.util.Date;

/**
 * 优惠券种类表
 */
public class CouponCategory {
    private int cpCategoryId;//主键
    private String cpContent;//优惠券内容
    private Date cpBeginTime;//开始时间
    private Date cpEndTime;//结束时间

    public int getCpCategoryId() {
        return cpCategoryId;
    }

    public void setCpCategoryId(int cpCategoryId) {
        this.cpCategoryId = cpCategoryId;
    }

    public String getCpContent() {
        return cpContent;
    }

    public void setCpContent(String cpContent) {
        this.cpContent = cpContent;
    }

    public Date getCpBeginTime() {
        return cpBeginTime;
    }

    public void setCpBeginTime(Date cpBeginTime) {
        this.cpBeginTime = cpBeginTime;
    }

    public Date getCpEndTime() {
        return cpEndTime;
    }

    public void setCpEndTime(Date cpEndTime) {
        this.cpEndTime = cpEndTime;
    }

    @Override
    public String toString() {
        return "CouponCategory{" +
                "cpCategoryId=" + cpCategoryId +
                ", cpContent='" + cpContent + '\'' +
                ", cpBeginTime=" + cpBeginTime +
                ", cpEndTime=" + cpEndTime +
                '}';
    }
}
