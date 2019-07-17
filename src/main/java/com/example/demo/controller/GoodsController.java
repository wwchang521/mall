package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Goods;
import com.example.demo.entity.User;
import com.example.demo.service.GoodsService;
import com.example.demo.vo.BrowseGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
/**
 * @author zyy
 */
@RestController
@RequestMapping("")
public class GoodsController {
    @Autowired
    GoodsService goodsService;
    @GetMapping(value = "/getAllGoods")
    public List<Goods> getAllGoods(){
        return goodsService.getAllGoods();
    }

    @GetMapping(value = "/goods/details/{goodsId}")
    public Goods geGoodsById(@PathVariable("goodsId") BigInteger goodsId){
        return goodsService.getGoodsById(goodsId);
    }

}
