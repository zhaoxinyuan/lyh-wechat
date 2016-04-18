package com.ftc.wechat.user.pojo;

public class WechatUser {
	private Integer userId;

	private String userWechatid;

	private String userNickname;

	private String userMobile;

	private String userEmail;

	private String userHeadImgUrl;

	private String userSubscribeTime;
	
	private Integer userOrderNotPayNum;
	
	private Integer userOrderNotReceivedNum;
	
	private Integer userOrderReceivedNum;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserWechatid() {
		return userWechatid;
	}

	public void setUserWechatid(String userWechatid) {
		this.userWechatid = userWechatid == null ? null : userWechatid.trim();
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname == null ? null : userNickname.trim();
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile == null ? null : userMobile.trim();
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail == null ? null : userEmail.trim();
	}

	public String getUserHeadImgUrl() {
		return userHeadImgUrl;
	}

	public void setUserHeadImgUrl(String userHeadImgUrl) {
		this.userHeadImgUrl = userHeadImgUrl;
	}

	public String getUserSubscribeTime() {
		return userSubscribeTime;
	}

	public void setUserSubscribeTime(String userSubscribeTime) {
		this.userSubscribeTime = userSubscribeTime;
	}

	public Integer getUserOrderNotPayNum() {
		return userOrderNotPayNum;
	}

	public void setUserOrderNotPayNum(Integer userOrderNotPayNum) {
		this.userOrderNotPayNum = userOrderNotPayNum;
	}

	public Integer getUserOrderNotReceivedNum() {
		return userOrderNotReceivedNum;
	}

	public void setUserOrderNotReceivedNum(Integer userOrderNotReceivedNum) {
		this.userOrderNotReceivedNum = userOrderNotReceivedNum;
	}

	public Integer getUserOrderReceivedNum() {
		return userOrderReceivedNum;
	}

	public void setUserOrderReceivedNum(Integer userOrderReceivedNum) {
		this.userOrderReceivedNum = userOrderReceivedNum;
	}
}