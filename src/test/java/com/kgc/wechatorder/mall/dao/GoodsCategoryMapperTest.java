package com.kgc.wechatorder.mall.dao;

import com.alibaba.druid.sql.dialect.sqlserver.ast.SQLServerOutput;
import com.kgc.wechatorder.mall.pojo.GoodsCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsCategoryMapperTest {
    @Resource
private  GoodsCategoryMapper goodsCategoryMapper;
    @Test
    public void findAllGoodsCategory() {
        List<GoodsCategory>list=goodsCategoryMapper.findAllGoodsCategory();
        for (GoodsCategory gc:list){
            System.out.println(gc);
        }
    }
}