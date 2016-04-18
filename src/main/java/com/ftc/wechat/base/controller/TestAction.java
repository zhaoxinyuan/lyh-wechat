package com.ftc.wechat.base.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftc.wechat.user.pojo.WechatUser;
import com.ftc.wechat.user.service.UserService;

@Controller
@RequestMapping("/testAction")
@ResponseBody
public class TestAction {

	@Resource
	UserService userservice;
	
	@RequestMapping(value = "setWechatUser",method = RequestMethod.GET)
	public String setWechatUser(HttpServletRequest request){
		WechatUser user = userservice.findUserByWechatId("of5l7t5Kf_WBKIbBMoHJc4cUkJZ4");
		request.getSession().setAttribute("signUser", user);
		return "success";
	}
}
