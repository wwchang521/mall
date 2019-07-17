package com.example.demo.vo;

import java.math.BigInteger;

/**
 * @author Zhu
 */
public class OrderGoodsVO {
    BigInteger id;
    String name;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public OrderGoodsVO() {
    }

    public OrderGoodsVO(BigInteger id, String name, Integer num, Double price) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    Integer num;
    Double price;
    @Override
    public String toString() {
        return super.toString();
    }
}
