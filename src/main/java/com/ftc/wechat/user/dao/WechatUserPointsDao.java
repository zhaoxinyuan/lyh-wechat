package com.ftc.wechat.user.dao;

import java.util.List;

import com.ftc.wechat.user.pojo.WechatUserPoints;

public interface WechatUserPointsDao {
    int deleteByPrimaryKey(Integer pointsId);

    int insert(WechatUserPoints record);

    int insertSelective(WechatUserPoints record);

    WechatUserPoints selectByPrimaryKey(Integer pointsId);

    int updateByPrimaryKeySelective(WechatUserPoints record);

    int updateByPrimaryKey(WechatUserPoints record);
    
    WechatUserPoints selectPointsAmountByUser(Integer pointsUserid);
    
    List<WechatUserPoints> selectAllByUser(Integer pointsUserid);
}