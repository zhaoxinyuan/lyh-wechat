package com.ftc.wechat.sys.dao;

import java.util.List;

import com.ftc.wechat.sys.pojo.WechatSysPointsRule;

public interface WechatSysPointsRuleDao {
    int deleteByPrimaryKey(Integer ruleId);

    int insert(WechatSysPointsRule record);

    int insertSelective(WechatSysPointsRule record);

    WechatSysPointsRule selectByPrimaryKey(Integer ruleId);
    
    List<WechatSysPointsRule> selectAll();

    int updateByPrimaryKeySelective(WechatSysPointsRule record);

    int updateByPrimaryKey(WechatSysPointsRule record);
}