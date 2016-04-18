package com.ftc.wechat.user.pojo;

public class WechatUserPoints {
    private Integer pointsId;

    private String pointsFrom;

    private String pointsDate;

    private Double pointsDetail;

    private Integer pointsUserid;
    
    private Double pointsAmount;

    public Integer getPointsId() {
        return pointsId;
    }

    public void setPointsId(Integer pointsId) {
        this.pointsId = pointsId;
    }

    public String getPointsFrom() {
        return pointsFrom;
    }

    public void setPointsFrom(String pointsFrom) {
        this.pointsFrom = pointsFrom == null ? null : pointsFrom.trim();
    }

    public String getPointsDate() {
        return pointsDate;
    }

    public void setPointsDate(String pointsDate) {
        this.pointsDate = pointsDate == null ? null : pointsDate.trim();
    }

    public Double getPointsDetail() {
        return pointsDetail;
    }

    public void setPointsDetail(Double pointsDetail) {
        this.pointsDetail = pointsDetail;
    }

    public Integer getPointsUserid() {
        return pointsUserid;
    }

    public void setPointsUserid(Integer pointsUserid) {
        this.pointsUserid = pointsUserid;
    }

	public Double getPointsAmount() {
		return pointsAmount;
	}

	public void setPointsAmount(Double pointsAmount) {
		this.pointsAmount = pointsAmount;
	}
    
    
}