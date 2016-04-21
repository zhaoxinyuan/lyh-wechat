package com.ftc.wechat.product.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class WechatProduct {
	private Integer productId;

	private String productName;

	private String productDescribe;

	private Double productPrice;

	private Double productMallPrice;

	private Double productExpressPrice;

	private Double productPurchasePrice;

	private String productImageurl;

	private String productDetailurl;

	private String productUpdatetime;

	private Integer productUp;

	private String productSpec;

	private Integer productCategoryid;

	private List<WechatProductImage> productImage;

	private List<WechatProductSpec> productSpecs;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName == null ? null : productName.trim();
	}

	public String getProductDescribe() {
		return productDescribe;
	}

	public void setProductDescribe(String productDescribe) {
		this.productDescribe = productDescribe == null ? null : productDescribe.trim();
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Double getProductPurchasePrice() {
		return productPurchasePrice;
	}

	public void setProductPurchasePrice(Double productPurchasePrice) {
		this.productPurchasePrice = productPurchasePrice;
	}

	public Integer getProductCategoryid() {
		return productCategoryid;
	}

	public void setProductCategoryid(Integer productCategoryid) {
		this.productCategoryid = productCategoryid;
	}

	public String getProductImageurl() {
		return productImageurl;
	}

	public void setProductImageurl(String productImageurl) {
		this.productImageurl = productImageurl == null ? null : productImageurl.trim();
	}

	public String getProductDetailurl() {
		return productDetailurl;
	}

	public void setProductDetailurl(String productDetailurl) {
		this.productDetailurl = productDetailurl == null ? null : productDetailurl.trim();
	}

	public String getProductUpdatetime() {
		return productUpdatetime;
	}

	public void setProductUpdatetime(String productUpdatetime) {
		try {
			this.productUpdatetime = new SimpleDateFormat("MM-dd HH:mm")
					.format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(productUpdatetime));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Double getProductMallPrice() {
		return productMallPrice;
	}

	public void setProductMallPrice(Double productMallPrice) {
		this.productMallPrice = productMallPrice;
	}

	public Double getProductExpressPrice() {
		return productExpressPrice;
	}

	public void setProductExpressPrice(Double productExpressPrice) {
		this.productExpressPrice = productExpressPrice;
	}

	public Integer getProductUp() {
		return productUp;
	}

	public void setProductUp(Integer productUp) {
		this.productUp = productUp;
	}

	public List<WechatProductImage> getProductImage() {
		return productImage;
	}

	public void setProductImage(List<WechatProductImage> productImage) {
		this.productImage = productImage;
	}

	public List<WechatProductSpec> getProductSpecs() {
		return productSpecs;
	}

	public void setProductSpec(List<WechatProductSpec> productSpecs) {
		this.productSpecs = productSpecs;
	}

	public String getProductSpec() {
		return productSpec;
	}

	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}

	public void setProductSpecs(List<WechatProductSpec> productSpecs) {
		this.productSpecs = productSpecs;
	}

	// for order
	private Integer qty = 0;
	@SuppressWarnings("unused")
	private Double amount = 0D;

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Double getAmount() {
		return (this.productPrice + this.getProductExpressPrice()) * this.qty;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}