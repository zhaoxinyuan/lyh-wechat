var account = {
		init: function(){
			$('.account-user-photo').find('img').attr('src',signuser.userheadimgurl);
			$('#account_user_nickname').append(signuser.username);
			$('#account_user_regdate').append(signuser.usersubscribedate);
			this.getUserInfo();
		},
		getUserInfo : function(){
			$.ajax({
				url : server.basepath + 'userAction/getUserInfo',
				data : {},
				dataType : 'json',
				success : function(res){
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
					if(!res) return;
					res.userOrderNotPayNum ? $('.user-order-status-notpay').append('<span class="badge-cornernum">' + res.userOrderNotPayNum + '</span>') : '';
					res.userOrderNotReceivedNum ? $('.user-order-status-notreceived').append('<span class="badge-cornernum">' + res.userOrderNotReceivedNum + '</span>') : '';
					res.userOrderReceivedNum ? $('.user-order-status-received').append('<span class="badge-cornernum">' + res.userOrderReceivedNum + '</span>') : '';
				},
				error : function(){
					
				}
			});
		}
};

wx.ready(function(){
	console.log('init wechat JavaScript sdk success');
	account.init();
});

