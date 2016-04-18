package com.ftc.wechat.user.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ftc.wechat.user.dao.WechatUserAddressDao;
import com.ftc.wechat.user.pojo.WechatUserAddress;
import com.ftc.wechat.user.service.UserAddressService;

@Service("userAddressService")  
public class UserAddressServiceImpl implements UserAddressService {
	@Resource
	private WechatUserAddressDao addressdao;
	
	@Override
	public List<WechatUserAddress> findAllAddress(Integer userid) {
		return addressdao.selectByUserId(userid);
	}

	@Override
	public int saveAddress(WechatUserAddress address) {
		return addressdao.insert(address);
	}

	@Override
	public int updateAddress(WechatUserAddress address) {
		if(address.getAddressDefault() == 1){
			addressdao.updateDefaultAddress(address.setDefaultVal(address.getAddressUserid()));
		}
		return addressdao.updateByPrimaryKey(address);
	}

	@Override
	public int deleteAddress(int addressId) {
		return addressdao.deleteByPrimaryKey(addressId);
	}

	@Override
	public WechatUserAddress findAddressById(Integer addressId,Integer userid) {
		return  addressId == null ? addressdao.selectByUserId(userid).get(0) : addressdao.selectByPrimaryKey(addressId);
	}

}
