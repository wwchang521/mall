package com.example.demo.entity;

import java.math.BigInteger;

/**
 * @author zyy
 */
public class Address {
    BigInteger id;
    BigInteger customerId;

    public Address() {
    }

    public Address(BigInteger id, BigInteger customerId, String address, String phone, String receiver) {
        this.id = id;
        this.customerId = customerId;
        this.address = address;
        this.phone = phone;
        this.receiver = receiver;
    }

    String address;
    String phone;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    String receiver;
}
