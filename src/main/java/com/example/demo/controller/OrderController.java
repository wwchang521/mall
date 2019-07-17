package com.example.demo.controller;

import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigInteger;

/**
 * @author wwchang
 * @date 2019-07-14 14:59
 */
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "/getOrder/{id}")
    public void getOrder(@PathVariable("id") BigInteger id){
        orderService.getOrderById(id);
    }


}
