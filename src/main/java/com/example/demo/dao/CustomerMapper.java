package com.example.demo.dao;

import com.example.demo.entity.Customer;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;

@Mapper
public interface CustomerMapper {
    void updateCustomer(Customer customer);
    User getByAccount(String account);
    Customer getInfoById(BigInteger id);
}
