package com.ftc.wechat.pay.pojo;

public class WechatPayPlatform {
	private Integer platformId;

	private String platformName;

	private String platformCode;

	private String platformPayurl;

	public Integer getPlatformId() {
		return platformId;
	}

	public void setPlatformId(Integer platformId) {
		this.platformId = platformId;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName == null ? null : platformName.trim();
	}

	public String getPlatformCode() {
		return platformCode;
	}

	public void setPlatformCode(String platformCode) {
		this.platformCode = platformCode;
	}

	public String getPlatformPayurl() {
		return platformPayurl;
	}

	public void setPlatformPayurl(String platformPayurl) {
		this.platformPayurl = platformPayurl;
	}
}