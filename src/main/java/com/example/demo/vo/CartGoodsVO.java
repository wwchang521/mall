package com.example.demo.vo;

import java.math.BigInteger;
/**
 * @author zyy
 */
public class CartGoodsVO {
    BigInteger id;
    Double price;
    String name;
    Integer count;

    public BigInteger getId() {
        return id;
    }

    public CartGoodsVO() {
    }

    public CartGoodsVO(BigInteger id, Double price, String name, Integer count, String picture, String introduce, Integer store, Integer sale) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.count = count;
        this.picture = picture;
        this.introduce = introduce;
        this.store = store;
        this.sale = sale;
    }

    public void setId(BigInteger goodsId) {
        this.id = goodsId;

    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    String picture;
    String introduce;
    Integer store;
    Integer sale;

}
