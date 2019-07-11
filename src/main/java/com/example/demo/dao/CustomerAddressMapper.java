package com.example.demo.dao;

import com.example.demo.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;

@Mapper
public interface CustomerAddressMapper {
    void updateAddress(Address address);

    void addAddress(Address address);

    List<Address>getAddressByCustomerId(BigInteger customerId);

    void deleteById(BigInteger id);
}
