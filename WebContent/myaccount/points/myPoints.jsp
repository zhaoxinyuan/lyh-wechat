<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String localUrl = request.getServletPath().substring(1);
%>
<%@ include file="../../common/basic-server.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<%@ include file="../../common/basic-them.inc"%>
<link href="<%=basePath %>myaccount/points/css/lyh.points.css" rel="stylesheet" />
<title>零元汇</title>
</head>
<body>
	<header class="bar bar-nav">
  		<a href="javascript:window.history.back();" class="icon icon-left pull-left"></a>
  		<a href="<%=basePath %>home/index.jsp" class="icon icon-home pull-right"></a>
  		<h1 class="title">我的积分</h1>
	</header>
	<div class="content">
		<div class="points-amount-panel">
			<div class="points-amount-title">
				当前积分
			</div>
			<div class="points-amount-value">
				
			</div class="points-amount-button">
			<div class="">
				<a href="<%=basePath %>pointsmall/pointsMall.jsp" class="button button-fill">积分兑换商品 </a>
			</div>
		</div>
		<div class="points-detail-items">
			<div class="content-block-title">积分明细</div>
			<div class="list-block">
				<ul class="points-detail-item">
				</ul>
			</div>
		</div>
		<div class="points-detail-null">
			<span class="fa-stack fa-2x">
			  <i class="fa fa-circle-thin fa-stack-2x"></i>
			  <i class="fa fa-exclamation fa-stack-1x"></i>
			</span>
			<p>您还没有积分，快去购物吧</p>
			<p><a href="<%=basePath %>home/index.jsp" class="button">现在去购物</a></p>
		</div>	
	</div>				
</body>
</html>

<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>myaccount/points/js/lyh.points.js"></script>