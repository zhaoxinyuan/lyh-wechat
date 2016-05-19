package com.ftc.wechat.roll.service;

import com.ftc.wechat.roll.pojo.WechatRollNumber;
import com.ftc.wechat.roll.pojo.WechatRollResult;

public interface RollService {

	public void addNumber(WechatRollNumber number);
	
	public void addRollProduct(WechatRollResult result);
	
	public WechatRollNumber getRollNumberCount(Integer numberUserid);
}
