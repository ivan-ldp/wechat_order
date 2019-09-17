package com.kgc.wechatorder.mall.dao;

import com.kgc.wechatorder.mall.pojo.Status;
import com.kgc.wechatorder.mall.service.StatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
@SpringBootTest
@RunWith(SpringRunner.class)
public class StatusMapperTest {
    @Resource
    private StatusMapper statusMapper;
    @Resource
    private StatusService statusService;
    @Test
    public void getStatusList(){
        List<Status>list=statusService.getStatuslist("Goods_Status");
        for(Status st:list){
            System.out.println(st);
        }
    }
}
