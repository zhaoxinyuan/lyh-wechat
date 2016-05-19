package com.ftc.wechat.roll.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ftc.wechat.roll.dao.WechatRollNumberDao;
import com.ftc.wechat.roll.dao.WechatRollResultDao;
import com.ftc.wechat.roll.pojo.WechatRollNumber;
import com.ftc.wechat.roll.pojo.WechatRollResult;
import com.ftc.wechat.roll.service.RollService;

@Service("rollService")
public class RollServiceImpl implements RollService{
	
	@Resource
	private WechatRollNumberDao numberdao;
	
	@Resource
	private WechatRollResultDao resultdao;

	@Override
	public void addNumber(WechatRollNumber number) {
		numberdao.insertSelective(number);	
	}

	@Override
	public void addRollProduct(WechatRollResult result) {
		resultdao.insertSelective(result);
		WechatRollNumber number = new WechatRollNumber();
		number.setNumberUserid(result.getResUserid());
		number.setNumberFrom("抽奖使用");
		number.setNumberCount(-1);
		numberdao.insertSelective(number);
	}

	@Override
	public WechatRollNumber getRollNumberCount(Integer numberUserid) {
		return numberdao.getNumberCount(numberUserid);
	}

}
