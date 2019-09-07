package com.kgc.wechatorder.mall.pojo;

/**
 * 轮播图表
 */
public class LunBo {
    private int id;//主键
    private String picPath;//图片路径

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    @Override
    public String toString() {
        return "LunBo{" +
                "id=" + id +
                ", picPath='" + picPath + '\'' +
                '}';
    }
}
