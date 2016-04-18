package com.ftc.wechat.order.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftc.wechat.base.config.WechatConfig;
import com.ftc.wechat.base.controller.BaseAction;
import com.ftc.wechat.base.entity.MyStatus;
import com.ftc.wechat.order.back.Orderdetail;
import com.ftc.wechat.order.pojo.WechatOrder;
import com.ftc.wechat.order.service.OrderService;
import com.ftc.wechat.user.service.UserAddressService;

@Controller  
@RequestMapping("/orderAction") 
@ResponseBody
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class OrderAction extends BaseAction{

	@Resource
	private OrderService orderservice;
	@Resource
	private UserAddressService addressservice;
	
	@RequestMapping(value = "createorder",method = RequestMethod.GET) 
	public void createOrder(HttpServletRequest request,HttpServletResponse response,Integer productid,String productspec) throws IOException{
		Orderdetail order = orderservice.createOrder(productid,productspec,super.getSignUser(request).getUserId());
		request.getSession().setAttribute(order.getOrderId(),order);
		response.sendRedirect(WechatConfig.localUrl + "orders/submitOrder.jsp?orderid=" + order.getOrderId());
	}
	
	@RequestMapping(value = "/getOrderInfo",method = RequestMethod.GET) 
	public Orderdetail getOrderInfo(HttpServletRequest request,HttpServletResponse response,String orderid){
		return (Orderdetail) request.getSession().getAttribute(orderid);
	}
	
	@RequestMapping(value = "/chenageAddress",method = RequestMethod.GET)
	public Orderdetail chenageAddress(HttpServletRequest request,HttpServletResponse response,String orderid,Integer addressid){
		Orderdetail order = (Orderdetail) request.getSession().getAttribute(orderid);
		order.setOrderAddress(addressservice.findAddressById(addressid,super.getSignUser(request).getUserId()));
		request.getSession().setAttribute(order.getOrderId(), order);
		return order;
	}
	
	@RequestMapping(value = "/submitOrder",method = RequestMethod.GET)
	public WechatOrder submitOrder(HttpServletRequest request,HttpServletResponse response,String orderid){
		WechatOrder order = orderservice.submitOrder((Orderdetail) request.getSession().getAttribute(orderid), super.getSignUser(request).getUserId());
		request.getSession().removeAttribute(orderid);	
		return order;
	}
	
	@RequestMapping(value = "/getOrders",method = RequestMethod.GET)
	public List<WechatOrder> getOrders(HttpServletRequest request,HttpServletResponse response,String statusCode){
		return orderservice.findOrderByUser(super.getSignUser(request).getUserId(),statusCode);
	}
	
	@RequestMapping(value = "/changeOrderStatus",method = RequestMethod.GET)
	public MyStatus changeOrderStatus(HttpServletRequest request,HttpServletResponse response,WechatOrder order){
		MyStatus mystatus = new MyStatus();
		if(orderservice.updateOrder(order) == 1){
			mystatus.setSuccess();
		}else{
			mystatus.setError("失败");
		}
		return mystatus;
	}
	
	@RequestMapping(value = "/shippednNtify",method = RequestMethod.GET)
	public String shippednNtify(HttpServletRequest request,HttpServletResponse response,String orderNo){
		return orderservice.shippednNtify(orderNo);
	}
	
	
	
	
}
