package com.ftc.wechat.roll.pojo;

public class WechatRollResult {
    private Integer resId;

    private String resDate;

    private String resProductname;

    private Integer resUserid;

    private Integer resOrderid;

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public String getResDate() {
        return resDate;
    }

    public void setResDate(String resDate) {
        this.resDate = resDate == null ? null : resDate.trim();
    }

    public String getResProductname() {
        return resProductname;
    }

    public void setResProductname(String resProductname) {
        this.resProductname = resProductname == null ? null : resProductname.trim();
    }

    public Integer getResUserid() {
        return resUserid;
    }

    public void setResUserid(Integer resUserid) {
        this.resUserid = resUserid;
    }

    public Integer getResOrderid() {
        return resOrderid;
    }

    public void setResOrderid(Integer resOrderid) {
        this.resOrderid = resOrderid;
    }
}