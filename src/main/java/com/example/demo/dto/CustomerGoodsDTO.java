package com.example.demo.dto;

import java.math.BigInteger;

public class CustomerGoodsDTO {
    BigInteger customerId;
    BigInteger goodsId;

    public CustomerGoodsDTO(BigInteger customerId, BigInteger goodsId, Integer number) {
        this.customerId = customerId;
        this.goodsId = goodsId;
        this.number = number;
    }

    public CustomerGoodsDTO() {
    }

    public BigInteger getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigInteger customerId) {
        this.customerId = customerId;
    }

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    Integer number;
}
