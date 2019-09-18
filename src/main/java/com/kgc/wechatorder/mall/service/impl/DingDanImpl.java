package com.kgc.wechatorder.mall.service.impl;

import com.kgc.wechatorder.mall.dao.DingDanMapper;
import com.kgc.wechatorder.mall.pojo.DingDan;
import com.kgc.wechatorder.mall.service.DingDanService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DingDanImpl implements DingDanService {
    @Resource
    private DingDanMapper dingDanMapper;
    @Override
    public DingDan getDingDanById(Integer orderid,Integer orderStatus) {
//        if(orderid==null||orderid.equals("")){
//            try {
//                if(orderid==null||orderid.equals(""));
//            }catch (Exception e){
//                e.printStackTrace();
//            }finally {
//                System.out.println("异常类型为空指针异常");
//            }
//        }
            if (orderid==null||orderid.equals("")){
                return null;
            }
            if (orderStatus==null||orderStatus.equals("")){
                return null;
            }
        return this.dingDanMapper.getDingDanById(orderid,orderStatus);
    }



    @Override
    public DingDan selectDingDan() {
        return this.dingDanMapper.selectDingDan();
    }



    @Override
    public DingDan updateDingDan(Integer orderid) {
        if (orderid==null||orderid.equals("")){
            return null;
        }
        return this.dingDanMapper.updateDingDan(orderid);
    }
}
