package com.ftc.wechat.roll.dao;

import com.ftc.wechat.roll.pojo.WechatRollNumber;

public interface WechatRollNumberDao {
    int deleteByPrimaryKey(Integer numberId);

    int insert(WechatRollNumber record);

    int insertSelective(WechatRollNumber record);

    WechatRollNumber selectByPrimaryKey(Integer numberId);

    int updateByPrimaryKeySelective(WechatRollNumber record);

    int updateByPrimaryKey(WechatRollNumber record);
    
    WechatRollNumber getNumberCount(Integer numberUserid);
}