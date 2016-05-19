package com.ftc.wechat.roll.pojo;

public class WechatRollNumber {
    private Integer numberId;

    private String numberFrom;

    private Integer numberUserid;

    private Integer numberCount;
    
    private Integer numberAmt;

    public Integer getNumberId() {
        return numberId;
    }

    public void setNumberId(Integer numberId) {
        this.numberId = numberId;
    }

    public String getNumberFrom() {
        return numberFrom;
    }

    public void setNumberFrom(String numberFrom) {
        this.numberFrom = numberFrom == null ? null : numberFrom.trim();
    }

    public Integer getNumberUserid() {
        return numberUserid;
    }

    public void setNumberUserid(Integer numberUserid) {
        this.numberUserid = numberUserid;
    }

    public Integer getNumberCount() {
        return numberCount;
    }

    public void setNumberCount(Integer numberCount) {
        this.numberCount = numberCount;
    }

	public Integer getNumberAmt() {
		return numberAmt;
	}

	public void setNumberAmt(Integer numberAmt) {
		this.numberAmt = numberAmt;
	}
    
    
}