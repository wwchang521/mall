package com.example.demo.dao;

import com.example.demo.entity.Customer;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;
/**
 * @author zyy
 */
@Mapper
public interface CustomerMapper {
    /**
     * 修改顾客信息
     * @param customer 顾客
     */
    void updateCustomer(Customer customer);

    /**
     * 根据account获取顾客
     * @param account 账户
     * @return
     */
    User getByAccount(String account);

    /**
     * 根据顾客id获取顾客
     * @param id  顾客id
     * @return
     */
    Customer getInfoById(BigInteger id);

    /**
     * 添加用户
     * @param customer 顾客
     */
    void addCustomer(Customer customer);

    /**
     * 获取所有的用户
     * @return
     */
    List<Customer> getAllCustomer();
}
