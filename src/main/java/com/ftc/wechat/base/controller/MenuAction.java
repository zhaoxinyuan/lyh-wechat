package com.ftc.wechat.base.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ServletContextAware;

import com.ftc.wechat.base.config.WechatConfig;
import com.ftc.wechat.base.entity.AccessToken;
import com.ftc.wechat.base.entity.WechatButton;
import com.ftc.wechat.base.entity.WechatComplexButton;
import com.ftc.wechat.base.entity.WechatMenu;
import com.ftc.wechat.base.entity.WechatViewButton;
import com.ftc.wechat.base.util.WechatUtil;

public class MenuAction implements ServletContextAware {

	@Autowired  
	private  HttpServletRequest request; 
	
	public void setServletContext(ServletContext ctx) {
		WechatConfig.init();
		
		if (WechatConfig.model.equals("0")) {
			System.out.println("is debug model can not create menu");
			return;
		}

		AccessToken at = WechatUtil.getAccessToken(WechatConfig.appId,
				WechatConfig.appSecret);

		if (null != at) {
			int result;
			try {
				result = WechatUtil.createMenu(getMenu(), at.getAccess_token());
				if (0 == result)
					System.out.println("create menu success");
				else
					System.out.println("create menu error :" + result);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	private static WechatMenu getMenu() throws UnsupportedEncodingException {
		
		WechatViewButton btn11 = new WechatViewButton();
		btn11.setName("商城");
		btn11.setType("view"); 
		btn11.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WechatConfig.appId+"&redirect_uri="+(URLEncoder.encode(WechatConfig.localUrl + "forwardAction/forwardRequest?path=home/index.jsp", "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
		//btn11.setUrl(WechatConfig.localUrl+"home/index.jsp");
		
		WechatComplexButton mainBtn1 = new WechatComplexButton();
		mainBtn1.setName("零元汇");
		mainBtn1.setSub_button(new WechatButton[] { btn11});
		
  
		WechatMenu menu = new WechatMenu();
		menu.setButton(new WechatButton[] { mainBtn1});

		return menu;
	}
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd008dfb56a367175&redirect_uri="+(URLEncoder.encode("http://www.zhaoxinzhe.com/WeChat/forwardAction/forwardRequest?path=home/index.html", "utf-8"))+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
	}

}
