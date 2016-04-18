package com.ftc.wechat.base.controller;

import javax.servlet.http.HttpServletRequest;

import com.ftc.wechat.user.pojo.WechatUser;

public class BaseAction {

	public WechatUser getSignUser(HttpServletRequest request){
		return (WechatUser)request.getSession().getAttribute("signUser");
	}
	
	public void setSignUser(HttpServletRequest request,WechatUser user){
		request.getSession().setAttribute("signUser", user);
	}
}
