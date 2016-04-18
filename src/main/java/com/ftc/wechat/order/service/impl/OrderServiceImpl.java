package com.ftc.wechat.order.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ftc.wechat.base.entity.SendMessageByText;
import com.ftc.wechat.base.entity.Text;
import com.ftc.wechat.base.util.SendMessageUtil;
import com.ftc.wechat.order.back.Orderdetail;
import com.ftc.wechat.order.dao.WechatOrderDao;
import com.ftc.wechat.order.dao.WechatOrderStatusDao;
import com.ftc.wechat.order.pojo.SerialNumber;
import com.ftc.wechat.order.pojo.WechatOrder;
import com.ftc.wechat.order.service.OrderService;
import com.ftc.wechat.product.dao.WechatProductDao;
import com.ftc.wechat.product.pojo.WechatProduct;
import com.ftc.wechat.user.dao.WechatUserAddressDao;
import com.ftc.wechat.user.pojo.WechatUserAddress;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Resource
	private WechatOrderDao orderdao;
	@Resource
	private WechatProductDao productdao;
	@Resource
	private WechatUserAddressDao addressdao;
	@Resource
	private WechatOrderStatusDao statusdao;

	@Override
	public Orderdetail createOrder(Integer productId,String productSpec, Integer userid) {
		UUID orderid = UUID.randomUUID();
		Orderdetail order = new Orderdetail();
		order.setOrderId(orderid.toString());
		order.setOrderAddress(getAddress(addressdao.selectByUserId(userid)));
		WechatProduct product = productdao.selectByPrimaryKey(productId);
		product.setQty(1);
		product.setAmount(product.getAmount());
		product.setProductSpec(productSpec);
		order.setOrderProducts(product);
		order.setOrderTotalAmount(product.getAmount());
		return order;
	}
	
	public WechatUserAddress getAddress(List<WechatUserAddress> address){
		if (address == null || address.size() == 0) {
			return new WechatUserAddress();
		}else{
			for (WechatUserAddress item : address) {
				if(item.getAddressDefault() == 1){
					return item;
				}else{
					return address.get(0);
				}
			}
			return new WechatUserAddress();
		}
	}

	@Override
	public WechatOrder submitOrder(Orderdetail order,Integer userId) {
		WechatOrder wcorder = new WechatOrder();
		SerialNumber serialNumber = orderdao.selectSerial();
		
		wcorder.setOrderNo(serialNumber.createOrderNo());
		wcorder.setOrderAddress(order.getOrderAddress());
		wcorder.setOrderAddressProvince(order.getOrderAddress().getAddressProvincename());
		wcorder.setOrderAddressCity(order.getOrderAddress().getAddressCityname());
		wcorder.setOrderAddressCounty(order.getOrderAddress().getAddressCountyname());
		wcorder.setOrderAddressStreet(order.getOrderAddress().getAddressStreet());
		wcorder.setOrderAddressName(order.getOrderAddress().getAddressName());
		wcorder.setOrderAddressMobile(order.getOrderAddress().getAddressMobile());
		wcorder.setOrderProduct(order.getOrderProducts());
		wcorder.setOrderProductQty(order.getOrderProducts().getQty());
		wcorder.setOrderProductAmt(order.getOrderProducts().getAmount());
		wcorder.setOrderProductName(order.getOrderProducts().getProductName());
		wcorder.setOrderUserid(userId);
		wcorder.setOrderDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		wcorder.setOrderStatusid(statusdao.selectByCode("status_01").getStatusId());
		wcorder.setRedundancy();
		wcorder.setOrderProductSpec(order.getOrderProducts().getProductSpec());
		orderdao.insertSelective(wcorder);
		return wcorder;
	}

	@Override
	public List<WechatOrder> findOrderByUser(Integer userId,String statusCode) {
		WechatOrder order = new WechatOrder();
		order.setOrderUserid(userId);
		order.setOrderStatusCode(statusCode.equals("status_all") ? null : statusCode);
		return orderdao.selectOrderByUser(order);
	}

	@Override
	public int updateOrder(WechatOrder order) {
		order.setOrderStatusid(statusdao.selectByCode(order.getOrderStatusCode()).getStatusId());
		return orderdao.updateByPrimaryKeySelective(order);
	}

	@Override
	public WechatOrder findOrderByOrderNo(String orderNo) {
		return orderdao.selectByOrderNo(orderNo);
	}

	@Override
	public String shippednNtify(String orderNo) {
		WechatOrder order = orderdao.selectByOrderNo(orderNo);
		SendMessageByText text = new SendMessageByText();
		text.setMsgtype("text");
		text.setTouser(order.getOrderUserWechatid());
		text.setText(new Text("您的订单：" + order.getOrderNo() + " 已发货\n快递单号：" + order.getOrderExpress().getExpressNo() + " " + order.getOrderExpress().getExpressCompanyname()));
		return SendMessageUtil.sendMessage(text);
	}

	@Override
	public void AutoReceiving() {
		List<WechatOrder> list = orderdao.overtimeOrder();
		Integer statusid = statusdao.selectByCode("status_05").getStatusId();
		for (WechatOrder order : list) {
			order.setOrderStatusid(statusid);
			orderdao.updateByPrimaryKeySelective(order);
		}
		
	}


}
