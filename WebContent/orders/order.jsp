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
<meta name="format-detection" content="telephone=no" />
</head>
<%@ include file="../../common/basic-them.inc"%>
<link href="<%=basePath %>orders/css/lyh.order.css" rel="stylesheet" />
<title>零元汇</title>
</head>
<body>
	<header class="bar bar-nav">
  		<a href="javascript:window.history.back();" class="icon icon-left pull-left"></a>
  		<a href="<%=basePath %>home/index.jsp" class="icon icon-home pull-right"></a>
  		<h1 class="title">我的订单</h1>
	</header>
	<nav class="bar bar-tab">
		<a class="tab-item external" href="<%=basePath %>home/index.jsp">
			<span class="icon icon-home"></span> 
			<span class="tab-label">商城</span>
		</a>
		<a class="tab-item external" href="<%=basePath %>pointsmall/pointsMall.jsp">
			<span class="icon icon-gift"></span>
			<span class="tab-label">积分兑换</span>
		</a>
		<a class="tab-item external active" href="<%=basePath %>orders/order.jsp">
			<span class="icon icon-menu"></span>
			<span class="tab-label">我的订单</span>
		</a>
		<a class="tab-item external" href="<%=basePath %>myaccount/account/myAccount.jsp">
			<span class="icon icon-me"></span>
			<span class="tab-label">用户中心</span>
		</a>
	</nav>
	<div class="content">
  		<div class="buttons-tab">
    		<a href="#orders_all" class="tab-link active button" data-order-status="status_all" data-table-id="orders_all">全部</a>
    		<a href="#orders_notpay" class="tab-link button orders-notpay" data-table-id="orders_notpay" data-order-status="status_01">待发货</a>
    		<a href="#orders_notreceived" class="tab-link button orders-notreceived" data-table-id="orders_notreceived" data-order-status="status_03">待发货</a>
    		<a href="#orders_received" class="tab-link button orders-received" data-table-id="orders_received" data-order-status="status_04">待收货</a>
  		</div>
  		<div class="content-block">
   			<div class="tabs">
      			<div id="orders_all" class="tab active">
        			<div class="content-block">
						
					</div>
      			</div>
      			<div id="orders_notpay" class="tab">
        			<div class="content-block">
          				
        			</div>
      			</div>
      			<div id="orders_notreceived" class="tab">
        			<div class="content-block">
          				
        			</div>
      			</div>
      			<div id="orders_received" class="tab">
        			<div class="content-block">
          				
        			</div>
      			</div>
    		</div>
  		</div>
	</div>
	<div class="popup popup-product">
	</div>
</body>
</html>

<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>orders/js/lyh.order.js"></script>