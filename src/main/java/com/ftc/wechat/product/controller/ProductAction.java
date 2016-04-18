package com.ftc.wechat.product.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftc.wechat.product.controller.param.ProductSerachParam;
import com.ftc.wechat.product.pojo.WechatProduct;
import com.ftc.wechat.product.service.ProductService;

@Controller  
@RequestMapping("/productAction")
@ResponseBody
@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ProductAction {
	@Resource
	private ProductService productservice;
	
	
	@RequestMapping(value = "getProducts",method = RequestMethod.GET) 
	public List<WechatProduct> getProducts(HttpServletRequest request,HttpServletResponse response,ProductSerachParam searchParam){
		return productservice.findProduct(searchParam.getPageNo(),searchParam.getPageSize());
	}
	
	@RequestMapping(value = "getProduct",method = RequestMethod.GET) 
	public WechatProduct getProduct(HttpServletRequest request,HttpServletResponse response,Integer productId){
		return productservice.findProduct(productId);
	}
	
}
