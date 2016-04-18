package com.ftc.wechat.pay.dao;

import com.ftc.wechat.pay.pojo.WechatPay;

public interface WechatPayDao {
    int deleteByPrimaryKey(Integer payId);

    int insert(WechatPay record);

    int insertSelective(WechatPay record);

    WechatPay selectByPrimaryKey(Integer payId);

    int updateByPrimaryKeySelective(WechatPay record);

    int updateByPrimaryKey(WechatPay record);
    
    WechatPay selectByOrderNo(String orderNo);
}