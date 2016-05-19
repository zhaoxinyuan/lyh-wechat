package com.ftc.wechat.roll.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.ftc.wechat.order.pojo.WechatOrder;
import com.ftc.wechat.order.service.OrderService;
import com.ftc.wechat.roll.pojo.WechatRollNumber;
import com.ftc.wechat.roll.pojo.WechatRollResult;
import com.ftc.wechat.roll.service.RollService;

@Controller  
@RequestMapping("/rollAction")
@ResponseBody
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class RollAction extends BaseAction{
	@Resource
	private RollService rollService;
	
	@Resource
	private OrderService orderService;
	
	
	@RequestMapping(value = "rollProduct",method = RequestMethod.GET) 
	public MyStatus rollProduct(HttpServletRequest request,HttpServletResponse response,WechatRollResult result){
		result.setResUserid(super.getSignUser(request).getUserId());
		result.setResDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		WechatOrder order = orderService.getLastOrder(super.getSignUser(request).getUserId());
		result.setResOrderid(order.getOrderId());
		rollService.addRollProduct(result);
		MyStatus status = new MyStatus();
		status.setSuccess();
		return status;
	}
	
	@RequestMapping(value = "getRollNumber",method = RequestMethod.GET) 
	public MyStatus getRollNumber(HttpServletRequest request,HttpServletResponse response){
		MyStatus status = new MyStatus();
		WechatRollNumber number = rollService.getRollNumberCount(super.getSignUser(request).getUserId());
		if(number == null || number.getNumberAmt() <= 0){
			status.setError("您的抽奖次数已用完！");
			status.setStatus(-1);
		}else{
			status.setSuccess();
		}
		
		return status;
	}
	
}
