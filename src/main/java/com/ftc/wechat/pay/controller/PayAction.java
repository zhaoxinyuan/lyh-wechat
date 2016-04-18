package com.ftc.wechat.pay.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import com.ftc.wechat.order.service.OrderService;
import com.ftc.wechat.pay.pojo.WechatPayPlatform;
import com.ftc.wechat.pay.pojo.WechatPayUnifiedOrder;
import com.ftc.wechat.pay.service.PayService;
import com.ftc.wechat.user.service.UserService;

@Controller  
@RequestMapping("/payAction")
@ResponseBody
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class PayAction extends BaseAction{

	@Resource
	private PayService payservice;
	
	@Resource
	private OrderService orderservice;
	
	@Resource
	UserService userservice;
	
	@RequestMapping(value = "getAllPlatform",method = RequestMethod.GET)
	public List<WechatPayPlatform> getAllPlatform(){
		return payservice.findAllPlatform();
	}
	
	@RequestMapping(value = "payByWechatPay",method = RequestMethod.GET)
	public void payByWechat(HttpServletRequest request,HttpServletResponse response,String orderno) throws IOException{
		WechatPayUnifiedOrder unifedorder = payservice.createWechatOrder(orderservice.findOrderByOrderNo(orderno), request, response,super.getSignUser(request).getUserWechatid());
		request.getSession().setAttribute(unifedorder.getOrderNo(), unifedorder);
	}
	
	@RequestMapping(value = "payByWechatPayCallback",method = RequestMethod.POST)
	public void payByWechatPayCallback(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		response.setContentType("text/xml;charset=utf-8");
		response.getWriter().write(payservice.wechatPayCallback(request, response));
	}
	
	@RequestMapping(value = "payByWechatPaySetUser",method = RequestMethod.GET)
	public void payByWechatPaySetUser(HttpServletRequest request,HttpServletResponse response,String wechatid){
		super.setSignUser(request, userservice.findUserByWechatId(wechatid));
	}
}
