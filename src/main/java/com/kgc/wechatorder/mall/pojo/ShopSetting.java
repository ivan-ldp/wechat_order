package com.kgc.wechatorder.mall.pojo;

/**
 * 商城设置
 */
public class ShopSetting {
    private  int id;
    private String mallName;//商铺名称
    private String mallLogo;//商铺Logo
    private String phone;//商铺电话
    private String detailInfo;//详细信息

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public String getMallLogo() {
        return mallLogo;
    }

    public void setMallLogo(String mallLogo) {
        this.mallLogo = mallLogo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    @Override
    public String toString() {
        return "ShopSetting{" +
                "id=" + id +
                ", mallName='" + mallName + '\'' +
                ", mallLogo='" + mallLogo + '\'' +
                ", phone='" + phone + '\'' +
                ", detailInfo='" + detailInfo + '\'' +
                '}';
    }
}
