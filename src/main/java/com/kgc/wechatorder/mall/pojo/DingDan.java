package com.kgc.wechatorder.mall.pojo;

import java.util.Date;

/**
 * 订单表
 */
public class DingDan {
    private int orderId;//主键
    private int userId;//关联用户主键
    private String orderNumber;//数量
    private Double totalPrices;//总价格
    private  int orderStatus;//订单状态（0:已取消  1：待付款 2：待送餐 3：待收货 4：已完成）
    private String beizhu;//备注
    private Date deliverTime;//发货时间
    private Date receiptTime;//收货时间
    private int cpId;//关联优惠券主键

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(Double totalPrices) {
        this.totalPrices = totalPrices;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getBeizhu() {
        return beizhu;
    }

    public void setBeizhu(String beizhu) {
        this.beizhu = beizhu;
    }

    public Date getDeliverTime() {
        return deliverTime;
    }

    public void setDeliverTime(Date deliverTime) {
        this.deliverTime = deliverTime;
    }

    public Date getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(Date receiptTime) {
        this.receiptTime = receiptTime;
    }

    public int getCpId() {
        return cpId;
    }

    public void setCpId(int cpId) {
        this.cpId = cpId;
    }

    @Override
    public String toString() {
        return "DingDan{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", orderNumber=" + orderNumber +
                ", totalPrices=" + totalPrices +
                ", orderStatus=" + orderStatus +
                ", beizhu='" + beizhu + '\'' +
                ", deliverTime=" + deliverTime +
                ", receiptTime=" + receiptTime +
                ", cpId=" + cpId +
                '}';
    }
}
