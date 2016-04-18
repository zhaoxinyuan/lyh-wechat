package com.ftc.wechat.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ftc.wechat.user.dao.WechatUserDao;
import com.ftc.wechat.user.pojo.WechatUser;
import com.ftc.wechat.user.service.UserService;

@Service("userService")  
public class UserServiceImpl implements UserService{
	@Resource
	private WechatUserDao userdao;

	@Override
	public WechatUser findUserByWechatId(String wechatid) {
		return userdao.selectByWechatId(wechatid);
	}

	@Override
	public int saveUser(WechatUser user) {
		return userdao.insertSelective(user);
	}

	@Override
	public WechatUser findUserInfo(Integer userId) {
		return userdao.selectUserInfo(userId);
	}

	@Override
	public WechatUser findUserDetail(Integer userId) {
		return userdao.selectByPrimaryKey(userId);
	}

	@Override
	public int updateUser(WechatUser user) {
		return userdao.updateByPrimaryKeySelective(user);
	}
}
