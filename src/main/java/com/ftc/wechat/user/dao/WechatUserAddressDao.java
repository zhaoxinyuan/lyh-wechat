package com.ftc.wechat.user.dao;

import java.util.List;

import com.ftc.wechat.user.pojo.WechatUserAddress;

public interface WechatUserAddressDao {
    int deleteByPrimaryKey(Integer addressId);

    int insert(WechatUserAddress record);

    int insertSelective(WechatUserAddress record);

    WechatUserAddress selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(WechatUserAddress record);

    int updateByPrimaryKey(WechatUserAddress record);
    
    int updateDefaultAddress(WechatUserAddress record);
    
    List<WechatUserAddress> selectByUserId(Integer userWechatid);
}