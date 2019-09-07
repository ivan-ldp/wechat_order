package com.kgc.wechatorder.mall.pojo;

/**
 * 座位表
 */
public class Seat {
    private  int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                '}';
    }
}
