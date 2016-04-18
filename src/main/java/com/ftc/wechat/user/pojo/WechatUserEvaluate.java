package com.ftc.wechat.user.pojo;

public class WechatUserEvaluate {
    private Integer evaluateId;

    private Integer evaluateUserid;

    private String evaluateContent;

    private Integer evaluateStar;

    private String evaluateDate;

    private Integer evaluateProductid;

    public Integer getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(Integer evaluateId) {
        this.evaluateId = evaluateId;
    }

    public Integer getEvaluateUserid() {
        return evaluateUserid;
    }

    public void setEvaluateUserid(Integer evaluateUserid) {
        this.evaluateUserid = evaluateUserid;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent == null ? null : evaluateContent.trim();
    }

    public Integer getEvaluateStar() {
        return evaluateStar;
    }

    public void setEvaluateStar(Integer evaluateStar) {
        this.evaluateStar = evaluateStar;
    }

    public String getEvaluateDate() {
        return evaluateDate;
    }

    public void setEvaluateDate(String evaluateDate) {
        this.evaluateDate = evaluateDate == null ? null : evaluateDate.trim();
    }

    public Integer getEvaluateProductid() {
        return evaluateProductid;
    }

    public void setEvaluateProductid(Integer evaluateProductid) {
        this.evaluateProductid = evaluateProductid;
    }
}