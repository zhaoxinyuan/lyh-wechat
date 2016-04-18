package com.ftc.wechat.order.service;

import java.util.List;

import com.ftc.wechat.order.back.Orderdetail;
import com.ftc.wechat.order.pojo.WechatOrder;

public interface OrderService {

	Orderdetail createOrder(Integer productId,String productSpec, Integer userid);
	
	WechatOrder submitOrder(Orderdetail order,Integer userId);
	
	List<WechatOrder> findOrderByUser(Integer userId,String statusCode);
	
	WechatOrder findOrderByOrderNo(String orderNo);
	
	int updateOrder(WechatOrder order);
	
	String shippednNtify(String orderNo);
	
	void AutoReceiving();
}
