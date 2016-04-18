package com.ftc.wechat.pay.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftc.wechat.order.pojo.WechatOrder;
import com.ftc.wechat.pay.pojo.WechatPayPlatform;
import com.ftc.wechat.pay.pojo.WechatPayUnifiedOrder;

public interface PayService {
	
	public List<WechatPayPlatform> findAllPlatform();
	
	public WechatPayUnifiedOrder createWechatOrder(WechatOrder order,HttpServletRequest request,HttpServletResponse response,String wechatId);

	public String wechatPayCallback(HttpServletRequest request,HttpServletResponse response);
}
