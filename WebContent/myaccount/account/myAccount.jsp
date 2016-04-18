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

<link href="<%=basePath %>myaccount/account/css/lyh.account.css" rel="stylesheet" />
<title>零元汇</title>
</head>
<body>
	<header class="bar bar-nav">
  		<a href="javascript:window.history.back();" class="icon icon-left pull-left"></a>
  		<a href="<%=basePath %>home/index.jsp" class="icon icon-home pull-right"></a>
  		<h1 class="title">用户中心</h1>
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
		<a class="tab-item external" href="<%=basePath %>orders/order.jsp">
			<span class="icon icon-menu"></span>
			<span class="tab-label">我的订单</span>
		</a>
		<a class="tab-item external active" href="#">
			<span class="icon icon-me"></span>
			<span class="tab-label">用户中心</span>
		</a>
	</nav>
	<div class="content">
		<div class="card">
			<div class="card-content">
				<div class="list-block media-list">
					<ul>
						<li class="item-content account-userinfo">
							<div class="item-media account-user-photo">
								<img class="fillet" src="">
							</div>
							<div class="item-inner account-user-infopanel">
								<div class="item-title-row">
									<div class="item-title account-user-nickname">
										<span>昵称&nbsp;&nbsp;</span>
										<span id="account_user_nickname"></span>
									</div>
								</div>
								<div class="item-subtitle account-user-regdate">
									<span>关注时间&nbsp;&nbsp;</span>
									<span id="account_user_regdate"></span>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div class="card-footer">
				<nav class="bar acctount-user-order">
					<a class="tab-item external">
						<span class="icon">
							<i class="fa fa-list-ul account-order-menu"></i>
						</span>
						<span class="tab-label account-order-menu">全部订单</span>
					</a>
					<a class="tab-item external user-order-status-notpay" href="<%=basePath %>orders/order.jsp?tab=orders-notpay">
						<span class="icon">
							<i class="fa fa-credit-card account-order-menu"></i>
						</span>
						<span class="tab-label account-order-menu">待付款</span>
					</a>
					<a class="tab-item external user-order-status-notreceived" href="<%=basePath %>orders/order.jsp?tab=orders-notreceived">
						<span class="icon">
							<i class="fa fa-truck account-order-menu"></i>
						</span>
						<span class="tab-label account-order-menu">待发货</span>
					</a>
					<a class="tab-item external user-order-status-received" href="<%=basePath %>orders/order.jsp?tab=orders-received">
						<span class="icon">
							<i class="fa fa-clock-o account-order-menu"></i>
						</span>
						<span class="tab-label account-order-menu">待收货</span>
					</a>
				</nav>
			</div>
		</div>
		<div class="list-block">
			<ul>
				<li class="item-content item-link" onclick="window.location.href = '<%=basePath %>orders/order.jsp'">
					<div class="item-media"><i class="fa fa-reorder fa-fw fa-default"></i></div>
					<div class="item-inner">
						<div class="item-title">我的订单</div>
					</div>
				</li>
				<li class="item-content item-link" onclick="window.location.href = '<%=basePath %>myaccount/points/myPoints.jsp'">
					<div class="item-media"><i class="fa fa-star-o fa-fw fa-default"></i></div>
					<div class="item-inner">
						<div class="item-title">我的积分</div>
					</div>
				</li>
				<li class="item-content item-link" onclick="window.location.href = '<%=basePath %>myaccount/orderaddress/orderAddress.jsp'">
					<div class="item-media"><i class="fa fa-map-signs fa-fw fa-default"></i></div>
					<div class="item-inner">
						<div class="item-title">收货地址</div>
					</div>
				</li>
				<li class="item-content item-link" onclick="window.location.href = '<%=basePath %>myaccount/userinfo/myInfo.jsp'">
					<div class="item-media"><i class="fa fa-user fa-fw fa-default"></i></div>
					<div class="item-inner">
						<div class="item-title">账号资料</div>
					</div>
				</li>	
			</ul>
		</div>
	</div>
</body>
</html>

<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>myaccount/account/js/lyh.account.js"></script>
<script type="text/javascript">
wx.onMenuShareAppMessage({
    title: share.sharetitle, 
    desc: '用户中心', 
    link: share.sharepath, 
    imgUrl: share.shareicon,
    success: function () { 
        //alert('success');
    },
    cancel: function () { 
    	//alert('cancel');
    }
});

wx.onMenuShareTimeline({
    title: '用户中心',
    link: share.sharepath,
    imgUrl: share.shareicon,
    success: function () { 
        // 用户确认分享后执行的回调函数
    },
    cancel: function () { 
        // 用户取消分享后执行的回调函数
    }
});
</script>