package com.example.demo.dao;

import com.example.demo.entity.Seller;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
/**
 * @author zyy
 */
@Mapper
public interface SellerMapper {
    /**
     * 根据账户获取店家信息
     * @param account
     * @return
     */
    User getByAccount(String account);

    /**
     * 修改密码
     * @param user
     */
    void updatePassword(User user);

    /**
     * 根据id获取店家信息
     * @param id
     * @return
     */
    Seller getById(BigInteger id);
}
