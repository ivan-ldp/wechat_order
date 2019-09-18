package com.kgc.wechatorder.mall.controller;

import com.kgc.wechatorder.mall.dao.DingDanBornMapper;
import com.kgc.wechatorder.mall.pojo.DingDan;
import com.kgc.wechatorder.mall.pojo.DingDanDelivery;
import com.kgc.wechatorder.mall.pojo.DingDanDetails;
import com.kgc.wechatorder.mall.pojo.Goods;
import com.kgc.wechatorder.mall.service.DingDanBornService;
import com.kgc.wechatorder.mall.service.DingDanDeliveryService;
import com.kgc.wechatorder.mall.service.DingDanDetailsService;
import com.kgc.wechatorder.mall.service.DingDanService;
import com.kgc.wechatorder.mall.tools.utils;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 控制订单的数据跳转
 */
@RestController
public class DingDanController {
    private Logger logger=Logger.getLogger(DingDanController.class);
    @Autowired
    private DingDanBornService dingDanBornService;
    private DingDanDetailsService dingDanDetailsService;
    private DingDanDeliveryService dingDanDeliveryService;
    private DingDanService dingDanService;
    private Object utils;

    @RequestMapping(value = "/addBornDingDan",method = RequestMethod.POST)
    /*生成订单页*/
    public DingDan addBornDingDan(@RequestParam("array1[]") List<Integer> numbers,
                                  @RequestParam("array2[]") List<String> goodsNames,
                                  @RequestParam("array3[]") List<Integer> goodsIds,
                                  @RequestParam String commnet){
        logger.info("订单生成，配合订单详情页生成");

        //订单号生成中
        DingDan dingDan3=new DingDan();
        Class<com.kgc.wechatorder.mall.tools.utils.addOrderNumber> addOrderNumberClass = com.kgc.wechatorder.mall.tools.utils.addOrderNumber.class;
        dingDan3.setOrderNumber(String.valueOf(addOrderNumberClass));


        //订单状态,如果订单尚未支付，咱设置其订单状态为1
        dingDan3.setOrderStatus(1);

        //订单生成时间  dingDan3.setDeliverTime(new Date());
        Date date = new Date();
        DateFormat dfs=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime1 = dfs.format(date);
        java.sql.Date date3 = java.sql.Date.valueOf(nowTime1);
        dingDan3.setDeliverTime(date3);


        //订单配送的截至时间,配送时间最晚推迟半个小时
        long l = System.currentTimeMillis() + 30 * 60 * 1000;
        Date date2=new Date(1);
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime="";
        nowTime=df.format(date2);
        java.sql.Date date1 = java.sql.Date.valueOf(nowTime);
        dingDan3.setReceiptTime(date1);

        //计算总价格，并且生成订单详情页

            double sum = 0;
           List<DingDanDetails> dingDanDetails=new ArrayList<>();

            for (int i = 0; i < goodsIds.size(); i++) {
              //开始生成订单详情表,此时随着循环的开始，订单详情表也逐渐生成
                Goods goods = dingDanBornService.selectGoodsById(goodsIds.get(i), null);
                DingDanDetails details=new DingDanDetails();
                details.setPrices(goods.getPrice());
                details.setPicPath(goods.getPicUrl());
                details.setNumber(numbers.get(i));
                details.setGoodsId(goods.getGoodsId());
                details.setGoodsName(goods.getGoodsName());
                dingDanDetails.add(details);
                sum+=numbers.get(i)*goods.getPrice();
            }
            dingDan3.setTotalPrices(sum);

            //生成备注
            dingDan3.setBeizhu(commnet);

            //这一步最终订单生成
            DingDan dingDan = dingDanBornService.addDingDan(dingDan3,dingDanDetails);


            if (dingDan == null) {
                return null;
            }
            return dingDan;
        }



    @RequestMapping(value = "/DingDan" ,method = RequestMethod.POST)
    /*这个页面属于支付前的展示页面,之后则是支付*/
    public DingDan showDingDan(){
        boolean flag=true;
       // 这个里面会产生一个userid或者global，以此获取相关数据
        DingDan dingDan=new DingDan();
        int orderId = dingDan.getOrderId();
        DingDan dingDanById = dingDanService.getDingDanById(orderId,null);
        if (dingDanById==null){
            return null;
        }
        return dingDanById;
    }



    @RequestMapping(value = "/fenyeDingDan",method = RequestMethod.POST)
    public String showfenyeDingDan(@RequestParam("orderStatus")Integer orderStatus) {
        /*这个页面输入分页查询订单*/
        switch (orderStatus) {
            case 1:
                //订单：未付款
              return "forward:/fenye1";
            case 2:
                //订单：已付款
                return  "forward:/fenye2";

            case 3:
                //订单：配送中
                return "forward:/fenye3";

            case 4:
                //订单：已完成
                return "forward:/fenye4";

        }
        return null;
    }



    @RequestMapping(value = "fenye1" ,method = RequestMethod.POST)
    //订单未付款
    public DingDan showFenYe3(@RequestParam("orderStatus")Integer orderStatus){
        DingDan dingDanById = dingDanService.getDingDanById(null,orderStatus);
        return dingDanById;
    }

    @RequestMapping(value = "fenye2" ,method = RequestMethod.POST)
    //订单已付款
    public DingDan showFenYe2(@RequestParam("orderStatus")Integer orderStatus){
        DingDan dingDanById = dingDanService.getDingDanById(null,orderStatus);
        return dingDanById;
    }

    @RequestMapping(value = "fenye3" ,method = RequestMethod.POST)
    //订单配送中
    public DingDan showFenYe4(@RequestParam("orderStatus")Integer orderStatus){
        DingDan dingDanById = dingDanService.getDingDanById(null,orderStatus);
        return dingDanById;
    }

    @RequestMapping(value = "fenye4" ,method = RequestMethod.POST)
    //订单已完成
    public DingDan showFenYe1(@RequestParam("orderStatus")Integer orderStatus){
        DingDan dingDanById = dingDanService.getDingDanById(null,orderStatus);
        return dingDanById;
    }


    @RequestMapping(value ="DingDinManager",method =RequestMethod.POST )
    //订单管理页面
    public DingDanDelivery dingDanDelivery(@RequestParam Integer id){
        DingDan dingDan = dingDanService.selectDingDan();
        DingDanDetails dingDanDetailsById = dingDanDetailsService.getDingDanDetailsById(id);
        DingDan dingDan1 = dingDanService.updateDingDan(id);
        return null;
    }

}

