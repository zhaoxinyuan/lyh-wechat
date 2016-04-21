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
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<title>零元汇</title>

<%@ include file="../../common/basic-them.inc"%>
<link href="<%=basePath %>category/css/lyh.product.css" rel="stylesheet" />
<link href="<%=basePath %>product/css/lyh.product.css" rel="stylesheet" />


<script type="text/javascript">

$.config = {
        // 路由功能开关过滤器，返回 false 表示当前点击链接不使用路由
        routerFilter: function($link) {
            // 某个区域的 a 链接不想使用路由功能
            if ($link.hasClass('disable-router')) {
                return false;
            }

            return true;
        }
    };

</script>

<style type="text/css">
.wrapper {
	position: absolute;
	z-index: 1;
	top: 0px;
	bottom: 0px;
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
	<div class="page" id="page_category">
		<header class="bar bar-nav">
			<a class="icon icon-left pull-left disable-router" href="<%=basePath%>home/index.jsp"></a>
		  	<h1 class="title"></h1>
		</header>
		<div id="index_upload_msg" class="upload-msg"><i class="fa fa-arrow-down"></i>&nbsp;下拉即可刷新</div>
		<div class="wrapper" id="wrapper_index">
			<div class="scroller">
				<div class="infinite-scroll infinite-scroll-bottom no-gutter product-list">
					<div class="list-block">
						<ul class="product-items">
							
						</ul>
					</div>
				</div>
				<div class="infinite-scroll-preloader">
					<div class="preloader"></div>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
</html>
<%@ include file="../../common/basic-script.inc"%>
<script src="<%=basePath%>home/js/lyh.myRouter.js"></script>
<script src="<%=basePath%>home/js/lyh.index.js"></script>
<script src="<%=basePath%>product/js/lyh.product.js"></script>