var user = {
		init: function(){
			$.ajax({
				url : server.basepath + 'userAction/getUserDetail',
				data : {},
				dataType : 'json',
				success : function(res){
					console.log(res);
					$('.user-photo').css('background-image','url(' + "'"  + res.userHeadImgUrl + "'" + ')');
					$('.user-nickname').append(res.userNickname);
					$('.user-mobile').append(res.userMobile ? res.userMobile : '<font color="#428bca">未绑定</font>');
					$('.user-email').append(res.userEmail ? res.userEmail : '<font color="#428bca">未绑定</font>');
					
					$('.item-mobile').click(function(){
						forward('myaccount/userinfo/myInfoEdit.jsp?edittype=mobile&editvalue=' + (res.userMobile ? res.userMobile : '') + '&userid=' + res.userId);
					});
					
					$('.item-email').click(function(){
						forward('myaccount/userinfo/myInfoEdit.jsp?edittype=email&editvalue=' + (res.userEmail ? res.userEmail : '') + '&userid=' + res.userId);
					});
					
					wx.onMenuShareAppMessage({
		                title: share.sharetitle, 
		                desc: '我的信息', 
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
		                title: '我的信息',
		                link: share.sharepath,
		                imgUrl: share.shareicon,
		                success: function () { 
		                    // 用户确认分享后执行的回调函数
		                },
		                cancel: function () { 
		                    // 用户取消分享后执行的回调函数
		                }
		            });
				},
				error : function(){
					
				}
			});
		},
};

wx.ready(function(){
	user.init();
});
