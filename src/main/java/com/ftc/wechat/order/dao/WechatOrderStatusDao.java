package com.ftc.wechat.order.dao;

import com.ftc.wechat.order.pojo.WechatOrderStatus;

public interface WechatOrderStatusDao {
    int deleteByPrimaryKey(Integer statusId);

    int insert(WechatOrderStatus record);

    int insertSelective(WechatOrderStatus record);

    WechatOrderStatus selectByPrimaryKey(Integer statusId);

    int updateByPrimaryKeySelective(WechatOrderStatus record);

    int updateByPrimaryKey(WechatOrderStatus record);
    
    WechatOrderStatus selectByCode(String statusCode);
}