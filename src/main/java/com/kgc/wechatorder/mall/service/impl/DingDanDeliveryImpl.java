package com.kgc.wechatorder.mall.service.impl;

import com.kgc.wechatorder.mall.dao.DingDanDeliveryMapper;
import com.kgc.wechatorder.mall.pojo.DingDanDelivery;
import com.kgc.wechatorder.mall.service.DingDanDeliveryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DingDanDeliveryImpl implements DingDanDeliveryService {
    @Resource
    private DingDanDeliveryMapper dingDanDeliveryMapper;
    @Override
    public DingDanDelivery getDingDanDeliveryById(Integer id) {

        if(id==null||id.equals("")){
            try {
                if(id==null||id.equals(""));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("异常类型为空指针异常");
            }
        }
        DingDanDelivery dingDanDeliveryById = this.dingDanDeliveryMapper.getDingDanDeliveryById(id);
        return dingDanDeliveryById;
    }
}
