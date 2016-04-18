package com.ftc.wechat.sys.dao;

import com.ftc.wechat.sys.pojo.WechatSysPointsDict;

public interface WechatSysPointsDictDao {
    int deleteByPrimaryKey(Integer dictId);

    int insert(WechatSysPointsDict record);

    int insertSelective(WechatSysPointsDict record);

    WechatSysPointsDict selectByPrimaryKey(Integer dictId);

    int updateByPrimaryKeySelective(WechatSysPointsDict record);

    int updateByPrimaryKey(WechatSysPointsDict record);
}