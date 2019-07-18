package com.example.demo.dao;

import com.example.demo.dto.CustomerGoodsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;
/**
 * @author zyy
 */
@Mapper
public interface CustomerGoodsMapper {
    /**
     * 添加商品到购物车
     * @param customerGoodsDTO 商品、顾客相关信息
     */
    void addToCart(CustomerGoodsDTO customerGoodsDTO);

    /**
     * 修改商品数量
     * @param customerGoodsDTO 商品、顾客相关信息
     */
    void updateGoodsNumber(CustomerGoodsDTO customerGoodsDTO);

    /**
     * 删除购物车中的商品
     * @param customerGoodsDTO
     */
    void deleteGoods(CustomerGoodsDTO customerGoodsDTO);

    /**
     * 根据客户id获取购物车中所有商品
     * @param id
     * @return
     */
    List<CustomerGoodsDTO>getByCustomerId(BigInteger id);

    /**
     * 根据客户id和商品id获取购物车中的商品
     * @param
     * @return
     */
    CustomerGoodsDTO getByCustomerIdAndGoodsId(CustomerGoodsDTO customerGoodsDTO);
}
