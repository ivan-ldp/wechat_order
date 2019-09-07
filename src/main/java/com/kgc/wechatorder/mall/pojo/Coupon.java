package com.kgc.wechatorder.mall.pojo;

/**
 * 优惠券表
 */
public class Coupon {
    private int cpId;//主键
    private int userId;//关联用户主键
    private  int cpCategoryId;//关联优惠券种类主键
    private  int cpNum;//优惠券数量
    private int status;//0代表已过期 ，1代表未使用，2代表已使用

    public int getCpId() {
        return cpId;
    }

    public void setCpId(int cpId) {
        this.cpId = cpId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCpCategoryId() {
        return cpCategoryId;
    }

    public void setCpCategoryId(int cpCategoryId) {
        this.cpCategoryId = cpCategoryId;
    }

    public int getCpNum() {
        return cpNum;
    }

    public void setCpNum(int cpNum) {
        this.cpNum = cpNum;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "cpId=" + cpId +
                ", userId=" + userId +
                ", cpCategoryId=" + cpCategoryId +
                ", cpNum=" + cpNum +
                ", status=" + status +
                '}';
    }
}
