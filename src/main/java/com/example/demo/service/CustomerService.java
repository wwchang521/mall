package com.example.demo.service;

import com.example.demo.dao.CustomerAddressMapper;
import com.example.demo.dao.CustomerMapper;
import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
/**
 * @author zyy
 */
@Service
public class CustomerService {
    @Autowired
    protected CustomerMapper customerMapper;

    @Autowired
    protected CustomerAddressMapper customerAddressMapper;

    public void updateCustomer(Customer customer){
        customerMapper.updateCustomer(customer);
    }

    public void updateAddress(Address address){customerAddressMapper.updateAddress(address);}

    public void addAddress(Address address){customerAddressMapper.addAddress(address);}

    public Customer getInfo(User user){
        return customerMapper.getInfoById(user.getId());
    }

    public List<Address> getAddress(User user){
        return customerAddressMapper.getAddressByCustomerId(user.getId());
    }

    public void deleteAddress(BigInteger id){
        customerAddressMapper.deleteById(id);
    }

    public void addCustomer(Customer customer){customerMapper.addCustomer(customer);}

    public List<Customer>getAllCustomer(){return  customerMapper.getAllCustomer();}
}
