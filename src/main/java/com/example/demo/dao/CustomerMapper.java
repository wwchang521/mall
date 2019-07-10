package com.example.demo.dao;

import com.example.demo.entity.Customer;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    void updateCustomer(Customer customer);
    User getByAccount(String account);
}
