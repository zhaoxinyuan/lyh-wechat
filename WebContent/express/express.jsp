<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/basic-server.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="../../common/basic-them.inc"%>

<link href="<%=basePath %>express/css/lyh.express.css" rel="stylesheet" />

<title>零元汇</title>
</head>

</head>
<body>
	<header class="bar bar-nav">
  		<a href="javascript:forward('home/index.jsp');" class="icon icon-left pull-left"></a>
  		<a href="<%=basePath %>home/index.jsp" class="icon icon-home pull-right"></a>
  		<h1 class="title">查看物流信息</h1>
	</header>
	<div class="content">
		<iframe id="iFrame" name="iFrame" width="100%" height="700px;" onload="setHeight" frameborder="0" src="http://www.baidu.com"></iframe>  
	</div>
</body>
</html>

<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>express/js/lyh.express.js"></script>

