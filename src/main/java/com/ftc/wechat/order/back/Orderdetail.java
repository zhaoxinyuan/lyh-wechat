package com.ftc.wechat.order.back;

import com.ftc.wechat.product.pojo.WechatProduct;
import com.ftc.wechat.user.pojo.WechatUserAddress;

public class Orderdetail {

	private String orderId = "";
	private String orderNo = "";
	private WechatUserAddress orderAddress = new WechatUserAddress();
	private WechatProduct orderProducts = new WechatProduct();
	private Double orderTotalAmount = 0D;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public WechatUserAddress getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(WechatUserAddress orderAddress) {
		this.orderAddress = orderAddress;
	}

	public WechatProduct getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(WechatProduct orderProducts) {
		this.orderProducts = orderProducts;
	}

	public Double getOrderTotalAmount() {
		return orderTotalAmount;
	}

	public void setOrderTotalAmount(Double orderTotalAmount) {
		this.orderTotalAmount = orderTotalAmount;
	}
}
