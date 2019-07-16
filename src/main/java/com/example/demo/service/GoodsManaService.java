package com.example.demo.service;

import com.example.demo.dao.GoodsMapper;
import com.example.demo.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
/**
 * @author zyy
 */
@Service
public class GoodsManaService {
    @Autowired
    GoodsMapper goodsMapper;
    public void addGoods(Goods goods){
        goodsMapper.addGoods(goods);
    }

    public List<Goods> vagueSearch(String searchContent){
        return goodsMapper.vagueSearch(searchContent);
    }

    public void updateGoods(Goods goods){
        goodsMapper.updateGoods(goods);
    }

    public void deleteGoodsById(BigInteger id){
        goodsMapper.deleteGoodsById(id);
    }
}
