package com.ftc.wechat.user.dao;

import com.ftc.wechat.user.pojo.WechatUserEvaluate;

public interface WechatUserEvaluateDao {
    int deleteByPrimaryKey(Integer evaluateId);

    int insert(WechatUserEvaluate record);

    int insertSelective(WechatUserEvaluate record);

    WechatUserEvaluate selectByPrimaryKey(Integer evaluateId);

    int updateByPrimaryKeySelective(WechatUserEvaluate record);

    int updateByPrimaryKey(WechatUserEvaluate record);
}