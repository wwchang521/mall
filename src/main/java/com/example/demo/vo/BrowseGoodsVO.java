package com.example.demo.vo;

import java.math.BigInteger;
/**
 * @author zyy
 */
public class BrowseGoodsVO {
    BigInteger goodsId;
    Integer sale;
    String name;

    public BigInteger getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(BigInteger goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BrowseGoodsVO(BigInteger goodsId, Integer sale, String name, Double price, String picture) {
        this.goodsId = goodsId;
        this.sale = sale;
        this.name = name;
        this.price = price;
        this.picture = picture;
    }

    public BrowseGoodsVO() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    Double price;
    String picture;
}
