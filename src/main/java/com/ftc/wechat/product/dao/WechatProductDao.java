package com.ftc.wechat.product.dao;

import java.util.List;

import com.ftc.wechat.product.pojo.WechatProduct;

public interface WechatProductDao {
    int deleteByPrimaryKey(Integer productId);

    int insert(WechatProduct record);

    int insertSelective(WechatProduct record);

    WechatProduct selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(WechatProduct record);

    int updateByPrimaryKey(WechatProduct record);
    
    List<WechatProduct> findProduct();
    
    List<WechatProduct> findProductByCategory(Integer productCategoryid);
    
    WechatProduct findProductInfo(Integer productId);
   
}