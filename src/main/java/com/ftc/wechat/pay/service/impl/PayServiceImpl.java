package com.ftc.wechat.pay.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.ftc.wechat.base.config.WechatConfig;
import com.ftc.wechat.base.util.HttpUtil;
import com.ftc.wechat.base.util.MapToXmlUtil;
import com.ftc.wechat.base.util.WechatUtil;
import com.ftc.wechat.order.dao.WechatOrderDao;
import com.ftc.wechat.order.dao.WechatOrderStatusDao;
import com.ftc.wechat.order.pojo.WechatOrder;
import com.ftc.wechat.pay.dao.WechatPayDao;
import com.ftc.wechat.pay.dao.WechatPayPlatformDao;
import com.ftc.wechat.pay.pojo.WechatPay;
import com.ftc.wechat.pay.pojo.WechatPayPlatform;
import com.ftc.wechat.pay.pojo.WechatPayUnifiedOrder;
import com.ftc.wechat.pay.service.PayService;
import com.ftc.wechat.pay.wechatpay.WechatPayUtil;
import com.ftc.wechat.sys.dao.WechatSysPointsRuleDao;
import com.ftc.wechat.sys.pojo.WechatSysPointsRule;
import com.ftc.wechat.user.dao.WechatUserPointsDao;
import com.ftc.wechat.user.pojo.WechatUserPoints;

@Service("payService")
public class PayServiceImpl implements PayService {

	@Resource
	private WechatPayDao paydao;

	@Resource
	private WechatPayPlatformDao platformdao;
	
	@Resource
	private WechatOrderDao orderdao;
	
	@Resource
	private WechatOrderStatusDao statusdao;
	
	@Resource
	WechatSysPointsRuleDao pointsruledao;
	
	@Resource
	WechatUserPointsDao userpointsdao; 

	@Override
	public List<WechatPayPlatform> findAllPlatform() {
		return platformdao.selectAll();
	}
	
	@Override
	public WechatPayUnifiedOrder createWechatOrder(WechatOrder order,HttpServletRequest request, HttpServletResponse response,String wechatId) {
		WechatPayUnifiedOrder unifiedOrder = null;
		try {
			
			Map<String, Object> params = new HashMap<String, Object>();

			params.put("appid", WechatConfig.appId);
			params.put("mch_id", WechatConfig.wechatPayMchId);
			params.put("nonce_str",RandomStringUtils.random(8, "123456789"));
			params.put("body", order.getOrderProduct().getProductName());
			params.put("total_fee",  (int)(order.getOrderProductAmt() * 100));
			params.put("out_trade_no", order.getOrderNo());
			params.put("spbill_create_ip", WechatUtil.getIp(request));
			params.put("notify_url", WechatConfig.wechatPayNotifyUrl);
			params.put("trade_type", "JSAPI");
			params.put("openid", wechatId);
			params.put("sign", WechatPayUtil.signToMD5(WechatPayUtil.createSign(params, false)));
			
			Map<String,Object> result = MapToXmlUtil.xmltoMap(HttpUtil.sendPost("https://api.mch.weixin.qq.com/pay/unifiedorder",new String(MapToXmlUtil.maptoXml(params).getBytes("utf-8"),"utf-8"),"xml"));
			
			String timeStamp =  System.currentTimeMillis() + "";
			String nonceStr = RandomStringUtils.random(8, "123456789");
			
			Map<String, Object> payInfo = new HashMap<String, Object>();
			payInfo.put("appId", WechatConfig.appId);
			payInfo.put("timeStamp", timeStamp);
			payInfo.put("nonceStr",nonceStr);
			payInfo.put("package", "prepay_id=" + (String)result.get("prepay_id"));
			payInfo.put("signType", "MD5");
			
			unifiedOrder = new WechatPayUnifiedOrder();
			unifiedOrder.setOrderNo(order.getOrderNo());
			unifiedOrder.setAppid(WechatConfig.appId);
			unifiedOrder.setNonceStr(nonceStr);
			unifiedOrder.setPaySign(WechatPayUtil.signToMD5(WechatPayUtil.createSign(payInfo, false)));
			unifiedOrder.setPrepayId("prepay_id=" + (String)result.get("prepay_id"));
			unifiedOrder.setSignType("MD5");
			unifiedOrder.setTimeStamp(timeStamp);
			
			return unifiedOrder;

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String wechatPayCallback(HttpServletRequest request,HttpServletResponse response) {
		WechatPay pay = null;
		try {
			StringBuffer sb = new StringBuffer();
			BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			
			Map<String, Object> params = MapToXmlUtil.xmltoMap(sb.toString());
			
			if(params.get("return_code").toString().equals("SUCCESS") && params.get("result_code").toString().equals("SUCCESS")){
				WechatOrder order = orderdao.selectByOrderNo(params.get("out_trade_no").toString());
				order.setOrderStatusid(statusdao.selectByCode("status_03").getStatusId());
				orderdao.updateByPrimaryKeySelective(order);
				
				pay = new WechatPay();
				pay.setPayAmount(Double.parseDouble(params.get("total_fee").toString()));
				pay.setPayDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
				pay.setPayOrderid(order.getOrderId());
				pay.setPayOrderno(params.get("out_trade_no").toString());
				pay.setPayPlatform(platformdao.selectByPlatformCode("wechatpay").getPlatformId());
				pay.setPayPlatformTradeno(params.get("transaction_id").toString());
				if(paydao.selectByOrderNo(params.get("out_trade_no").toString()) == null){
					paydao.insertSelective(pay);
					
					WechatUserPoints points = new WechatUserPoints();
					points.setPointsDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
					points.setPointsUserid(order.getOrderUserid());
					
					for (WechatSysPointsRule rule : pointsruledao.selectAll()) {
						if(rule.getRuleDict().getDictCode().equals("dict_001")){
							points.setPointsDetail(order.getOrderProductAmt() * rule.getRuleValue());
							points.setPointsFrom("零元汇订单");
							userpointsdao.insertSelective(points);
						}else if(rule.getRuleDict().getDictCode().equals("dict_002")){
							points.setPointsDetail(rule.getRuleValue());
							points.setPointsFrom("零元汇订单");
							userpointsdao.insertSelective(points);
						}else if(rule.getRuleDict().getDictCode().equals("dict_003")){
							//TODO 
						}
					}
				}
				
				return createWechatPayCallbackXml("SUCCESS", "OK");
				//return "SUCCESS";
			}else{
				return createWechatPayCallbackXml("FAIL", "交易失败");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String createWechatPayCallbackXml(String returnCode,String returnMsg){
		return "<xml><return_code><![CDATA[" + returnCode + "]]></return_code><return_msg><![CDATA[" + returnMsg + "]]></return_msg></xml>";
	}
}
