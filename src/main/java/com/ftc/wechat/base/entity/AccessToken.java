package com.ftc.wechat.base.entity;

import java.util.Date;

public class AccessToken extends WechatErrorInfo{	
	private String access_token;
	
	private int expires_in;
	
	private Date access_getDate;
		
	public String getAccess_token() {
		return access_token;
	}
	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public Date getAccess_getDate() {
		return access_getDate;
	}
	public void setAccess_getDate(Date access_getDate) {
		this.access_getDate = access_getDate;
	}
	
	
}
