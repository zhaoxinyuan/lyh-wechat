<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String localUrl = "home/index.jsp?productid=productCode";
%>
<%@ include file="../../common/basic-server.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">

<title>零元汇</title>

<%@ include file="../../common/basic-them.inc"%>
<link href="<%=basePath %>home/css/lyh.index.css" rel="stylesheet" />
<link href="<%=basePath %>product/css/lyh.product.css" rel="stylesheet" />


<script type="text/javascript">

$.config = {
        // 路由功能开关过滤器，返回 false 表示当前点击链接不使用路由
        routerFilter: function($link) {
            // 某个区域的 a 链接不想使用路由功能
            if ($link.is('.disable-router a')) {
                return false;
            }

            return true;
        }
    };

//document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);

</script>

<style type="text/css">
.wrapper {
	position: absolute;
	z-index: 1;
	top: 0px;
	bottom: 48px;
	left: 0;
	width: 100%;
	overflow: hidden;
}

.scroller {
	position: absolute;
	z-index: 1;
	-webkit-tap-highlight-color: rgba(0,0,0,0);
	width: 100%;
	-webkit-transform: translateZ(0);
	-moz-transform: translateZ(0);
	-ms-transform: translateZ(0);
	-o-transform: translateZ(0);
	transform: translateZ(0);
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	-webkit-text-size-adjust: none;
	-moz-text-size-adjust: none;
	-ms-text-size-adjust: none;
	-o-text-size-adjust: none;
	text-size-adjust: none;
}


</style>
</head>
<body>

<div class="page-group">
	<div class="page" id="page_index">
		<!-- header class="bar bar-nav">
		  	<h1 class="title">零元汇</h1>
		</header -->
		<div id="index_upload_msg" class="upload-msg"><i class="fa fa-arrow-down"></i>&nbsp;下拉即可刷新</div>
		<div class="wrapper" id="wrapper_index">
			<div class="scroller">
				<div class="swiper-container swiper-container-index" data-space-between='10'>
					<div class="swiper-wrapper">
						<div class="swiper-slide my-carousel">
							<img src="<%=basePath%>home/img/carousel1.jpg">
					</div>
					<div class="swiper-slide my-carousel">
						<img src="<%=basePath%>home/img/carousel2.jpg">
					</div>
					<div class="swiper-slide my-carousel index-topoints">
						<img src="<%=basePath%>home/img/carousel3.jpg">
						</div>
					</div>
					<div class="swiper-pagination"></div>
				</div>
			
				<div class="product-promotion row no-gutter">
					<div class="col-50">
						<div class="border-r product-promotion-img-left">
							<div class="product-promotion-countdown">
								<span class="product-promotion-countdown-time product-promotion-countdown-time-hour">00</span>
								<span> : </span>
								<span class="product-promotion-countdown-time product-promotion-countdown-time-minute">60</span>
								<span> : </span>
								<span class="product-promotion-countdown-time product-promotion-countdown-time-second">00</span>
							</div>
						</div>
					</div>
					<div class="col-50">
						<div class="border-b product-promotion-img-right product-promotion-img-right-t"></div>
						<div class="product-promotion-img-right product-promotion-img-right-b"></div>
					</div>
				</div>
				<div class="infinite-scroll infinite-scroll-bottom no-gutter product-list">
					<div class="list-block">
						<ul class="product-items">
							<li class="item-content product-title">
								<div class="item-inner">
									<div class="item-title"><strong>本期申领</strong></div>
									<div class="item-after"><span class="icon icon-refresh fa-blue"></span></div>
								</div>
							</li>
						</ul>
					</div>
				</div>
				<div class="infinite-scroll-preloader">
					<div class="preloader"></div>
				</div>
			</div>
		</div>
		<nav class="bar bar-tab">
			<a class="tab-item external active" href="#">
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
			<a class="tab-item external" href="<%=basePath %>myaccount/account/myAccount.jsp">
				<span class="icon icon-me"></span>
				<span class="tab-label">用户中心</span>
			</a>
		</nav>
	</div>
</div>

</body>
</html>
<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>home/js/lyh.myRouter.js"></script>
<script src="<%=basePath%>home/js/lyh.index.js"></script>
<script src="<%=basePath%>product/js/lyh.product.js"></script>