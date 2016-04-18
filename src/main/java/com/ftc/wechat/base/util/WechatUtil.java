package com.ftc.wechat.base.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ConnectException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ftc.wechat.base.config.WechatConfig;
import com.ftc.wechat.base.entity.AccessToken;
import com.ftc.wechat.base.entity.JsAPIticket;
import com.ftc.wechat.base.entity.WeChatJSConfig;
import com.ftc.wechat.base.entity.WechatErrorInfo;
import com.ftc.wechat.base.entity.WechatMenu;
import com.ftc.wechat.pay.wechatpay.WechatPayUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class WechatUtil {
	private static Logger log = LoggerFactory.getLogger(WechatUtil.class);

	public static String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN"; 
	
	public final static String access_token_url = "https://api.weixin.qq.com/cgi-bin/token";  
	
	public final static String ticket_url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";
	
	public static Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	
	public static AccessToken accessToken;
	
	public static JsAPIticket ticket;
	
	//获取   AccessToken
	public static AccessToken getAccessToken(String appid, String appsecret) {  
		if(WechatUtil.accessToken == null){
			return getNewAccessToken();
		}else if((new Date().getTime() - WechatUtil.accessToken.getAccess_getDate().getTime()) / (1000 * 60) > 118){
			return getNewAccessToken();
		}else{
			return accessToken;
		}
	} 
	
	@SuppressWarnings("unused")
	public static AccessToken getNewAccessToken(){
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
	    AccessToken accessToken =  gson.fromJson(HttpUtil.sendGet(access_token_url, "grant_type=client_credential&appid="+WechatConfig.appId+"&secret="+WechatConfig.appSecret), AccessToken.class);
		accessToken.setAccess_getDate(new Date());
	    if (null == accessToken) {  
	    	log.error("accessToken errcode:{} errmsg:{}", accessToken.getErrcode() , accessToken.getErrmsg());  
	    } 
	    WechatUtil.accessToken = accessToken;
	    return accessToken;
	}
	
	//获取JsAPIticket
	public static JsAPIticket getJsAPIticket() {  
		if(WechatUtil.ticket == null){
			return getNewTicket();
		}else if((new Date().getTime() - WechatUtil.ticket.getTicket_getDate().getTime()) / (1000 * 60) > 118){
			return getNewTicket();
		}else{
			return ticket;
		}
	}
	
	@SuppressWarnings("unused")
	public static JsAPIticket getNewTicket() {  
		AccessToken accessToken = WechatUtil.getAccessToken(WechatConfig.appId,WechatConfig.appSecret);
	    String requestUrl = ticket_url.replace("ACCESS_TOKEN", accessToken.getAccess_token());  
	    JsAPIticket ticket =  gson.fromJson(httpRequest(requestUrl, "GET", null), JsAPIticket.class);
	    ticket.setTicket_getDate(new Date());
	    if (null == ticket) {  
	    	log.error("accessToken errcode:{} errmsg:{}", ticket.getErrcode() , ticket.getErrmsg());  
	    }
	    WechatUtil.ticket = ticket;
	    return ticket;  
	}

	// SH1加密
	public static String encryptionBySH1(Map<String,Object> map,boolean encode,String charsetname,boolean toUpperCase){
		MessageDigest md = null;
		String tmpStr = null;
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			String sortStr = WechatPayUtil.createSign(map, encode);
			md = MessageDigest.getInstance("SHA-1");
			byte b[] = md.digest(sortStr.getBytes(charsetname));
			String strDigest = "";
			for (int i = 0; i < b.length; i++) {
				char[] tempArr = new char[2];
				tempArr[0] = hexDigits[(b[i] >>> 4) & 0X0F];
				tempArr[1] = hexDigits[b[i] & 0X0F];
				strDigest += new String(tempArr);
			}
			tmpStr = strDigest;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return toUpperCase ? tmpStr.toUpperCase() : tmpStr;
	}
	
	//获取微信JavaScript SDK 配置
	public static WeChatJSConfig getJSConfig(String url){
		WeChatJSConfig config = new WeChatJSConfig();
		config.setAppId(WechatConfig.appId);
		config.setNonceStr(RandomStringUtils.random(8, "123456789"));
		config.setTimestamp((System.currentTimeMillis() + "").substring(0,10));
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("noncestr", config.getNonceStr());
		map.put("jsapi_ticket", WechatUtil.getJsAPIticket().getTicket());
		map.put("timestamp", config.getTimestamp());
		map.put("url", url);
		
		config.setSignature(WechatUtil.encryptionBySH1(map,false,"utf-8", false));
		return config;
	}
	


	//创建菜单
	public static int createMenu(WechatMenu menu, String accessToken) {
		int result = 0;
		String url = menu_create_url.replace("ACCESS_TOKEN", accessToken);
		String jsonMenu = gson.toJson(menu);
		WechatErrorInfo error = gson.fromJson(httpRequest(url, "POST", jsonMenu),WechatErrorInfo.class );

		if (null != error) {
			if (0 != error.getErrcode()) {
				result = error.getErrcode();
				log.error("Menu errcode:{} errmsg:{}", error.getErrcode(), error.getErrmsg());
			}
		}

		return result;
	}
	

	public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
		StringBuffer buffer = new StringBuffer();
		try {
			
			TrustManager[] tm = { new MyX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());

			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();
			httpUrlConn.setSSLSocketFactory(ssf);

			httpUrlConn.setDoOutput(true);
			httpUrlConn.setDoInput(true);
			httpUrlConn.setUseCaches(false);

			httpUrlConn.setRequestMethod(requestMethod);

			if ("GET".equalsIgnoreCase(requestMethod))
				httpUrlConn.connect();

			if (null != outputStr) {
				OutputStream outputStream = httpUrlConn.getOutputStream();
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			httpUrlConn.disconnect();
			
		} catch (ConnectException ce) {
			log.error("Weixin server connection timed out.");
		} catch (Exception e) {
			log.error("https request error:{}", e);
		}
		return buffer.toString();
	}
	
	//判断是否是微信浏览器
    public static boolean isWechat(HttpServletRequest request) {
        String userAgent = request.getHeader("User-Agent");
        if (StringUtils.isNotBlank(userAgent)) {
            Pattern p = Pattern.compile("MicroMessenger/(\\d+).+");
            Matcher m = p.matcher(userAgent);
            String version = null;
            if (m.find()) {
                version = m.group(1);
            }
            return (null != version && NumberUtils.toInt(version) >= 5);
        }
        return false;
    }
    
    //获取用户ip
    public static String getIp(HttpServletRequest request) {
		if (request == null)
			return "";
		String ip = request.getHeader("X-Requested-For");
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("X-Forwarded-For");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
    
    public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
	}
}