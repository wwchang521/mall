package com.example.demo.dao;

import com.example.demo.entity.Goods;
import com.example.demo.vo.BrowseGoodsVO;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigInteger;
import java.util.List;
/**
 * @author zyy
 */
@Mapper
public interface GoodsMapper {
    /**
     * 根据id获取商品
     * @param id id
     * @return
     */
    Goods getGoodsById(BigInteger id);

    /**
     * 获取所有商品
     * @return
     */
    List<Goods>getAllGoods();

    /**
     * 添加商品
     * @param goods
     */
    void addGoods(Goods goods);

    /**
     * 模糊搜索
     * @param searchContent
     * @return
     */
    List<Goods>vagueSearch(String searchContent);

    /**
     * 修改商品信息
     * @param goods
     */
    void updateGoods(Goods goods);

    /**
     * 根据id删除商品
     * @param id
     */
    void deleteGoodsById(BigInteger id);
}
