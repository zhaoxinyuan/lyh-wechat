package com.ftc.wechat.product.service;

import java.util.List;

import com.ftc.wechat.product.pojo.WechatProduct;

public interface ProductService {

	List<WechatProduct> findProduct(Integer pageNo,Integer pageSize);
	
	List<WechatProduct> findProductByCategory(Integer pageNo,Integer pageSize,Integer productCategoryid);
	
	WechatProduct findProduct(Integer productId);
}
