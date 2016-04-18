package com.ftc.wechat.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ftc.wechat.user.dao.WechatUserPointsDao;
import com.ftc.wechat.user.pojo.WechatUserPoints;
import com.ftc.wechat.user.service.UserPointsService;

@Service("userPointsService") 
public class UserPointsServiceImpl implements UserPointsService{
	
	@Resource
	WechatUserPointsDao userpointsdao; 

	public WechatUserPoints getPointsAmount(Integer pointsUserid) {
		return userpointsdao.selectPointsAmountByUser(pointsUserid);
	}

	public List<WechatUserPoints> getPointsDetail(Integer pointsUserid) {
		return userpointsdao.selectAllByUser(pointsUserid);
	}

	
}
