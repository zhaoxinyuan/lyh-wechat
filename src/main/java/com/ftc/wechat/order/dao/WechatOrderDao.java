package com.ftc.wechat.order.dao;

import java.util.List;

import com.ftc.wechat.order.pojo.SerialNumber;
import com.ftc.wechat.order.pojo.WechatOrder;

public interface WechatOrderDao {
    int deleteByPrimaryKey(Integer orderId);

    int insert(WechatOrder record);

    int insertSelective(WechatOrder record);

    WechatOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(WechatOrder record);

    int updateByPrimaryKey(WechatOrder record);
    
    SerialNumber selectSerial();
    
    List<WechatOrder> selectOrderByUser(WechatOrder record);
    
    WechatOrder selectByOrderNo(String orderNo);
    
    List<WechatOrder> overtimeOrder();
    
    WechatOrder getLastOrder(Integer orderUserid);
}