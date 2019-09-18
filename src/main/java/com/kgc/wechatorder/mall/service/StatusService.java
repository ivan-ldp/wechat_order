package com.kgc.wechatorder.mall.service;

import com.kgc.wechatorder.mall.pojo.Status;

import java.util.List;

public interface StatusService {
    List<Status> getStatuslist(String typeCode);
}
