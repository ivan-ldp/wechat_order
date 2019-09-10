package com.kgc.wechatorder.mall.dao;

import com.kgc.wechatorder.mall.pojo.Goods;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsMapperTest {
    @Resource
    private GoodsMapper goodsMapper;

    @Test
    public void findGoodsListById1() {
        List<Goods>list=goodsMapper.findGoodsListById1(1);
        for(Goods goods:list){
            System.out.println(goods);
        }

    }

    @Test
    public void findGoodsListById2() {
        List<Goods>list=goodsMapper.findGoodsListById2("百",1,65,0,2);
        for(Goods goods:list){
            System.out.println(goods);
        }
    }

    @Test
    public void getGoodsById() {
        Goods goods=goodsMapper.getGoodsById(1);
        System.out.println(goods);
    }

    @Test
    public void updateRemaining() {
        int count=goodsMapper.updateRemaining(1,2);
        System.out.println(count);
    }

    @Test
    public void add() throws ParseException {
        Goods goods=new Goods();
        goods.setGoodsId(6);
        goods.setCategoryId(2);
        goods.setGoodsName("冰红茶");
        goods.setPicUrl("D:url");
        goods.setDescription("好喝");
        goods.setRemains(12);
        goods.setXiaoLiang(12);
        goods.setStatus(1);
        goods.setPrice(12);
        goods.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-09-02 09:04:27"));
        goods.setUpdateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-09-02 09:04:27"));
        int count=goodsMapper.add(goods);
        System.out.println("++++++++++++++++++++++++"+count);
    }

    @Test
    public void modify() {
        Goods goods=new Goods();
        goods.setGoodsId(5);
        goods.setGoodsName("米饭");
        int count=goodsMapper.modify(goods);
    }

    @Test
    public void deleteGoodsById() {
    }

    @Test
    public void getGoodsCount() {
        int count=goodsMapper.getGoodsCount("百");
        System.out.println("++++++++++++++++++++++++"+count);
    }
}