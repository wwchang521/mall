package com.example.demo.entity;

import java.math.BigInteger;

public class Goods {
    BigInteger id;
    String name;
    String introduce;

    public Goods() {
    }

    public Goods(BigInteger id, String name, String introduce, double price, String picture, Integer store, Integer sale) {
        this.id = id;
        this.name = name;
        this.introduce = introduce;
        this.price = price;
        this.picture = picture;
        this.store = store;
        this.sale = sale;
    }

    double price;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
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
    Integer store;
    Integer sale;
}
