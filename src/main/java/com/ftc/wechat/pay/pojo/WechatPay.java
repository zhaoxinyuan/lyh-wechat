package com.ftc.wechat.pay.pojo;

public class WechatPay {
    private Integer payId;

    private Integer payOrderid;

    private String payOrderno;

    private Integer payPlatform;

    private Double payAmount;

    private String payDate;

    private String payPlatformTradeno;
    
    private Integer count;

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public Integer getPayOrderid() {
        return payOrderid;
    }

    public void setPayOrderid(Integer payOrderid) {
        this.payOrderid = payOrderid;
    }

    public String getPayOrderno() {
        return payOrderno;
    }

    public void setPayOrderno(String payOrderno) {
        this.payOrderno = payOrderno == null ? null : payOrderno.trim();
    }

    public Integer getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(Integer payPlatform) {
        this.payPlatform = payPlatform;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate == null ? null : payDate.trim();
    }

    public String getPayPlatformTradeno() {
        return payPlatformTradeno;
    }

    public void setPayPlatformTradeno(String payPlatformTradeno) {
        this.payPlatformTradeno = payPlatformTradeno == null ? null : payPlatformTradeno.trim();
    }

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
}