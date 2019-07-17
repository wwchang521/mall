package com.example.demo.entity;

import java.math.BigInteger;
import java.util.Date;

/**
 * @author wwchang
 * @date 2019-07-12 14:21
 */
public class Order {
    BigInteger id;
    Integer state;
    BigInteger customerAddressId;
    BigInteger customerId;
    Date orderTime;//下单时间
    Date receivingTime;//收货时间


    public Order(BigInteger id, Integer state, BigInteger customerAddressId, BigInteger customerId) {
        this.id = id;
        this.state = state;
        this.customerAddressId = customerAddressId;
        this.customerId = customerId;
    }

    public Order() {

    }

    public Order(BigInteger id, Integer state, BigInteger customerAddressId, BigInteger customerId, Date orderTime, Date receivingTime) {
        this.id = id;
        this.state = state;
        this.customerAddressId = customerAddressId;
        this.customerId = customerId;
        this.orderTime = orderTime;
        this.receivingTime = receivingTime;
    }


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

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getReceivingTime() {
        return receivingTime;
    }

    public void setReceivingTime(Date receivingTime) {
        this.receivingTime = receivingTime;
    }
}
