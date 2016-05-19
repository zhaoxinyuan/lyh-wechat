<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String localUrl = "home/index.jsp";
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
<link href="<%=basePath %>pay/css/lyh.pay.css" rel="stylesheet" />
<title>零元汇</title>
</head>
<body>
	<header class="bar bar-nav">
  		<a href="javascript:forward('orders/order.jsp');" class="icon icon-left pull-left"></a>
  		<a href="<%=basePath %>home/index.jsp" class="icon icon-home pull-right"></a>
  		<h1 class="title">支付订单</h1>
	</header>
	<div class="content">
		<div class="card">
    		<div class="card-header">
    			<div class="row">
    				<div class="col-33">订单编号</div>
    				<div class="col-66 pay-orderno"></div>
    			</div>
    		</div>
    		<div class="card-content">
      			<div class="card-content-inner text-right">
      				<span>应付金额&nbsp;&nbsp;</span>
      				<span class="pay-orderamount">
      					
      				</span>
      			</div>
    		</div>
  		</div>
  		<div class="platform-panel">
  			<div class="content-block-title">请选择支付方式</div>
  			<div class="list-block">
  				<ul>
  				</ul>
  			</div>
  		</div>
  		<div class="content-block">
			<p><button class="button button-big button-round pay-button">支付</button></p>
		</div>
	</div>
	
</body>
</html>

<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>pay/js/lyh.pay.js"></script>