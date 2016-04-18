package com.ftc.wechat.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftc.wechat.base.controller.BaseAction;
import com.ftc.wechat.base.entity.MyStatus;
import com.ftc.wechat.user.pojo.WechatUser;
import com.ftc.wechat.user.pojo.WechatUserPoints;
import com.ftc.wechat.user.service.UserPointsService;
import com.ftc.wechat.user.service.UserService;

@Controller  
@RequestMapping("/userAction")
@ResponseBody
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserAction extends BaseAction{
	@Resource
	private UserService userservice;
	
	@Resource
	private UserPointsService userpointsservice;
	
	@RequestMapping(value = "getUserInfo",method = RequestMethod.GET) 
	public WechatUser getUserInfo(HttpServletRequest request,HttpServletResponse response){
		return userservice.findUserInfo(super.getSignUser(request).getUserId());
	}
	
	@RequestMapping(value = "getUserDetail",method = RequestMethod.GET) 
	public WechatUser getUserDetail(HttpServletRequest request,HttpServletResponse response){
		return userservice.findUserDetail(super.getSignUser(request).getUserId());
	}
	
	@RequestMapping(value = "updateUserDetail",method = RequestMethod.GET) 
	public MyStatus updateUserDetail(HttpServletRequest request,HttpServletResponse response,WechatUser user){
		Integer res = userservice.updateUser(user); 
		MyStatus mystatus = new MyStatus();
		if(res == 1){
			mystatus.setSuccess();
		}else{
			mystatus.setError("修改失败");
		}
		return mystatus;
	}
	
	@RequestMapping(value = "getUserPointsAmount",method = RequestMethod.GET) 
	public WechatUserPoints getUserPointsAmount(HttpServletRequest request,HttpServletResponse response){
		return userpointsservice.getPointsAmount(super.getSignUser(request).getUserId());
	}
	
	@RequestMapping(value = "getUserPointsDetail",method = RequestMethod.GET) 
	public List<WechatUserPoints> getUserPointsDetail(HttpServletRequest request,HttpServletResponse response){
		return userpointsservice.getPointsDetail(super.getSignUser(request).getUserId());
	}
}
