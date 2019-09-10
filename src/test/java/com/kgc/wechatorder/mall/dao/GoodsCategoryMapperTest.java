package com.kgc.wechatorder.mall.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created By Ivan_ldp@163.com on 2019/9/10 11:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsCategoryMapperTest {

    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;
    @Test
    public void findAllGoodsCategory() {
        System.out.println(goodsCategoryMapper.findAllGoodsCategory());
    }
}