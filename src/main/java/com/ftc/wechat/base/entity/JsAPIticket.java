package com.ftc.wechat.base.entity;

import java.util.Date;

public class JsAPIticket extends WechatErrorInfo{	
	private String ticket;
	
	private int expires_in;
	
	private Date ticket_getDate;
		
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public int getExpires_in() {
		return expires_in;
	}
	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}
	public Date getTicket_getDate() {
		return ticket_getDate;
	}
	public void setTicket_getDate(Date ticket_getDate) {
		this.ticket_getDate = ticket_getDate;
	}
	
	
}
