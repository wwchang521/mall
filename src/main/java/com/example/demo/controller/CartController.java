package com.example.demo.controller;


import com.example.demo.dto.CustomerGoodsDTO;
import com.example.demo.entity.User;
import com.example.demo.service.CartService;
import com.example.demo.vo.CartGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping(value = "/getAllGoods")
    public List<CartGoodsVO> getAllGoods(@RequestAttribute("user") User user) throws ClassNotFoundException {
       return cartService.getAllGoods(user);
    }

    @PostMapping(value = "/addToCart")
    public void addToCart(@RequestAttribute("user") User user,@RequestBody Map<String, Object> map){
        CustomerGoodsDTO customerGoodsDTO=new CustomerGoodsDTO();
        customerGoodsDTO.setCustomerId(user.getId());
        customerGoodsDTO.setGoodsId(new BigInteger(map.get("goodsId").toString()));
        customerGoodsDTO.setNumber(Integer.parseInt(map.get("number").toString()));
        cartService.addToCart(customerGoodsDTO);
    }

    @PutMapping(value = "/updateGoodsNumber")
    public void updateGoodsNumber(@RequestAttribute("user") User user,@RequestBody Map<String, Object> map){
        CustomerGoodsDTO customerGoodsDTO=new CustomerGoodsDTO();
        customerGoodsDTO.setCustomerId(user.getId());
        customerGoodsDTO.setGoodsId(new BigInteger(map.get("goodsId").toString()));
        customerGoodsDTO.setNumber(Integer.parseInt(map.get("number").toString()));
        cartService.updateGoodsNumber(customerGoodsDTO);
    }

    @DeleteMapping(value = "/deleteGoods")
    public void deleteGoods(@RequestAttribute("user") User user,@RequestBody Map<String, Object> map){
        CustomerGoodsDTO customerGoodsDTO=new CustomerGoodsDTO();
        customerGoodsDTO.setCustomerId(user.getId());
        customerGoodsDTO.setGoodsId(new BigInteger(map.get("goodsId").toString()));
        cartService.deleteGoods(customerGoodsDTO);
    }

    @DeleteMapping(value = "/deleteMultiGoods")
    public void deleteMultiGoods(@RequestAttribute("user") User user, @RequestBody Map<String, Object> map){
        List<String>goodsIdStringList=(ArrayList<String>)map.get("goodsIdList");
        for(String id:goodsIdStringList){
            CustomerGoodsDTO customerGoodsDTO=new CustomerGoodsDTO();
            customerGoodsDTO.setCustomerId(user.getId());
            customerGoodsDTO.setGoodsId(new BigInteger(id));
            cartService.deleteGoods(customerGoodsDTO);
        }
    }
}
