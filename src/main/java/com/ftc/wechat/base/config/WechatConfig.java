package com.ftc.wechat.base.config;

import java.util.Locale;
import java.util.ResourceBundle;

public class WechatConfig {
	public static String appId = "";
	public static String appSecret = "";
	public static String localUrl = "";
	public static String model = "";
	public static String token = "";

	public static String wechatPayMchId = "";
	public static String wechatPayPaternerKey = "";
	public static String wechatPayNotifyUrl = "";
	
	public static String alipayPartner = "";
	public static String alipaySellerId = "";
	public static String alipayPrivateKey = "";
	public static String alipayPublicKey = "";
	public static String alipayInputCharset = "";
	public static String alipaySignType = "";
	
	public static void init() {
		Locale locale = new Locale("zh", "CN");
		java.util.ResourceBundle rb = ResourceBundle.getBundle("wechat", locale);

		appId = rb.getString("appId");
		appSecret = rb.getString("appSecret");
		localUrl = rb.getString("localUrl");
		model = rb.getString("model");
		token = rb.getString("token");
		
		wechatPayMchId = rb.getString("wechatpay_mchId");
		wechatPayPaternerKey = rb.getString("wechatpay_paternerkey");
		wechatPayNotifyUrl = rb.getString("wechatpay_notifyUrl");
		
		alipayPartner = rb.getString("alipay_partner");
		alipaySellerId = rb.getString("alipay_seller_id");
		alipayPrivateKey = rb.getString("alipay_private_key");
		alipayPublicKey = rb.getString("alipay_ali_public_key");
		alipayInputCharset = rb.getString("alipay_input_charset");
		alipaySignType = rb.getString("alipay_sign_type");
	}
}
