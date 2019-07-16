package com.example.demo.security.auth;

import com.example.demo.entity.Customer;
import com.example.demo.entity.User;

import java.math.BigInteger;

/**
 * @author zyy
 */
public class JwtPayload {
    private BigInteger id;
    private String account;
    private String role;
    private Long exp;
    public JwtPayload() {

    }

    JwtPayload(BigInteger id, String account, String role, Long exp) {
        this.id = id;
        this.account = account;
        this.role = role;
        this.exp = exp;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public Long getExp() {
        return exp;
    }

    public void setExp(Long exp) {
        this.exp = exp;
    }

    public User toUser() {
        User user = new User();
        user.setId(id);
        String customer="customer";
        String seller="seller";
        if (role.equals(customer)) {
            user.setRole(0);
        } else if(role.equals(seller)){
            user.setRole(1);
        }
        return user;
    }
}

