package com.example.demo.dto;

import java.math.BigInteger;

public class CartGoodsDTO {
    BigInteger goodsId;
    Integer number;

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public CartGoodsDTO() {
    }

    public CartGoodsDTO(BigInteger goodsId, Integer number) {
        this.goodsId = goodsId;

        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
