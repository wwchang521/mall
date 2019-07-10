package com.example.demo.service;

import com.example.demo.dao.CustomerMapper;
import com.example.demo.dao.SellerMapper;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    protected CustomerMapper customerMapper;
    @Autowired
    protected SellerMapper sellerMapper;

    public User getByAccount(String account){
        User user = null;
        try{
            user = sellerMapper.getByAccount(account);
            if (user!=null){
                user.setRole(1);
            }

            else {
                user = customerMapper.getByAccount(account);
                if(user!=null) {
                    user.setRole(0);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }
}
