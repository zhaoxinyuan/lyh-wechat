<%@ page language="java" import="com.ftc.wechat.pay.pojo.WechatPayUnifiedOrder" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String localUrl = request.getServletPath().substring(1);
%>
<%@ include file="../../common/basic-server.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../../common/basic-them.inc"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%
	WechatPayUnifiedOrder unifiedOrder = (WechatPayUnifiedOrder) request.getSession().getAttribute(request.getParameter("orderno"));
%>
<title>微信支付</title>
	<script type="text/javascript">
	document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
		WeixinJSBridge.invoke('getBrandWCPayRequest',{
				"appId" : "<%=unifiedOrder.getAppid()%>",
				"timeStamp" : "<%=unifiedOrder.getTimeStamp()%>", 
				"nonceStr" : "<%=unifiedOrder.getNonceStr()%>", 
				"package" : "<%=unifiedOrder.getPrepayId()%>",
				"signType" : "<%=unifiedOrder.getSignType()%>",
				"paySign" : "<%=unifiedOrder.getPaySign()%>"
			},function(res){
				 if(res.err_msg == "get_brand_wcpay_request:ok" ) {
					 window.location.href = "http://www.lyhui.cn/WeChat/pay/successPay.jsp";
				}else{
					 window.location.href = "http://www.lyhui.cn/WeChat/pay/errorPay.jsp";
				}
				
			});
	}, false);
	</script> 
</head>
<body>

</body>
</html>
<%@ include file="../../common/basic-script.inc"%>