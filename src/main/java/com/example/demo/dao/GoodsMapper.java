package com.example.demo.dao;

import com.example.demo.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

@Mapper
public interface GoodsMapper {
    Goods getGoodsById(BigInteger id);
}
