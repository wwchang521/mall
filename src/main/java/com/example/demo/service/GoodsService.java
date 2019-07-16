package com.example.demo.service;

import com.example.demo.dao.GoodsMapper;
import com.example.demo.entity.Goods;
import com.example.demo.vo.BrowseGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
/**
 * @author zyy
 */
@Service
public class GoodsService {
    @Autowired
    GoodsMapper goodsMapper;

    public List<Goods>getAllGoods(){return goodsMapper.getAllGoods();}

    public Goods getGoodsById(BigInteger id){return goodsMapper.getGoodsById(id);}
}
