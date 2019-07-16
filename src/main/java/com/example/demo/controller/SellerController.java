package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Goods;
import com.example.demo.entity.Seller;
import com.example.demo.entity.User;
import com.example.demo.service.CustomerService;
import com.example.demo.service.GoodsManaService;
import com.example.demo.service.GoodsService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
/**
 * @author zyy
 */
@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired
    UserService userService;
    @Autowired
    CustomerService customerService;
    @Autowired
    GoodsManaService goodsManaService;
    @Autowired
    GoodsService goodsService;

    @PutMapping(value = "/updatePassword")
    public void updatePassword(@RequestBody Map<String, Object> map, @RequestAttribute("user")User user) throws Exception {
        String oldPassword=map.get("oldPassword").toString();
        String newPassword=map.get("newPassword").toString();
        userService.updateSellerInfo(user,oldPassword,newPassword);
    }

    @GetMapping(value = "/getAllCustomer")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }


    @GetMapping(value = "/allGoods")
    public List<Goods> getAllGoods(){
        return goodsService.getAllGoods();
    }


    @DeleteMapping(value = "/deletegoods")
    public Boolean deleteGoods(@RequestBody Map<String, Object> map){
        BigInteger goodsId=new BigInteger(map.get("Id").toString());
        goodsManaService.deleteGoodsById(goodsId);
        return true;
    }

    @PutMapping(value = "/updategoods")
    public Boolean updateGoods(@RequestBody Map<String, Object> map){
        BigInteger goodsId=new BigInteger(map.get("id").toString());
        Goods goods=new Goods();
        goods.setId(goodsId);
        goods.setIntroduce(map.get("introduce").toString());
        goods.setName(map.get("name").toString());
        goods.setPicture(map.get("picture").toString());
        goods.setStore(Integer.parseInt(map.get("store").toString()));
        goods.setPrice(Double.parseDouble(map.get("price").toString()));
        goodsManaService.updateGoods(goods);
        return true;
    }

    @PostMapping(value = "/addgoods")
    public void addGoods(@RequestBody Map<String, Object> map){
        Goods goods=new Goods();
        goods.setIntroduce(map.get("introduce").toString());
        goods.setName(map.get("name").toString());
        goods.setPicture(map.get("picture").toString());
        goods.setStore(Integer.parseInt(map.get("store").toString()));
        goods.setPrice(Double.parseDouble(map.get("price").toString()));
        goods.setSale(0);
        goodsManaService.addGoods(goods);;
    }


    @GetMapping(value = "/search")
    public List<Goods> searchGoods(@RequestBody Map<String, Object> map){
        String searchContent=map.get("content").toString();
        return goodsManaService.vagueSearch(searchContent);
    }



}
