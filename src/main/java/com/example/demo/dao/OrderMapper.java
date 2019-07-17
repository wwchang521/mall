package com.example.demo.dao;

import com.example.demo.entity.Order;

import java.math.BigInteger;
import java.util.List;

/**
 * @author wwchang
 * @date 2019-07-12 14:51
 */
public interface OrderMapper {


    /**
     * 查找某个订单
     * @param id
     * @return
     */
    Order  getOrderById(BigInteger id);

    /**
     * 查找所有订单
     * @param
     * @return Order列表
     */
    List<Order> getAllOrder();

    /**
     * @param
     *
     */
    List<Order> getAllOrderByState(Integer state);

}
