package com.example.demo.entity;

import java.math.BigInteger;

public class Customer extends User{

    private Integer sex;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getPortrait() {
        return portrait;
    }

    public void setPortrait(Integer portrait) {
        this.portrait = portrait;
    }

    private  String alias;
    private Integer portrait;

   public Customer(){
        role=0;
    }

}
