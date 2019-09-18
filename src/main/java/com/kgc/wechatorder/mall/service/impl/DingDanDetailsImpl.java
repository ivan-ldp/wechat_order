package com.kgc.wechatorder.mall.service.impl;

import com.kgc.wechatorder.mall.dao.DingDanDetailsMapper;
import com.kgc.wechatorder.mall.pojo.DingDanDetails;
import com.kgc.wechatorder.mall.service.DingDanDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DingDanDetailsImpl implements DingDanDetailsService {
    @Resource
    private DingDanDetailsMapper dingDanDetailsMapper;
    @Override
    public DingDanDetails getDingDanDetailsById(Integer id) {
        if(id==null||id.equals("")){
            try {
                if(id==null||id.equals(""));
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println("异常类型为空指针异常");
            }
        }
        return this.dingDanDetailsMapper.getDingDanDetailsById(id);
    }
}
