package com.example.demo.vo;

import java.math.BigInteger;

public class CartGoodsVO {
    BigInteger goodsId;
    double price;
    String name;

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public CartGoodsVO(BigInteger goodsId, double price, String name, Integer number, String picture) {
        this.goodsId = goodsId;
        this.price = price;
        this.name = name;
        this.number = number;
        this.picture = picture;
    }

    public CartGoodsVO() {
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    Integer number;
    String picture;

}
