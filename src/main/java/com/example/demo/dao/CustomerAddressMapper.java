package com.example.demo.dao;

import com.example.demo.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;
/**
 * @author zyy
 */
@Mapper
public interface CustomerAddressMapper {
    /**
     * 修改地址信息
     * @param address 地址
     */
    void updateAddress(Address address);

    /**
     * 添加地址
     * @param address 地址
     */
    void addAddress(Address address);

    /**
     * 根据顾客id获取地址信息
     * @param customerId 顾客id
     * @return
     */
    List<Address>getAddressByCustomerId(BigInteger customerId);

    /**
     * 通过id删除地址
     * @param id id
     */
    void deleteById(BigInteger id);

    /**
     * 根据id获取地址信息
     * @param id id
     * @return
     */
   Address getAddressById(BigInteger id);


}
