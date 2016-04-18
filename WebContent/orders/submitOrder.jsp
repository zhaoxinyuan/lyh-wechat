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
<link href="<%=basePath %>orders/css/lyh.submitOrder.css" rel="stylesheet" />
<title>零元汇</title>
</head>
<body>
	<header class="bar bar-nav">
  		<a href="javascript:window.history.back()" class="icon icon-left pull-left"></a>
  		<a href="<%=basePath %>home/index.jsp" class="icon icon-home pull-right"></a>
  		<h1 class="title">提交订单</h1>
	</header>
	<div class="content">
		<div class="card address-default-panel orders-detail">
   			<div class="card-content">
				<div class="list-block">
					<ul>
					 	<li>
					 		<b class="order-address-border"></b>
					 		<a href="#" class="item-link item-content">
					 			<div class="item-media"><i class="icon icon-f7"></i></div>
					 			<div class="item-inner">
					 				<div class="row">
					 					<div class="order-address-user-name col-50"></div>
					 						<div class="order-address-user-phone col-50 text-right"></div>
					 						<div class="order-address-user-detail col-100"></div>
					 					</div>	
					 			</div>
					 		</a>
					 		<b class="order-address-border"></b>
					 	</li>
					 </ul>			
				</div>
			</div>
    	</div>
  		<div class="card order-product-list orders-detail">
    		<div class="card-content">
          		<div class="list-block media-list">
          			<ul>
          				<li class="item-content">
          					<div class="item-inner">
          						<div class="item-title-row">
          							<div class="item-title order-product-info">
          								<div class="row">
			          						<div class="col-20 order-product-img"></div>			
          									<div class="col-60">
          										<div class="order-product-name"></div>
          										<div class="order-product-spec"></div>
          									</div>
          									<div class="col-20">
          										<div class="order-product-price"></div>
          										<div class="order-product-qty text-right"></div>
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
    	<div class="text-right order-amount orders-detail">
    		<span>共1件商品，合计：</span>
    		<span class="order-product-amount"></span>
    		<span>&nbsp;(运费 </span>
    		<span class="order-product-expressPrice"></span>
    	</div>
    	<div class="order-activity orders-detail">
    		<p>
    			活动说明
    		</p>
    		<p class="order-activity-detail">
    			活动发货环节已统一外包给快递公司负责(包括仓储、包装及货物分发)
    		</p>
    		<br/>
    		<label>
    			<input type="radio">
  				我已阅读并同意以上活动说明
    		</label>
    	</div>
    	<div class="content-block orders-detail">
    		<p><a class="button button-big button-round btn-submitorder disabled">提交 </a></p>
  		</div>
  		<div class="order-error">
			<i class="fa fa-exclamation-circle fa-fw fa-3x"></i> 该订单已过期
		</div>
	</div>
</body>
</html>

<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>orders/js/lyh.submitOrder.js"></script>