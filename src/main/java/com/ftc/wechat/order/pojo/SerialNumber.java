package com.ftc.wechat.order.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SerialNumber {

	private Integer serial;
	private String orderNo = "LYH";

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public String createOrderNo() {
		this.orderNo += new SimpleDateFormat("yyyyMMdd").format(new Date()) + (int)(Math.random()*10);
		for (int i = 0; i < 6 - serial.toString().length(); i++) {
			this.orderNo += "0";
		}
		return this.orderNo + this.serial;
	}
}
