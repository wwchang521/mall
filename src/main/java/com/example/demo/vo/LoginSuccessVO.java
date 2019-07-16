package com.example.demo.vo;

import java.math.BigInteger;
/**
 * @author zyy
 */
public class LoginSuccessVO {
    private BigInteger id;

    public BigInteger getId() {
        return id;
    }

    public LoginSuccessVO() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public LoginSuccessVO(BigInteger id, String role, String jwt, String account) {
        this.id = id;
        this.role = role;
        this.jwt = jwt;
        this.account = account;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    private String role;
    private String jwt;
    private String account;
}
