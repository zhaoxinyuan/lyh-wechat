package com.ftc.wechat.order.dao;

import com.ftc.wechat.order.pojo.WechatOrderExpress;

public interface WechatOrderExpressDao {
    int deleteByPrimaryKey(Integer expressId);

    int insert(WechatOrderExpress record);

    int insertSelective(WechatOrderExpress record);

    WechatOrderExpress selectByPrimaryKey(Integer expressId);

    int updateByPrimaryKeySelective(WechatOrderExpress record);

    int updateByPrimaryKey(WechatOrderExpress record);
    
}