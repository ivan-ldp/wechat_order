package com.kgc.wechatorder.mall.pojo;

/**
 * 订单配送表
 */
public class DingDanDelivery {
    private int id;//主键
    private int orderId;//关联订单表主键
    private String contact;//联系人
    private int provinceId;//省编码
    private String provinceName;//省名称
    private  int cityId;//市编码
    private String cityName;//市名称
    private int districtId;//区编码
    private String districtName;//区名称
    private String address;//地址

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DingDanDelivery{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", contact='" + contact + '\'' +
                ", provinceId=" + provinceId +
                ", provinceName='" + provinceName + '\'' +
                ", cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", districtId=" + districtId +
                ", districtName='" + districtName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
