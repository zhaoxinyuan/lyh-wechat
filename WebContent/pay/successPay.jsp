<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String localUrl = "home/index.jsp";
%>
<%@ include file="../../common/basic-server.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="../../common/basic-them.inc"%>

<link href="<%=basePath%>pay/css/lyh.resultPay.css" rel="stylesheet" />

<title>零元汇</title>
</head>
	<header class="bar bar-nav">
		<h1 class="title">支付成功</h1>
	</header>
	<div class="content">
		<div class="border-t success-panel">
			<div class="success-panel-icon"><i class="fa fa-check-circle fa-3x"></i></div>
			<div class="success-panel-message">
      			<strong>恭喜您支付成功！</strong>
      			<p>您已成功支付该订单。</p>
      		</div>
		</div>
		<div class="pay-message border-radius success-panel">
			<p class="pay-message-detail">
				温馨提示：
			</p>
			<p class="pay-message-detail">
				我们会尽快为您发货，请关注订单动态，可在我的订单页查询订单动态和物流信息
			</p>
			<div class="col-100 success-button">
	      		<p><a href="https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80bec67da02b4517&redirect_uri=http%3A%2F%2Fwww.lyhui.cn%2FWeChat%2FforwardAction%2FforwardRequest%3Fpath%3Dorders%2Forder.jsp&response_type=code&scope=snsapi_base&state=1#wechat_redirect" class="button button-fill button-success">查看订单 </a></p>
	      	</div>
		</div>
	</div>
</head>
<body>

</body>
</html>

<%@ include file="../../common/basic-script.inc"%>
<script type="text/javascript">
$(function () {
	wx.onMenuShareAppMessage({
	    title: share.sharetitle, 
	    desc: '零元汇', 
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
	    title: '零元汇',
	    link: share.sharepath,
	    imgUrl: share.shareicon,
	    success: function () { 
	        // 用户确认分享后执行的回调函数
	    },
	    cancel: function () { 
	        // 用户取消分享后执行的回调函数
	    }
	});
	
	 $.modal({
	      afterText:  '<div><img style="width:100%;" src="<%=basePath%>pay/img/roll.png"></div>',
	      buttons: [{
	          text: '放弃 :('	  
	        },{
	          text: '马上去抽奖',
	          bold: true,
	          onClick: function () {
	        	  window.location.href = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx80bec67da02b4517&redirect_uri=http%3A%2F%2Fwww.lyhui.cn%2FWeChat%2FforwardAction%2FforwardRequest%3Fpath%3Dlottery%2Findex.html&response_type=code&scope=snsapi_base&state=1#wechat_redirect';
	          }
	        }]
		});
});
</script>
