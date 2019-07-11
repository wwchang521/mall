package com.example.demo.dao;

import com.example.demo.dto.CustomerGoodsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface CustomerGoodsMapper {
    void addToCart(CustomerGoodsDTO customerGoodsDTO);

    void updateGoodsNumber(CustomerGoodsDTO customerGoodsDTO);

    void deleteGoods(CustomerGoodsDTO customerGoodsDTO);

    List<CustomerGoodsDTO>getByCustomerId(BigInteger id);
}
