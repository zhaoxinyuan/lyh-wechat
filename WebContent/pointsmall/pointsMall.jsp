<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String localUrl = request.getServletPath().substring(1);
%>
<%@ include file="../../common/basic-server.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<%@ include file="../../common/basic-them.inc"%>
<link href="<%=basePath %>pointsmall/css/lyh.pointsMall.css" rel="stylesheet" />
<title>零元汇</title>
</head>
<body>
<div class="swiper-container">	
	<div class="swiper-wrapper">
		<div class="swiper-slide mall-index">
			<div class="test">
				<i class="fa fa-angle-double-up fa-3x"></i>
			</div>
		</div>
		<div class="swiper-slide swiper-no-swiping">
			<header class="bar bar-nav">
	  			<a href="javascript:window.history.back();" class="icon icon-left pull-left"></a>
	  			<a href="<%=basePath %>home/index.jsp" class="icon icon-home pull-right"></a>
	  			<h1 class="title">积分兑换</h1>
			</header>
			<nav class="bar bar-tab">
				<a class="tab-item external" href="<%=basePath %>home/index.jsp">
					<span class="icon icon-home"></span> 
					<span class="tab-label">商城</span>
				</a>
				<a class="tab-item external active" href="<%=basePath %>pointsmall/pointsMall.jsp">
					<span class="icon icon-gift"></span>
					<span class="tab-label">积分兑换</span>
				</a>
				<a class="tab-item external" href="<%=basePath %>orders/order.jsp">
					<span class="icon icon-menu"></span>
					<span class="tab-label">我的订单</span>
				</a>
				<a class="tab-item external" href="<%=basePath %>myaccount/account/myAccount.jsp">
					<span class="icon icon-me"></span>
					<span class="tab-label">用户中心</span>
				</a>
			</nav>
			<div class="content">
				<div class="list-block">
					<ul>
						<li class="item-content">
							<div class="item-inner">
								<div class="item-title"><span class="mall-user-points-title">我的积分</span><span class="mall-user-points-value"></span></div>
								<div class="item-after"><a href="<%=basePath %>myaccount/points/myPoints.jsp" class="button">积分明细</a></div>
							</div>
						</li>
					</ul>
				</div>
				<div class="list-block">
					<ul>
						<li class="item-content">
							<div class="item-inner">
								<div class="item-title">
									<div class="row">
										<div class="col-20">
											<!-- 630 *　950 -->
											<img class="mall-points-item-img" src="http://img13.360buyimg.com/n1/jfs/t2302/16/135479564/94882/c76da045/55f0e877N3c24faa3.jpg">
										</div>
										<div class="col-80">
											<div class="mall-points-item-name">
												<strong>Apple iPhone 6s (A1699) 64G 玫瑰金</strong>
											</div>
											<div class="mall-points-item-desc nowrap-flex">
												&nbsp;&nbsp;&nbsp;&nbsp;Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机
											</div>
											<div class="row">
												<div class="col-50 mall-points-item-btn">
													<a href="#" class="button button-danger button-convertible">立即兑换</a>
												</div>
												<div class="col-50 text-right mall-points-item-value">
													<i class="fa fa-star"></i>1000积分
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</li>
						<li class="item-content">
							<div class="item-inner">
								<div class="item-title">
									<div class="row">
										<div class="col-20">
											<img class="mall-points-item-img" src="http://img13.360buyimg.com/n1/jfs/t2302/16/135479564/94882/c76da045/55f0e877N3c24faa3.jpg">
										</div>
										<div class="col-80">
											<div class="mall-points-item-name">
												<strong>Apple iPhone 6s (A1699) 64G 玫瑰金</strong>
											</div>
											<div class="mall-points-item-desc nowrap-flex">
												&nbsp;&nbsp;&nbsp;&nbsp;Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机Apple iPhone 6s Plus (A1699) 64G 玫瑰金色 移动联通电信4G手机
											</div>
											<div class="row">
												<div class="col-50 mall-points-item-btn">
													<a href="#" class="button button-danger button-convertible">立即兑换</a>
												</div>
												<div class="col-50 text-right mall-points-item-value">
													<i class="fa fa-star"></i>1000积分
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>	
		</div>
	</div>
</div>				
</body>
</html>

<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>pointsmall/js/lyh.pointsMall.js"></script>