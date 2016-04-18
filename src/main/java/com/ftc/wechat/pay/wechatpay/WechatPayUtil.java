package com.ftc.wechat.pay.wechatpay;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;

import com.ftc.wechat.base.config.WechatConfig;

public class WechatPayUtil {

	/**
	 * 构造签名
	 * 
	 * @param params
	 * @param encode
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public static String createSign(Map<String, Object> params, boolean encode)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		Set<String> keysSet = params.keySet();
		Object[] keys = keysSet.toArray();
		Arrays.sort(keys);
		StringBuffer temp = new StringBuffer();
		boolean first = true;
		for (Object key : keys) {
			if (first) {
				first = false;
			} else {
				temp.append("&");
			}
			temp.append(key).append("=");
			Object value = params.get(key);
			String valueString = "";
			if (null != value) {
				valueString = value.toString();
			}
			if (encode) {
				temp.append(URLEncoder.encode(valueString, "UTF-8"));
			} else {
				temp.append(valueString);
			}
		}

		return temp.toString();
	}

	/**
	 * MD5加密签名
	 * 
	 * @param sign
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */

	public static String signToMD5(String sign)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		//sign += "&key=HYvwbPGZqXrZOQpQ3xsW8vajFviKHkbI";
		sign += "&key=" + WechatConfig.wechatPayPaternerKey;
		return MD5Encode(sign, "utf-8").toUpperCase();
	}

	/**
	 * 支付回调校验签名
	 * 
	 * @param timestamp
	 * @param noncestr
	 * @param openid
	 * @param issubscribe
	 * @param appsignature
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean verifySign(long timestamp, String noncestr,
			String openid, int issubscribe, String appsignature)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		Map<String, Object> paras = new HashMap<String, Object>();
		paras.put("appid", WechatConfig.appId);
		paras.put("timestamp", String.valueOf(timestamp));
		paras.put("noncestr", noncestr);
		paras.put("openid", openid);
		paras.put("issubscribe", String.valueOf(issubscribe));
		// appid、appkey、productid、timestamp、noncestr、openid、issubscribe
		String string1 = createSign(paras, false);
		String paySign = DigestUtils.sha1Hex(string1);
		return paySign.equalsIgnoreCase(appsignature);
	}

	

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		String hexDigits[] = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte b[] = md.digest(resultString.getBytes(charsetname));
		    StringBuffer resultSb = new StringBuffer();
			for (int i = 0; i < b.length; i++){
				int n = b[i];
				if (n < 0){
					n += 256;
				}
				resultSb.append(hexDigits[n / 16] + hexDigits[n % 16]);
			}
			resultString = resultSb.toString();	
					
		} catch (Exception exception) {
		}
		return resultString;
	}
}
