package com.ftc.wechat.base.entity;

public class MyStatus {

	private Integer status;
	private String message;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setSuccess() {
		this.status = 0;
		this.message = "success";
	}

	public void setError(String errormsg) {
		this.status = -1;
		this.message = errormsg;
	}
}
