package com.ftc.wechat.roll.dao;

import com.ftc.wechat.roll.pojo.WechatRollResult;

public interface WechatRollResultDao {
    int deleteByPrimaryKey(Integer resId);

    int insert(WechatRollResult record);

    int insertSelective(WechatRollResult record);

    WechatRollResult selectByPrimaryKey(Integer resId);

    int updateByPrimaryKeySelective(WechatRollResult record);

    int updateByPrimaryKey(WechatRollResult record);
}