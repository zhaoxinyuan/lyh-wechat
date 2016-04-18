package com.ftc.wechat.user.service;

import com.ftc.wechat.user.pojo.WechatUser;

public interface UserService {

	WechatUser findUserByWechatId(String wechatid);
	
	int saveUser(WechatUser user);
	
	WechatUser findUserInfo(Integer userId);
	
	WechatUser findUserDetail(Integer userId);
	
	int updateUser(WechatUser user);
}
