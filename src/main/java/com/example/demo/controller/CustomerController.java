package com.example.demo.controller;


import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.entity.User;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @GetMapping(value = "/getInfo")
    public Customer getInfo(@RequestAttribute("user") User user){
       return customerService.getInfo(user);
    }

    @PutMapping(value = "/updateInfo")
    public void updateCustomer(@RequestBody Map<String, Object> map) throws IOException {
        Customer customer=new Customer();
        customer.setId(new BigInteger("1"));
        customer.setAlias(map.get("alias").toString());
        customer.setPassword(map.get("password").toString());
        customer.setPortrait(Integer.parseInt(map.get("portrait").toString()));
        customer.setSex(Integer.parseInt(map.get("sex").toString()));
        customerService.updateCustomer(customer);
    }

    @GetMapping(value = "/getAddress")
    public List<Address> getAddress(@RequestAttribute("user") User user){
        return customerService.getAddress(user);
    }

    @PutMapping(value = "/updateAddress")
    public void updateAddress(@RequestBody Map<String, Object> map){
        Address address=new Address();
        address.setPhone(map.get("phone").toString());
        address.setAddress(map.get("address").toString());
        address.setReceiver(map.get("receiver").toString());
        address.setId(new BigInteger(map.get("id").toString()));
        customerService.updateAddress(address);
    }

    @PostMapping(value = "/addAddress")
    public void addAddress(@RequestBody Map<String, Object> map,@RequestAttribute("user") User user){
        Address address=new Address();
        address.setPhone(map.get("phone").toString());
        address.setAddress(map.get("address").toString());
        address.setReceiver(map.get("receiver").toString());
        address.setCustomerId(user.getId());
        customerService.addAddress(address);
    }

    @DeleteMapping(value = "/deleteAddress/{id}")
    public void deleteAddress(@PathVariable("id") BigInteger id){
        customerService.deleteAddress(id);
    }
}
