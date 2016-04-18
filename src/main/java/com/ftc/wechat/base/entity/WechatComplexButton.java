package com.ftc.wechat.base.entity;

public class WechatComplexButton extends WechatButton {
	private WechatButton[] sub_button;

	public WechatButton[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(WechatButton[] sub_button) {
		this.sub_button = sub_button;
	}

}