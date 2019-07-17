package com.example.demo.vo;

import java.math.BigInteger;
import java.util.List;

/**
 * @author Zhu
 */
public class OrderVO {
    BigInteger id;
    BigInteger customerId;
    String orderTime;
    String address;

    public OrderVO() {
    }

    String receiver;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public List<OrderGoodsVO> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoodsVO> goodsList) {
        this.goodsList = goodsList;
    }

    String phone;

    public OrderVO(BigInteger id, BigInteger customerId, String orderTime, String address, String receiver, String phone, Integer state, List<OrderGoodsVO> goodsList) {
        this.id = id;
        this.customerId = customerId;
        this.orderTime = orderTime;
        this.address = address;
        this.receiver = receiver;
        this.phone = phone;
        this.state = state;
        this.goodsList = goodsList;
    }

    Integer state;
    List<OrderGoodsVO>goodsList;
    @Override
    public String toString() {
        return super.toString();
    }
}
