package com.ftc.wechat.user.service;

import java.util.List;

import com.ftc.wechat.user.pojo.WechatUserAddress;

public interface UserAddressService {

	List<WechatUserAddress> findAllAddress(Integer userid);
	
	int saveAddress(WechatUserAddress address);
	
	int updateAddress(WechatUserAddress address);
	
	int deleteAddress(int addressId);
	
	WechatUserAddress findAddressById(Integer addressId,Integer userid);
}
