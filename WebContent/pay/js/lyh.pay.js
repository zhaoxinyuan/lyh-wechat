var pay = {
		orderno : '',
		orderamt : 0,
		platform : 0,
		init: function(){
			this.orderno = $.fn.getUrlParam('orderno');
			this.orderamt = $.fn.getUrlParam('orderamt');
			
			$('.pay-orderno').append(this.orderno);
			$('.pay-orderamount').append('<i class="fa fa-rmb fa-fw"></i>' + this.orderamt);
			
			$('.pay-button').click(function(){
				pay.payOrder();
			});
			
			this.getPlayform();
		},
		getPlayform : function(){
			$.ajax({
				url : server.basepath + 'payAction/getAllPlatform',
				data : {
					orderid : this.orderid
				},
				dataType : 'json',
				success : function(res){
					console.log(res);
					var platformHtml = '';
					$.each(res,function(idx,itm){
						platformHtml += pay.createPlatform(this);
					});
					$('.platform-panel').find('ul').append(platformHtml);
					
					$('.pay-platform-radio').iCheck({
						checkboxClass: 'icheckbox_square-blue',
			            radioClass: 'iradio_square-blue',
			            increaseArea: '20%'
					});
					
					$('.pay-platform').on('ifChecked',function(e){
						pay.platform = $(this).find('.pay-platform-radio').val();
					});
					
					$('.pay-platform').on('click',function(){
						$(this).find('.pay-platform-radio').iCheck('check');
					});
					
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
					
				},
				error : function(){
					
				}
			});
		},
		createPlatform : function(item){
			return '<li class="item-content pay-platform">' + 
						'<div class="item-media"><img src="' + server.basepath + 'pay/img/' + item.platformCode + '.png" style="width: 31px;"/></div>' +
						'<div class="item-inner">' + 
							'<div class="item-title">' + item.platformName + '</div>' + 
							'<div class="item-after"><input class="pay-platform-radio" name="platform" type="radio" value="' + item.platformPayurl + '"/></div>' + 
						'</div>' + 
					'</li>';	
		},
		payOrder : function(){
			$.ajax({
				url : server.basepath + 'payAction/' + this.platform,
				data : {
					orderno : this.orderno
				},
				dataType : 'json',
				success : function(res){
					console.log(res);
					forward('pay/wechatpay/submitPay.jsp?orderno=' + pay.orderno);
				},
				error : function(){
					
				}
			});
		}
};

wx.ready(function(){
	pay.init();
});
