package com.ftc.wechat.user.param;

public class UserAddress {
	private Integer addressId;

    private String addressProvincename;

    private String addressProvincecode;

    private String addressCityname;

    private String addressCitycode;

    private String addressCountyname;

    private String addressCountycode;

    private String addressStreet;

    private String addressName;

    private String addressMobile;

    private Integer addressDefault;

    private Integer addressUserid;
    
    private Integer addressPost;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressProvincename() {
        return addressProvincename;
    }

    public void setAddressProvincename(String addressProvincename) {
        this.addressProvincename = addressProvincename == null ? null : addressProvincename.trim();
    }

    public String getAddressProvincecode() {
        return addressProvincecode;
    }

    public void setAddressProvincecode(String addressProvincecode) {
        this.addressProvincecode = addressProvincecode == null ? null : addressProvincecode.trim();
    }

    public String getAddressCityname() {
        return addressCityname;
    }

    public void setAddressCityname(String addressCityname) {
        this.addressCityname = addressCityname == null ? null : addressCityname.trim();
    }

    public String getAddressCitycode() {
        return addressCitycode;
    }

    public void setAddressCitycode(String addressCitycode) {
        this.addressCitycode = addressCitycode == null ? null : addressCitycode.trim();
    }

    public String getAddressCountyname() {
        return addressCountyname;
    }

    public void setAddressCountyname(String addressCountyname) {
        this.addressCountyname = addressCountyname == null ? null : addressCountyname.trim();
    }

    public String getAddressCountycode() {
        return addressCountycode;
    }

    public void setAddressCountycode(String addressCountycode) {
        this.addressCountycode = addressCountycode == null ? null : addressCountycode.trim();
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet == null ? null : addressStreet.trim();
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName == null ? null : addressName.trim();
    }

    public String getAddressMobile() {
        return addressMobile;
    }

    public void setAddressMobile(String addressMobile) {
        this.addressMobile = addressMobile == null ? null : addressMobile.trim();
    }

    public Integer getAddressDefault() {
        return addressDefault;
    }

    public void setAddressDefault(Integer addressDefault) {
        this.addressDefault = addressDefault;
    }

    public Integer getAddressUserid() {
        return addressUserid;
    }

    public void setAddressUserid(Integer addressUserid) {
        this.addressUserid = addressUserid;
    }


	public Integer getAddressPost() {
		return addressPost;
	}

	public void setAddressPost(Integer addressPost) {
		this.addressPost = addressPost;
	}
	
}
