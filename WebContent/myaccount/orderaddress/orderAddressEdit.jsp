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
<link href="<%=basePath %>myaccount/orderaddress/css/lyh.address.edit.css" rel="stylesheet" />
<style>
input[type='text'].invalid, input[type='password'].invalid, input[type='number'].invalid, input[type='email'].invalid, input[type='url'].invalid, textarea.invalid, select.invalid {
    border-color: red;
}
</style>
<title>零元汇</title>
</head>
<body>
	<header class="bar bar-nav">
  		<a href="javascript:window.history.back();" class="icon icon-left pull-left"></a>
  		<a href="<%=basePath %>home/index.jsp" class="icon icon-home pull-right"></a>
  		<h1 class="title">编辑收货地址</h1>
	</header>
	<div class="content">
		<div class="list-block">
			<ul>
				<li>
					<div class="item-content">
						<div class="item-media"><i class="icon icon-form-name"></i></div>
						<div class="item-inner">
							<div class="item-title label">收货人姓名</div>
							<div class="item-input">
								<input class="myvalidate" data-validate="required" data-errormsg="请输入收货人姓名" type="text" placeholder="" id="address_name">
							</div>	
						</div>
						<div class="item-media"><i class="icon icon-form-name"></i></div>
					</div>
				</li>
				<li>
					<div class="item-content">
						<div class="item-media"><i class="icon icon-form-name"></i></div>
						<div class="item-inner">
							<div class="item-title label">收货人电话</div>
							<div class="item-input">
								<input class="myvalidate" data-validate="mobile" data-errormsg="请输入收货人电话" type="tel" placeholder="" id="address_mobile">
							</div>	
						</div>
					</div>
				</li>
				<li>
					<div class="item-content">
						<div class="item-media"><i class="icon icon-form-name"></i></div>
						<div class="item-inner">
							<div class="item-title label">所在地区</div>
							<div class="item-input">
								<input class="myvalidate" data-validate="required" data-errormsg="请输入所在地区" type="text" placeholder="" id="address_area">
							</div>	
						</div>
					</div>
				</li>
				<li>
					<div class="item-content">
						<div class="item-media"><i class="icon icon-form-name"></i></div>
						<div class="item-inner">
							<div class="item-title label">邮编地址</div>
							<div class="item-input">
								<input class="myvalidate" data-validate="post" data-errormsg="请输入邮编地址" type="tel" placeholder="" id="address_post">
							</div>	
						</div>
					</div>
				</li>
				<li class="align-top">
					<div class="item-content">
						<div class="item-media"><i class="icon icon-form-comment"></i></div>
						<div class="item-inner">
							<div class="item-title label">详细地址</div>
							<div class="item-input">
								<textarea class="myvalidate" data-validate="required" data-errormsg="请输详细地址" id="address_street"></textarea>
							</div>	
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="list-block">
			<ul>
				<li class="address-default-list">
					<div class="item-content">
						<div class="item-media"><i class="icon icon-form-name"></i></div>
						<div class="item-inner">
							<div class="item-title label">默认地址</div>
							<div class="item-input">
								<label class="label-switch">
									<input type="checkbox" id="address_default">
									<div class="checkbox"></div>
								</label>
							</div>	
						</div>
					</div>
				</li>
				<li class="item-content address-delete-list">
       				 <div class="item-media"><i class="icon icon-f7"></i></div>
       				 <div class="item-inner">
       				 	<div class="item-title"><a class="a-danger">删除收货地址</a></div>
       				 </div>
      			</li>
			</ul>
		</div>
	</div>
	<div class="bar bar-footer">
  		<a href="#" class="button button-fill btn-saveaddress">保存</a>
	</div>
</body>
</html>

<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>myaccount/orderaddress/js/lyh.address.edit.js"></script>