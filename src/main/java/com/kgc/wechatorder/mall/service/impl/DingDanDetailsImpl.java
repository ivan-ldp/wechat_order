package com.kgc.wechatorder.mall.service.impl;

import com.kgc.wechatorder.mall.service.DingDanDetailsService;

public class DingDanDetailsImpl implements DingDanDetailsService {
    private DingDanDetailsService dingDanDetailsService;
    @Override
    public boolean getDingDanDetailsById(Integer id) {
        if(id==null||id.equals("")){
            try {
                if(id==null||id.equals(""));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("异常类型为空指针异常");
            }
        }
        return this.dingDanDetailsService.getDingDanDetailsById(id);
    }
}
