package com.kgc.wechatorder.mall.pojo;

/**
 * 订单详情表
 */
public class DingDanDetails {
    private int id;
    private int orderId;//关联订单表主键
    private int goodsId;//关联商品表主键
    private String goodsName;//商品名称
    private int number;//商品数量
    private String picPath;//图片路径
    private float prices;//总价格

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public float getPrices() {
        return prices;
    }

    public void setPrices(float prices) {
        this.prices = prices;
    }

    @Override
    public String toString() {
        return "DingDanDetails{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", number=" + number +
                ", picPath='" + picPath + '\'' +
                ", prices=" + prices +
                '}';
    }
}
