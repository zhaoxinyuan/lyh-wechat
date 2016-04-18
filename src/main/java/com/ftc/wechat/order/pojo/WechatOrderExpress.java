package com.ftc.wechat.order.pojo;

public class WechatOrderExpress {
    private Integer expressId;

    private String expressNo;

    private String expressCompanyname;

    private Double expressAmount;

    public Integer getExpressId() {
        return expressId;
    }

    public void setExpressId(Integer expressId) {
        this.expressId = expressId;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo == null ? null : expressNo.trim();
    }

    public String getExpressCompanyname() {
        return expressCompanyname;
    }

    public void setExpressCompanyname(String expressCompanyname) {
        this.expressCompanyname = expressCompanyname == null ? null : expressCompanyname.trim();
    }

    public Double getExpressAmount() {
        return expressAmount;
    }

    public void setExpressAmount(Double expressAmount) {
        this.expressAmount = expressAmount;
    }
}