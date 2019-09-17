package com.kgc.wechatorder.mall.service.impl;

import com.kgc.wechatorder.mall.dao.DingDanDeliveryMapper;
import com.kgc.wechatorder.mall.pojo.DingDanDelivery;
import com.kgc.wechatorder.mall.service.DingDanDeliveryService;

public class DingDanDeliveryImpl implements DingDanDeliveryService {
    private DingDanDeliveryService dingDanDeliveryService;
    @Override
    public boolean getDingDanDeliveryById(Integer id) {

        if(id==null||id.equals("")){
            try {
                if(id==null||id.equals(""));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("异常类型为空指针异常");
            }
        }
        return this.dingDanDeliveryService.getDingDanDeliveryById(id);
    }
}
