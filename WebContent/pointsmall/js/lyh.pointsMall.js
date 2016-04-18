var mall = {
		init: function(){
			$(".swiper-container").swiper({
				pagination: '.swiper-pagination',
		        paginationClickable: true,
		        direction: 'vertical'
			});
			
			$.ajax({
				url : server.basepath + 'userAction/getUserPointsAmount',
				data : {},
				dataType : 'json',
				success : function(res){
					console.log(res);
					$('.mall-user-points-value').append(res ? res.pointsAmount : 0) ;
					
					wx.onMenuShareAppMessage({
		                title: share.sharetitle, 
		                desc: '积分兑换', 
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
		                title: '积分兑换',
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
			
			$('.button-convertible').click(function(){
				$.alert('您的积分不足');
			});
		}
};

wx.ready(function(){
	
});
