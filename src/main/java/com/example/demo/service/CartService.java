package com.example.demo.service;

import com.example.demo.dao.CustomerGoodsMapper;
import com.example.demo.dao.GoodsMapper;
import com.example.demo.dto.CartGoodsDTO;
import com.example.demo.dto.CustomerGoodsDTO;
import com.example.demo.entity.Goods;
import com.example.demo.entity.User;
import com.example.demo.vo.CartGoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/**
 * @author zyy
 */
@Service
public class CartService {
    @Autowired
    CustomerGoodsMapper customerGoodsMapper;
    @Autowired
    GoodsMapper goodsMapper;
    public void addToCart(CustomerGoodsDTO customerGoodsDTO){
        CustomerGoodsDTO newCustomerGoods=customerGoodsMapper.getByCustomerIdAndGoodsId(customerGoodsDTO);
        if(newCustomerGoods==null) {
            customerGoodsMapper.addToCart(customerGoodsDTO);
        }
        else {
            Integer number=newCustomerGoods.getNumber();
            newCustomerGoods.setNumber(number+customerGoodsDTO.getNumber());
            customerGoodsMapper.updateGoodsNumber(newCustomerGoods);
        }
    }

    /*public void updateGoodsNumber(CustomerGoodsDTO customerGoodsDTO){
        customerGoodsMapper.updateGoodsNumber(customerGoodsDTO);
    }*/

    public void updateCart(ArrayList<CartGoodsDTO>goodsList,User user){
        BigInteger customerId=user.getId();
        for(CartGoodsDTO goods:goodsList){
            CustomerGoodsDTO customerGoods=new CustomerGoodsDTO();
            customerGoods.setCustomerId(customerId);
            customerGoods.setNumber(goods.getNumber());
            customerGoods.setGoodsId(goods.getGoodsId());
            customerGoodsMapper.updateGoodsNumber(customerGoods);
        }
    }

    public void deleteGoods(CustomerGoodsDTO customerGoodsDTO){
        customerGoodsMapper.deleteGoods(customerGoodsDTO);
    }

    public List<CartGoodsVO> getAllGoods(User user) throws ClassNotFoundException {
        List<CustomerGoodsDTO> customerGoodsList =customerGoodsMapper.getByCustomerId(user.getId());
        List<CartGoodsVO> cartGoodsList =new ArrayList<>();
        for (CustomerGoodsDTO customerGoodsDTO:customerGoodsList ){
            Goods goods=goodsMapper.getGoodsById(customerGoodsDTO.getGoodsId());
            if(goods==null){
                throw new ClassNotFoundException("goods not found!");
            }
            CartGoodsVO cartGoodsVO=new CartGoodsVO();
            cartGoodsVO.setName(goods.getName());
            cartGoodsVO.setCount(customerGoodsDTO.getNumber());
            cartGoodsVO.setIntroduce(goods.getIntroduce());
            cartGoodsVO.setSale(goods.getSale());
            cartGoodsVO.setStore(goods.getStore());
            cartGoodsVO.setPicture(goods.getPicture());
            cartGoodsVO.setPrice(goods.getPrice());
            cartGoodsVO.setId(goods.getId());
             cartGoodsList .add(cartGoodsVO);
        }
        return  cartGoodsList ;
    }
}
