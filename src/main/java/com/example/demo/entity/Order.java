package com.example.demo.entity;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author wwchang
 * @date 2019-07-12 14:21
 */
public class Order {
    public Order() {
    }

    BigInteger id;
    Integer state;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public BigInteger getCustomerAddressId() {
        return customerAddressId;
    }

    public void setCustomerAddressId(BigInteger customerAddressId) {
        this.customerAddressId = customerAddressId;
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getReceivingTime() {
        return receivingTime;
    }

    public void setReceivingTime(String receivingTime) {
        this.receivingTime = receivingTime;
    }

    public Order(BigInteger id, Integer state, BigInteger customerAddressId, BigInteger customerId, String orderTime, String receivingTime) {
        this.id = id;

        this.state = state;
        this.customerAddressId = customerAddressId;
        this.customerId = customerId;
        this.orderTime = orderTime;
        this.receivingTime = receivingTime;
    }

    BigInteger customerAddressId;
    BigInteger customerId;
    String orderTime;
    String receivingTime;


}
