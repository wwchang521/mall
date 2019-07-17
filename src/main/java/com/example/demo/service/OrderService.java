package com.example.demo.service;

import com.example.demo.dao.OrderGoodsMapper;
import com.example.demo.dao.OrderMapper;
import com.example.demo.dto.OrderGoodsDTO;
import com.example.demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author wwchang
 * @date 2019-07-14 14:58
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;

    public Order getOrderById(BigInteger id){return orderMapper.getOrderById(id);}

    public void createOrder(List<String> goodsIdStringList,List<Integer>goodsNumberList,BigInteger customerId,BigInteger customerAddressId){
       Integer state=1;
       String orderTime = new Timestamp(System.currentTimeMillis()).toString();
        Order order=new Order(new BigInteger("0"),state,customerAddressId,customerId,orderTime,null);
        orderMapper.createOrder(order);
        for(int i=0;i<goodsIdStringList.size();i++){
            BigInteger goodsId=new BigInteger(goodsIdStringList.get(i));
            OrderGoodsDTO orderGoodsDTO=new OrderGoodsDTO(goodsId,order.getId(),goodsNumberList.get(i));
            orderGoodsMapper.createOrderGoods(orderGoodsDTO);
        }
    }

    public void payOrder(BigInteger id){
        Integer state=3;
        orderMapper.updateState(id,state);
    }

    public void cancelOrder(BigInteger id){
        Integer state=2;
        orderMapper.updateState(id,state);
    }

    public void confirmOrder(BigInteger id){
        Integer state=5;
        orderMapper.updateState(id,state);
        String receivingTime = new Timestamp(System.currentTimeMillis()).toString();
        orderMapper.updateReceivingTime(id,receivingTime);
    }
    public List<Order>getAllOrder(BigInteger customerId){
        return orderMapper.getAllOrderByCustomerId(customerId);
    }
    
}
