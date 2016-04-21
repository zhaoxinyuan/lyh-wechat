package com.ftc.wechat.product.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ftc.wechat.product.dao.WechatProductDao;
import com.ftc.wechat.product.pojo.WechatProduct;
import com.ftc.wechat.product.service.ProductService;
import com.github.pagehelper.PageHelper;
@Service("productService") 
public class ProductServiceImpl implements ProductService{
	@Resource
	private WechatProductDao productdao;

	@Override
	public List<WechatProduct> findProduct(Integer pageNo,Integer pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		return productdao.findProduct();
	}
	
	@Override
	public List<WechatProduct> findProductByCategory(Integer pageNo, Integer pageSize, Integer productCategoryid) {
		PageHelper.startPage(pageNo,pageSize);
		return productdao.findProductByCategory(productCategoryid);
	}

	@Override
	public WechatProduct findProduct(Integer productId) {
		return productdao.findProductInfo(productId);
	}

}
