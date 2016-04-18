var points = {
		init: function(){
			$('.points-detail-items,.points-detail-null').hide();
			$.ajax({
				url : server.basepath + 'userAction/getUserPointsAmount',
				data : {},
				dataType : 'json',
				success : function(res){
					console.log(res);
					$('.points-amount-value').append(res ? res.pointsAmount : 0);
					
					wx.onMenuShareAppMessage({
		                title: share.sharetitle, 
		                desc: '我的积分明细', 
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
		                title: '我的积分明细',
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
			
			$.ajax({
				url : server.basepath + 'userAction/getUserPointsDetail',
				data : {},
				dataType : 'json',
				success : function(res){
					console.log(res);
					if(res.length){
						$('.points-detail-items').show();
						var items = '';
						$.each(res,function(idx,itm){
							items += points.creatPointsDetail(this);
						});
						$('.points-detail-item').append(items);
					}else{
						$('.points-detail-null').show();
					}
				},
				error : function(){
					
				}
			});
		},
		creatPointsDetail : function(item){
			return '<li class="item-content">' + 
						'<div class="item-media"><i class="icon icon-f7"></i></div>' + 
							'<div class="item-inner">' + 
								'<div class="item-title">' + 
									'<p class="points-detail-title">' + item.pointsFrom + '</p>' + 
									'<p class="points-detail-date">' + item.pointsDate + '</p>' + 
								'</div>' + 
								'<div class="item-after"><span class="' + (item.pointsDetail > 0 ? 'points-detail-income' : 'points-detail-expenses') + '">' + (item.pointsDetail > 0 ? '+' : '-') + item.pointsDetail +'</span></div>' + 
							'</div>' + 
						'</li>';	
		}

};

wx.ready(function(){
	points.init();
});
