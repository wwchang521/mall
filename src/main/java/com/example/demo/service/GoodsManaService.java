package com.example.demo.service;

import com.example.demo.dao.GoodsMapper;
import com.example.demo.entity.Goods;
import com.example.demo.utils.UploadFileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * @author zyy
 */
@Service
public class GoodsManaService {
    @Autowired
    GoodsMapper goodsMapper;
    public void addGoods(Goods goods){
        goodsMapper.addGoods(goods);
    }

    public List<Goods> vagueSearch(String searchContent){
        return goodsMapper.vagueSearch(searchContent);
    }

    public void updateGoods(Goods goods){
        goodsMapper.updateGoods(goods);
    }

    public void deleteGoodsById(BigInteger id){
        goodsMapper.deleteGoodsById(id);
    }

    public String uploadFile(MultipartFile uploadFile,String fileName){
        String result=UploadFileUtil.checkFile("E:\\pic\\",fileName);
        String msg="true";
        while(msg.equals(result)){
            //返回当前时间命名的图片
            String suffixName=fileName.substring(fileName.lastIndexOf("."));
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
            fileName=df.format(new Date())+suffixName;
            result=UploadFileUtil.checkFile("E:\\pic\\",fileName);
        }
        UploadFileUtil.uploadFile(uploadFile,"E:\\pic\\",fileName);
        return fileName;

    }
}
