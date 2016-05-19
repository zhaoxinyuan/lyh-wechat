package com.ftc.wechat.base.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ftc.wechat.base.config.WechatConfig;
import com.ftc.wechat.base.entity.AccessToken;
import com.ftc.wechat.base.util.WechatUtil;
import com.ftc.wechat.user.pojo.WechatUser;
import com.ftc.wechat.user.service.UserService;
import com.google.gson.Gson;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@Controller
@RequestMapping("/forwardAction")
public class ForwardAction {
	private static Logger log = LoggerFactory.getLogger(ForwardAction.class);
	
	@Resource
	UserService userservice;
	

	@RequestMapping(value = "forwardRequest", method = RequestMethod.GET)
	public void forwardRequest(HttpServletRequest request,
			HttpServletResponse resp, String code,String path) throws ServletException, IOException {
		String wechatId = null;

		if (!code.equals("") && code != null) {
			wechatId = getOpenId(code);
			if (wechatId != null && !wechatId.equals("")) {
				request.getSession().setAttribute("wechatId", wechatId);
				
				WechatUser user = userservice.findUserByWechatId(wechatId);
				if(user == null){
					user = getSignUserInfo(wechatId,new WechatUser(),resp);
					if(user != null){
						user.setUserWechatid(wechatId);
						userservice.saveUser(user);
						user = userservice.findUserByWechatId(wechatId);
						request.getSession().setAttribute("signUser", user);
						log.error("wechatId:{} ", wechatId);
						resp.sendRedirect(WechatConfig.localUrl + path);
					}else{
						System.out.println("未关注该公众号,跳转到关注页面");
						resp.sendRedirect("http://mp.weixin.qq.com/s?__biz=MzA3ODMzMDc1MQ==&mid=401626688&idx=1&sn=400d52d33f9f97e132548762c8027dab&scene=0&previewkey=YyKiz7h4aifQX9zQTANiL8NS9bJajjJKzz%2F0By7ITJA%3D#wechat_redirect");
					}
				}else{
					request.getSession().setAttribute("signUser", user);
					log.error("wechatId:{} ", wechatId);
					resp.sendRedirect(WechatConfig.localUrl + path);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public String getOpenId(String code) {
		StringBuilder url = new StringBuilder();
		url.append("https://api.weixin.qq.com/sns/oauth2/access_token?");
		url.append("appid=" + WechatConfig.appId);
		url.append("&secret=").append(WechatConfig.appSecret);
		url.append("&code=").append(code);
		url.append("&grant_type=authorization_code");

		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url.toString());
		Gson gs = new Gson();
		String jsonStr = null;
		Map<String, Object> rsMap = null;
		try {

			HttpResponse response = httpClient.execute(httpget);

			// System.out.println(response.getStatusLine());

			HttpEntity entity = response.getEntity();

			if (entity != null) {
				jsonStr = EntityUtils.toString(entity);
			}
			rsMap = gs.fromJson(jsonStr, Map.class);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return (String) rsMap.get("openid");
	}

	@SuppressWarnings("unchecked")
	public WechatUser getSignUserInfo(String wechatid, WechatUser user,HttpServletResponse resp) {
		AccessToken at = WechatUtil.getAccessToken(WechatConfig.appId,
				WechatConfig.appSecret);
		log.error("AccessToken:{} ", at.getAccess_getDate());
		if (null != at) {
			StringBuilder url = new StringBuilder();
			url.append("https://api.weixin.qq.com/cgi-bin/user/info?");
			url.append("access_token=" + at.getAccess_token());
			url.append("&openid=" + wechatid);
			url.append("&lang=zh_CN");

			String charset = "UTF-8";  
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet httpget = new HttpGet(url.toString());
			 
			Gson gs = new Gson();
			String jsonStr = null;
			Map<String, Object> rsMap = null;
			try {

				HttpResponse response = httpClient.execute(httpget);
				
				// System.out.println(response.getStatusLine());

				HttpEntity entity = response.getEntity();
				charset = getContentCharSet(entity);  
				
				if (entity != null) {
					jsonStr = EntityUtils.toString(entity,charset);
				}
				rsMap = gs.fromJson(jsonStr, Map.class);
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				httpClient.getConnectionManager().shutdown();
			}
			System.out.println(rsMap);
			
			log.error("userinfo:{} ", rsMap);
			
			if(rsMap.get("subscribe") == null){
				try {
					resp.sendRedirect("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80bec67da02b4517&redirect_uri=http%3A%2F%2Fwww.lyhui.cn%2FWeChat%2FforwardAction%2FforwardRequest%3Fpath%3Dhome%2Findex.jsp&response_type=code&scope=snsapi_userinfo&state=1&connect_redirect=1#wechat_redirect");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(rsMap.get("subscribe").toString().equals("1.0")){
				user.setUserHeadImgUrl((String)rsMap.get("headimgurl"));
				user.setUserNickname((String)rsMap.get("nickname"));
				user.setUserSubscribeTime(new SimpleDateFormat("yyyy-MM-dd").format(new Date(Math.round((double)rsMap.get("subscribe_time") * 1000L))));
				return user;
			}
		}
		return null;
	}
	
	public static String getContentCharSet(final HttpEntity entity)   
	        throws ParseException {   
	   
	        if (entity == null) {   
	            throw new IllegalArgumentException("HTTP entity may not be null");   
	        }   
	        String charset = null;   
	        if (entity.getContentType() != null) {    
	            HeaderElement values[] = entity.getContentType().getElements();   
	            if (values.length > 0) {   
	                NameValuePair param = values[0].getParameterByName("charset" );   
	                if (param != null) {   
	                    charset = param.getValue();   
	                }   
	            }   
	        }   
	         
	        if(StringUtils.isEmpty(charset)){  
	            charset = "UTF-8";  
	        }  
	        return charset;   
	    }
}


