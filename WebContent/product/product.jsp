<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% String localUrl = request.getServletPath().substring(1) + "?productid=" + request.getParameter("productid");%>
<%@ include file="../../common/basic-server.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<%@ include file="../../common/basic-them.inc"%>
		<link href="<%=basePath %>product/css/lyh.product.css" rel="stylesheet" />
		<title>零元汇</title>
	</head>
	<body>
		<div class="content">
			<div class="product active">
				<div class="swiper-container swiper-container-product" data-space-between='10'>
					<div class="swiper-wrapper border-b">
					</div>
					<div class="pagination"></div>
				</div>
				<div class="product-info hide">
					<div class="product-info-name"></div>
					<div class="product-info-title" >市场价</div>
					<div class="product-info-mallprice" ></div>
					<div class="product-info-title">抢购价</div>
					<div class="product-info-price"></div>
					<div class="product-info-title">物流费</div>
					<div class="product-info-expressprice"></div>
					<div class="product-info-title">服务</div>
					<div class="product-info-service">由零元汇商城提供优质服务</div>
				</div>
				
				<div class="product-spec list-block hide">
					<ul>
						<li class="item-content item-link">
							<div class="item-inner">
								<div class="item-title">选择</div>
	          					<div class="item-after"></div>
							</div>
						</li>	
					</ul>
				</div>
				
				 <div class="product-like hide">
					<div class="list-block">
						<ul>
							<li class="item-content">
								<div class="item-inner">
									<div class="item-title">热门推荐</div>
		          					<div class="item-after"></div>
								</div>
							</li>	
						</ul>
					</div>
					<div class="product-like-items row">
					</div>
				</div>
			            	
				<div class="product-todetail hide">
					<div class="list-block">
						<ul>
							<li class="item-content">
								<div class="item-inner">
									<div class="item-title text-center"><i class="fa fa-angle-right"></i>&nbsp;查看图文详情</div>
								</div>
							</li>	
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<div class="content product-detail hide" >
			<div class="buttons-tab">
				<a href="#tab1" class="tab-link active button">商品详情</a>
	    		<a href="#tab2" class="tab-link button">规格参数</a>
			</div>
			<div class="content-block">
				<div class="tabs">
					<div id="tab1" class="tab active">
						<div class="product-detail-imgs">
						</div>
					</div>
					<div id="tab2" class="tab">
						<div class="content-block product-detail-specs">
							<div class="list-block">
								<ul>
									<li class="item-content">
										<div class="item-inner product-detail-spec">
											<div class="item-title row">
												
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="product-button row no-gutter">
			<span class="col-40 product-button-toindex row no-gutter">
				<a class="col-50 product-button-menu product-button-index">
					<span class="product-button-menu-icon">
						<i class="fa fa-home"></i>
					</span>
					<span class="col-50 product-button-title">
						首页
					</span>
				</a>
				<a class="col-50 product-button-menu product-button-back">
					<span class="product-button-menu-icon">
						<i class="fa fa-angle-left"></i>
					</span>
					<span class="col-50 product-button-title">
						返回
					</span>
				</a>
			</span>
			<span class="col-30 product-button-followus">关注我们</span>
			<span class="col-30 product-button-buy">立即领取</span>
		</div>
		<div class="product-spec-list hide">
			<div class="row no-gutter">
		    	<div class="col-20 product-spec-image"></div>
		      	<div class="col-80">
		      		<div class="product-spec-close"><i class="fa fa-close"></i></div>
		      		<div class="product-spec-info">
		      			<div class="product-spec-info-name"></div>
		      			<div class="product-spec-info-msg">请选择</div>
		      		</div>
		      	</div>		      
		    </div>
		    <div class="product-spec-fixed">
		      	<a href="#" class="button button-fill button-danger button-fixed">确定</a>
		     </div>
		</div>
	</body>
</html>

<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>resources/js/plugin/zepto.fx_methods.js"></script>
<script src="<%=basePath%>product/js/lyh.product.js"></script>