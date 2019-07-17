package com.example.demo.dao;

import com.example.demo.dto.OrderGoodsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Zhu
 */
@Mapper
public interface OrderGoodsMapper {
    /**
     * 创建订单-商品信息
     * @param orderGoodsDTO
     */
    void createOrderGoods(OrderGoodsDTO orderGoodsDTO);

    /**
     * 通过id获取
     * @param orderId
     * @return
     */
    List<OrderGoodsDTO> getByOrderId(BigInteger orderId);
}
