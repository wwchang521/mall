package com.example.demo.service;

import com.example.demo.dao.CustomerMapper;
import com.example.demo.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    protected CustomerMapper customerMapper;

    public void updateCustomer(Customer customer){
        customerMapper.updateCustomer(customer);
    }
}
