package com.kgc.wechatorder.mall.service.impl;

import com.kgc.wechatorder.mall.dao.DingDanBornMapper;
import com.kgc.wechatorder.mall.dao.DingDanDeliveryMapper;
import com.kgc.wechatorder.mall.dao.DingDanDetailsMapper;
import com.kgc.wechatorder.mall.dao.DingDanMapper;
import com.kgc.wechatorder.mall.pojo.DingDan;
import com.kgc.wechatorder.mall.pojo.DingDanDelivery;
import com.kgc.wechatorder.mall.pojo.DingDanDetails;
import com.kgc.wechatorder.mall.pojo.Goods;
import com.kgc.wechatorder.mall.service.DingDanBornService;
import com.kgc.wechatorder.mall.service.DingDanDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DingDanBornServiceImpl implements DingDanBornService {
    @Resource
    private DingDanBornMapper dingDanBornMapper;
    private DingDanDetailsMapper dingDanDetailsMapper;
    private DingDanDeliveryMapper dingDanDeliveryMapper;
    @Autowired
    private DingDanBornService dingDanBornService;
    private DingDanMapper dingDanMapper;

    @Override
    @Transactional
    //创建订单表
    public DingDan addDingDan(DingDan dingDan, List<DingDanDetails> dingDanDetails){
        if(dingDan==null||dingDan.equals("")){
            try {
                if(dingDan==null||dingDan.equals(""));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("异常类型为空指针异常");
            }
        }

        DingDan dingDan1 = this.dingDanBornMapper.addDingDan(dingDan);
        if(null!=dingDan) {
            for (DingDanDetails details : dingDanDetails) {
                details.setOrderId(dingDan.getOrderId());
                this.dingDanBornService.addDingDanDetails(details);
            }
        }
        return dingDan1;
    }

    @Override
    //创建订单配送表
    public DingDanDelivery addDingDanDelivery(DingDanDelivery dingDanDelivery) {
        if(dingDanDelivery==null||dingDanDelivery.equals("")){
            return null;
        }
        return this.dingDanBornMapper.addDingDanDelivery(dingDanDelivery);
    }

    @Override
    //创建订单详情表
    public DingDanDetails addDingDanDetails(DingDanDetails dingDanDetails) {
        if (dingDanDetails==null||dingDanDetails.equals("")){
            return null;
        }
        return this.dingDanBornMapper.addDingDanDetails(dingDanDetails);
    }

    @Override
    //凭id或name查询商品的*
    public Goods selectGoodsById(int id, String name) {
        String s = String.valueOf(id);
        if(s==null||s.equals("")){
            return null;
        }

        if(name==null||name.equals("")){
            return null;
        }
        Goods goods = this.selectGoodsById(id, name);
        return goods;
    }


//    public static void main(String[] args) {
//        try {
//            String str="junxi";
//            System.out.println(str+"年龄是");
//            int age=Integer.parseInt("30M");
//            System.out.println(age);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("program over");
//    }
//public static void main(String[] args) {
//    String s="abc";
//    if (s.equals("abc")){
//        throw new NumberFormatException("两者不可能相等的");
//    }else {
//        System.out.println(s);
//    }
//}
}
