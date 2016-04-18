package com.ftc.wechat.product.dao;

import com.ftc.wechat.product.pojo.WechatProductSpec;

public interface WechatProductSpecDao {
    int deleteByPrimaryKey(Integer specId);

    int insert(WechatProductSpec record);

    int insertSelective(WechatProductSpec record);

    WechatProductSpec selectByPrimaryKey(Integer specId);

    int updateByPrimaryKeySelective(WechatProductSpec record);

    int updateByPrimaryKey(WechatProductSpec record);
}