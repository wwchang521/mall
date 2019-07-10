package com.example.demo.controller;


import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @PutMapping(value = "/update")
    public void updateAlumni(@RequestBody Map<String, Object> map) throws IOException {
        Customer customer=new Customer();
        customer.setId(new BigInteger("1"));
        customer.setAlias(map.get("alias").toString());
        customer.setPassword(map.get("password").toString());
        customer.setPortrait(Integer.parseInt(map.get("portrait").toString()));
        customer.setSex(Integer.parseInt(map.get("sex").toString()));
        customerService.updateCustomer(customer);
    }
}
