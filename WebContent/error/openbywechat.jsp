<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>	
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
<title>零元汇</title>
</head>
<body>
	<div class="content text-center" style="margin-top: 40px;">
		<i class="fa fa-smile-o fa-4x fa-rotate-270" style="color: #4cd964;"></i>
		<h4>请在微信客户端打开链接</h4>
	</div>

</body>
</html>

