package com.kgc.wechatorder.mall.service.impl;

import com.kgc.wechatorder.mall.dao.StatusMapper;
import com.kgc.wechatorder.mall.pojo.Status;
import com.kgc.wechatorder.mall.service.StatusService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StatusServiceImpl implements StatusService {
    @Resource
    private StatusMapper statusMapper;
    @Override
    public List<Status> getStatuslist(String typeCode) {
        return statusMapper.getStatuslist(typeCode);
    }
}
