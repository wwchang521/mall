package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * @author wwchang
 * @date 2019-07-12 14:51
 */
@Mapper
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
     * 根据订单状态获取订单
     * @param state
     * @return 返回订单信息
     */
    List<Order> getAllOrderByState(Integer state);


    /**
     * 根据客户id获取该顾客所有下单的的所有订单
     * @param customerId
     * @return
     */
    List<Order> getAllOrderByCustomerId(BigInteger customerId);

    /**
     * 创建订单
     * @param order
     */
    void createOrder(Order order);

    /**
     * 更新订单状态
     * @param id
     * @param state
     */
    void updateState(@Param("id") BigInteger id, @Param("state") Integer state);

    /**
     * 更新订单的收货时间
     * @param id
     * @param receivingTime
     */
    void updateReceivingTime(@Param("id") BigInteger id, @Param("receivingTime") String receivingTime);
}
