package com.ftc.wechat.pay.dao;

import java.util.List;

import com.ftc.wechat.pay.pojo.WechatPayPlatform;

public interface WechatPayPlatformDao {
    
    WechatPayPlatform selectByPrimaryKey(Integer platformId);
    
    WechatPayPlatform selectByPlatformCode(String platformCode);
    
    List<WechatPayPlatform> selectAll();
}