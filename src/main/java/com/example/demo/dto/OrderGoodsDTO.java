package com.example.demo.dto;


import java.math.BigInteger;

/**
 * @author Zhu
 */
public class OrderGoodsDTO {
    BigInteger goodsId;
    BigInteger orderId;
    Integer goodsNum;

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public OrderGoodsDTO() {
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;

    }

    public OrderGoodsDTO(BigInteger goodsId, BigInteger orderId, Integer goodsNum) {
        this.goodsId = goodsId;
        this.orderId = orderId;
        this.goodsNum = goodsNum;
    }

    public BigInteger getOrderId() {
        return orderId;

    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
