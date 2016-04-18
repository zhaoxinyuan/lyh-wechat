package com.ftc.wechat.base.util;

import com.ftc.wechat.base.config.WechatConfig;
import com.ftc.wechat.base.entity.SendMessageByText;
import com.google.gson.Gson;

public class SendMessageUtil {

	public static Gson gson = new Gson();
	
	//发送文本消息
	public static String sendMessage(SendMessageByText text){
		return HttpUtil.sendPost("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + WechatUtil.getAccessToken(WechatConfig.appId, WechatConfig.appSecret).getAccess_token(),gson.toJson(text), "json");
	}
}
