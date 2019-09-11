package com.kgc.wechatorder.mall.controller;

import com.kgc.wechatorder.mall.dao.DingDanBornMapper;
import com.kgc.wechatorder.mall.service.DingDanBornService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 控制订单的数据跳转
 */
@Controller
public class DingDanController {
    @Autowired
    private DingDanBornService dingDanBornService;


}
