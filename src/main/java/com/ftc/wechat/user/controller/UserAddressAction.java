package com.ftc.wechat.user.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftc.wechat.base.controller.BaseAction;
import com.ftc.wechat.base.entity.MyStatus;
import com.ftc.wechat.user.pojo.WechatUserAddress;
import com.ftc.wechat.user.service.UserAddressService;

@Controller  
@RequestMapping("/userAddressAction") 
@ResponseBody
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class UserAddressAction extends BaseAction{
	@Resource
	private UserAddressService addressvice;

	@RequestMapping(value = "/getAddressList",method = RequestMethod.GET) 
	public List<WechatUserAddress>  getAddressList(HttpServletRequest request,HttpServletResponse response){
		return addressvice.findAllAddress(super.getSignUser(request).getUserId());
	}

	@RequestMapping(value = "/getAddress",method = RequestMethod.GET) 
	public WechatUserAddress getAddress(HttpServletRequest request,HttpServletResponse response,Integer addressId){
		return addressvice.findAddressById(addressId,super.getSignUser(request).getUserId());
	}

	@RequestMapping(value = "/saveAddress",method = RequestMethod.GET)
	public MyStatus saveAddress(HttpServletRequest request,HttpServletResponse response,WechatUserAddress address){
		address.setAddressUserid(super.getSignUser(request).getUserId());
		Integer res = addressvice.saveAddress(address);
		MyStatus mystatus = new MyStatus();
		if(res == 1){
			mystatus.setSuccess();
		}else{
			mystatus.setError("添加失败");
		}
		return mystatus;
	}
	
	@RequestMapping(value = "/updateAddress",method = RequestMethod.GET)
	public MyStatus updateAddress(HttpServletRequest request,HttpServletResponse response,WechatUserAddress address){
		address.setAddressUserid(super.getSignUser(request).getUserId());
		Integer res = addressvice.updateAddress(address);
		MyStatus mystatus = new MyStatus();
		if(res == 1){
			mystatus.setSuccess();
		}else{
			mystatus.setError("修改失败");
		}
		return mystatus;
	}

	@RequestMapping(value = "/deleteAddress",method = RequestMethod.GET)
	public MyStatus deleteAddress(HttpServletRequest request,HttpServletResponse response,Integer addressId){
		Integer res = addressvice.deleteAddress(addressId);
		MyStatus mystatus = new MyStatus();
		if(res == 1){
			mystatus.setSuccess();
		}else{
			mystatus.setError("删除失败");
		}
		return mystatus;
	}
}
