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
<meta name="format-detection" content="telephone=no" />
</head>
<%@ include file="../../common/basic-them.inc"%>
<link href="<%=basePath %>myaccount/orderaddress/css/lyh.address.css" rel="stylesheet" />
<title>零元汇</title>
</head>
<body>
	<header class="bar bar-nav">
  		<a href="javascript:window.history.back();" class="icon icon-left pull-left"></a>
  		<a href="<%=basePath %>home/index.jsp" class="icon icon-home pull-right"></a>
  		<h1 class="title">管理收货地址</h1>
	</header>
	<div class="content">
			
	</div>
	<div class="bar bar-footer">
  		<a href="#" class="button button-fill btn-address">添加收货地址</a>
	</div>	
</body>
</html>

<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>myaccount/orderaddress/js/lyh.address.js"></script>