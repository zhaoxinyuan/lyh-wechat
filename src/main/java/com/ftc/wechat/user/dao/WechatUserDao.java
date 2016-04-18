package com.ftc.wechat.user.dao;

import com.ftc.wechat.user.pojo.WechatUser;

public interface WechatUserDao {
    int deleteByPrimaryKey(Integer userId);

    int insert(WechatUser record);

    int insertSelective(WechatUser record);

    WechatUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(WechatUser record);

    int updateByPrimaryKey(WechatUser record);
    
    WechatUser selectByWechatId(String userWechatid);
    
    WechatUser selectUserInfo(Integer userId);
}