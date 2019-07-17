package com.example.demo.service;

import com.example.demo.dao.OrderMapper;
import com.example.demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;

/**
 * @author wwchang
 * @date 2019-07-14 14:58
 */
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public Order getOrderById(BigInteger id){return orderMapper.getOrderById(id);}

    
}
