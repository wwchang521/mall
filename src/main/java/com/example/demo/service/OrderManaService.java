package com.example.demo.service;

import com.example.demo.dao.CustomerAddressMapper;
import com.example.demo.dao.GoodsMapper;
import com.example.demo.dao.OrderGoodsMapper;
import com.example.demo.dao.OrderMapper;
import com.example.demo.dto.OrderGoodsDTO;
import com.example.demo.entity.Address;
import com.example.demo.entity.Goods;
import com.example.demo.entity.Order;
import com.example.demo.vo.OrderGoodsVO;
import com.example.demo.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhu
 */
@Service
public class OrderManaService {
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    CustomerAddressMapper customerAddressMapper;
    @Autowired
    OrderGoodsMapper orderGoodsMapper;
    @Autowired
    GoodsMapper goodsMapper;


    public void confirmDeliver(BigInteger id){
        Integer state=4;
        orderMapper.updateState(id,state);
    }


    public List<OrderVO>getAllOrder(){
        List<Order>orderList = orderMapper.getAllOrder();
        return  getOrderVo(orderList);
    }

    public  List<OrderVO>getFinishOrder(){
        Integer state=5;
        List<Order>orderList=orderMapper.getAllOrderByState(state);
        return  getOrderVo(orderList);
    }




    public  List<OrderVO>getAllNotDeliverOrder(){
        Integer state=3;
        List<Order>orderList=orderMapper.getAllOrderByState(state);
        return  getOrderVo(orderList);
    }



    private List<OrderVO>getOrderVo(List<Order>orderList){
        List<OrderVO>orderVoList=new ArrayList<>();
        for(int i=0;i<orderList.size();i++){
            OrderVO orderVO=new OrderVO();
            orderVO.setId(orderList.get(i).getId());
            orderVO.setCustomerId(orderList.get(i).getCustomerId());
            orderVO.setState(orderList.get(i).getState());
            orderVO.setOrderTime(orderList.get(i).getOrderTime());
            orderVO.setReceivingTime(orderList.get(i).getReceivingTime());
            Address address = customerAddressMapper.getAddressById(orderList.get(i).getCustomerAddressId());
            orderVO.setAddress(address.getAddress());
            orderVO.setPhone(address.getPhone());
            orderVO.setReceiver(address.getReceiver());
            List<OrderGoodsDTO>orderGoodsDtoList=orderGoodsMapper.getByOrderId(orderList.get(i).getId());
            List<OrderGoodsVO>orderGoodsVoList=new ArrayList<>();
            for(OrderGoodsDTO orderGoods: orderGoodsDtoList){
                OrderGoodsVO orderGoodsVo=new OrderGoodsVO();
                orderGoodsVo.setId(orderGoods.getGoodsId());
                orderGoodsVo.setNum(orderGoods.getGoodsNum());
                Goods goods=goodsMapper.getGoodsById(orderGoods.getGoodsId());
                orderGoodsVo.setName(goods.getName());
                orderGoodsVo.setPrice(goods.getPrice());
                orderGoodsVoList.add(orderGoodsVo);
            }
            orderVO.setGoodsList(orderGoodsVoList);
            orderVoList.add(orderVO);
        }
        return  orderVoList;
    }
}
