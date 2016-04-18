<%@ page language="java" import="java.util.*,com.ftc.wechat.user.pojo.WechatUser,com.ftc.wechat.base.util.WechatUtil,com.ftc.wechat.base.entity.WeChatJSConfig,com.ftc.wechat.base.config.WechatConfig,java.net.URLEncoder" pageEncoding="UTF-8"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+path+"/";

WechatUser signUser = (WechatUser)request.getSession().getAttribute("signUser");
signUser = signUser == null ? new WechatUser() : signUser;

WeChatJSConfig cnf = WechatUtil.getJSConfig(request.getScheme()+"://"+ request.getServerName()+request.getRequestURI()+(request.getQueryString() == null ? "" : "?"+request.getQueryString()));
String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WechatConfig.appId+"&redirect_uri="+(URLEncoder.encode(WechatConfig.localUrl + "forwardAction/forwardRequest?path=" + localUrl , "utf-8"))+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect";

if(!WechatUtil.isWechat(request)){
	//response.sendRedirect(basePath + "error/openbywechat.jsp");
}
%>




