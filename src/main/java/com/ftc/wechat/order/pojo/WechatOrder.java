package com.ftc.wechat.order.pojo;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.ftc.wechat.product.pojo.WechatProduct;
import com.ftc.wechat.user.pojo.WechatUserAddress;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class WechatOrder {
	private Integer orderId;

	private String orderNo;

	private Integer orderUserid;

	private String orderUserWechatid;

	private Integer orderProductid;

	private String orderProductName;
	
	private String orderProductSpec;

	private WechatProduct orderProduct;

	private Integer orderProductQty;

	private Double orderProductAmt;

	private String orderDate;

	private Integer orderAddressid;

	private WechatUserAddress orderAddress;

	private String orderAddressProvince;

	private String orderAddressCity;

	private String orderAddressCounty;

	private String orderAddressStreet;

	private String orderAddressName;

	private String orderAddressMobile;

	private String orderStatusCode;

	private WechatOrderStatus orderStatus;

	private Integer orderStatusid;

	private Integer orderPayid;

	private Integer orderExpressid;

	private WechatOrderExpress orderExpress;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getOrderUserid() {
		return orderUserid;
	}

	public void setOrderUserid(Integer orderUserid) {
		this.orderUserid = orderUserid;
	}

	public String getOrderUserWechatid() {
		return orderUserWechatid;
	}

	public void setOrderUserWechatid(String orderUserWechatid) {
		this.orderUserWechatid = orderUserWechatid;
	}

	public Integer getOrderProductid() {
		return orderProductid;
	}

	public void setOrderProductid(Integer orderProductid) {
		this.orderProductid = orderProductid;
	}

	public String getOrderProductName() {
		return orderProductName;
	}

	public void setOrderProductName(String orderProductName) {
		this.orderProductName = orderProductName;
	}
	
	public String getOrderProductSpec() {
		return orderProductSpec;
	}

	public void setOrderProductSpec(String orderProductSpec) {
		this.orderProductSpec = orderProductSpec;
	}

	public WechatProduct getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(WechatProduct orderProduct) {
		this.orderProduct = orderProduct;
	}

	public Integer getOrderProductQty() {
		return orderProductQty;
	}

	public void setOrderProductQty(Integer orderProductQty) {
		this.orderProductQty = orderProductQty;
	}

	public Double getOrderProductAmt() {
		return orderProductAmt;
	}

	public void setOrderProductAmt(Double orderProductAmt) {
		this.orderProductAmt = orderProductAmt;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getOrderAddressid() {
		return orderAddressid;
	}

	public void setOrderAddressid(Integer orderAddressid) {
		this.orderAddressid = orderAddressid;
	}

	public WechatUserAddress getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(WechatUserAddress orderAddress) {
		this.orderAddress = orderAddress;
	}

	public String getOrderAddressProvince() {
		return orderAddressProvince;
	}

	public void setOrderAddressProvince(String orderAddressProvince) {
		this.orderAddressProvince = orderAddressProvince;
	}

	public String getOrderAddressCity() {
		return orderAddressCity;
	}

	public void setOrderAddressCity(String orderAddressCity) {
		this.orderAddressCity = orderAddressCity;
	}

	public String getOrderAddressCounty() {
		return orderAddressCounty;
	}

	public void setOrderAddressCounty(String orderAddressCounty) {
		this.orderAddressCounty = orderAddressCounty;
	}

	public String getOrderAddressStreet() {
		return orderAddressStreet;
	}

	public void setOrderAddressStreet(String orderAddressStreet) {
		this.orderAddressStreet = orderAddressStreet;
	}

	public String getOrderAddressName() {
		return orderAddressName;
	}

	public void setOrderAddressName(String orderAddressName) {
		this.orderAddressName = orderAddressName;
	}

	public String getOrderAddressMobile() {
		return orderAddressMobile;
	}

	public void setOrderAddressMobile(String orderAddressMobile) {
		this.orderAddressMobile = orderAddressMobile;
	}

	public String getOrderStatusCode() {
		return orderStatusCode;
	}

	public void setOrderStatusCode(String orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}

	public WechatOrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(WechatOrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Integer getOrderStatusid() {
		return orderStatusid;
	}

	public void setOrderStatusid(Integer orderStatusid) {
		this.orderStatusid = orderStatusid;
	}

	public Integer getOrderPayid() {
		return orderPayid;
	}

	public void setOrderPayid(Integer orderPayid) {
		this.orderPayid = orderPayid;
	}

	public Integer getOrderExpressid() {
		return orderExpressid;
	}

	public void setOrderExpressid(Integer orderExpressid) {
		this.orderExpressid = orderExpressid;
	}

	public WechatOrderExpress getOrderExpress() {
		return orderExpress;
	}

	public void setOrderExpress(WechatOrderExpress orderExpress) {
		this.orderExpress = orderExpress;
	}

	public void setRedundancy() {
		this.orderProductid = this.orderProduct.getProductId();
		this.orderProductName = this.orderProduct.getProductName();

		this.orderAddressid = this.orderAddress.getAddressId();
		this.orderAddressProvince = this.orderAddress.getAddressProvincename();
		this.orderAddressCity = this.orderAddress.getAddressCityname();
		this.orderAddressCounty = this.orderAddress.getAddressCountyname();
		this.orderAddressName = this.orderAddress.getAddressName();
		this.orderAddressMobile = this.orderAddress.getAddressMobile();
	}

}