<script src="<%=basePath%>resources/sui-mobile/dist/js/sm.js" type="text/javascript"></script>
<script src="<%=basePath%>resources/sui-mobile/dist/js/sm-city-picker.min.js" type="text/javascript"></script>
<script src="<%=basePath%>resources/sui-mobile/dist/js/sm-extend.min.js" type="text/javascript"></script>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>


<script>

var server = {
		basepath : '<%=basePath%>',
		productImagePath : 'http://www.lyhui.cn/FreeMall/product/img/'
};

var share = {
	sharepath : '<%=url%>',
	sharetitle : '<%=cnf.getTitle()%>',
	shareicon : '<%=basePath%>resources/img/default.jpg'
};

var signuser = {
		userid : '<%=signUser.getUserId()%>',
		username : '<%=signUser.getUserNickname()%>',
		userwechatid : '<%=signUser.getUserWechatid()%>',
		userheadimgurl : '<%=signUser.getUserHeadImgUrl()%>',
		usersubscribedate : '<%=signUser.getUserSubscribeTime()%>'
};

wx.config({
    debug: false, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
    appId: '<%=cnf.getAppId()%>', // 必填，公众号的唯一标识
    timestamp: <%=cnf.getTimestamp()%>, // 必填，生成签名的时间戳
    nonceStr: '<%=cnf.getNonceStr()%>', // 必填，生成签名的随机串
    signature: '<%=cnf.getSignature()%>',// 必填，签名，见附录1
    jsApiList: [<%=cnf.getJsApiList()%>] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
});



</script>