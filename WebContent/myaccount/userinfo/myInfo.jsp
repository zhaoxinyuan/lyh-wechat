<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String localUrl = request.getServletPath().substring(1);
%>
<%@ include file="../../common/basic-server.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<meta name="format-detection" content="telephone=no" />
</head>
<%@ include file="../../common/basic-them.inc"%>
<link href="<%=basePath %>myaccount/userinfo/css/lyh.myInfo.css" rel="stylesheet" />
<title>零元汇</title>
</head>
<body>
	<header class="bar bar-nav">
  		<a href="javascript:window.history.back();" class="icon icon-left pull-left"></a>
  		<a href="<%=basePath %>home/index.jsp" class="icon icon-home pull-right"></a>
  		<h1 class="title">我的信息</h1>
	</header>
	<div class="content">
		<div class="list-block">
			<ul>
				<li class="item-content">
					<div class="item-media"><i class="icon icon-f7"></i></div>
					<div class="item-inner item-user-photo">
						<div class="item-title">头像</div>
						<div class="item-after"><span class="user-photo"></span></div>
					</div>	
				</li>
				<li class="item-content">
					<div class="item-media"><i class="icon icon-f7"></i></div>
					<div class="item-inner">
						<div class="item-title">昵称</div>
						<div class="item-after user-nickname"></div>
					</div>	
				</li>
      		</ul>
		</div>
		<div class="content-block-title">账号绑定</div>
		<div class="list-block">
			<ul>
				<li class="item-content item-link item-mobile" onclick="">
					<div class="item-media">
						<i class="fa fa-mobile fa-lg form-icon fa-blue"></i>
					</div>
					<div class="item-inner">
						<div class="item-title">手机</div>
						<div class="item-after user-mobile"></div>
					</div>	
				</li>
				<li class="item-content item-link item-email">
					<div class="item-media"><i class="fa fa-envelope-o form-icon fa-blue"></i></div>
					<div class="item-inner">
						<div class="item-title">邮箱</div>
						<div class="item-after user-email"></div>
					</div>	
				</li>
			</ul>
		</div>		
	</div>				
</body>
</html>

<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>myaccount/userinfo/js/lyh.userinfo.js"></script>