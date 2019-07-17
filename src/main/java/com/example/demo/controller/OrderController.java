package com.example.demo.controller;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wwchang
 * @date 2019-07-14 14:59
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/getOrder/{id}")
    public void getOrder(@PathVariable("id") BigInteger id){
        orderService.getOrderById(id);
    }

    @PostMapping(value = "/createOrder")
    public void createOrde(@RequestBody Map<String, Object> map){
        List<String> goodsIdStringList=(ArrayList<String>)map.get("goodsIdList");
        List<Integer>goodsNumberList=(ArrayList<Integer>)map.get("goodsNumberList");
        BigInteger customerAddressId=new BigInteger(map.get("customerAddressId").toString());
        BigInteger customerId=new BigInteger(map.get("customerId").toString());
        orderService.createOrder(goodsIdStringList,goodsNumberList,customerId,customerAddressId);
    }

    @PutMapping(value = "/payOrder")
    public void payOrder(@RequestBody Map<String, Object> map){
        BigInteger id=new BigInteger(map.get("orderId").toString());
        orderService.payOrder(id);
    }

    @PutMapping(value = "/cancelOrder")
    public void cancelOrder(@RequestBody Map<String, Object> map){
        BigInteger id=new BigInteger(map.get("orderId").toString());
        orderService.cancelOrder(id);
    }

    @PutMapping(value = "/confirmOrder")
    public void confirmOrder(@RequestBody Map<String, Object> map){
        BigInteger id=new BigInteger(map.get("orderId").toString());
        orderService.confirmOrder(id);
    }

    @GetMapping(value = "/getAllOrder")
    public List<Order> getAllOrder(@RequestBody Map<String, Object> map){
        BigInteger customerId=new BigInteger(map.get("customerId").toString());
        return orderService.getAllOrder(customerId);
    }


}
