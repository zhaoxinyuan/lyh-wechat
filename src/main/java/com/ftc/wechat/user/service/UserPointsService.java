package com.ftc.wechat.user.service;

import java.util.List;

import com.ftc.wechat.user.pojo.WechatUserPoints;

public interface UserPointsService {
	
	WechatUserPoints getPointsAmount(Integer pointsUserid);
	
	List<WechatUserPoints> getPointsDetail(Integer pointsUserid);
}
