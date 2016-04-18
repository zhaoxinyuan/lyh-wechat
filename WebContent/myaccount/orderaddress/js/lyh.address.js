var address = {
		type : 0,
		orderid : '',
		init: function(){
			this.type = $.fn.getUrlParam('type');
			this.orderid = $.fn.getUrlParam('orderid');
			
			$('.btn-address').click(function(){
				forward('myaccount/orderaddress/orderAddressEdit.jsp?addressid=0');
			});
			this.getAddressList();
		},
		getAddressList : function(){
			$.ajax({
				url : server.basepath + 'userAddressAction/getAddressList',
				data : {},
				dataType : 'json',
				success : function(res){
					var addresshtml = '';
					$.each(res,function(idx,itm){
						addresshtml += address.createAddress(this);
					});
					$('.content').append(addresshtml);
					
					$('.address-panel').on('click',function(){
						var $this = $(this);
						if(address.type){
							$.ajax({
								url : server.basepath + 'orderAction/chenageAddress',
								data : {
									orderid : address.orderid,
									addressid : $this.attr('data-address-id')
								},
								dataType : 'json',
								success : function(res){
									forward('orders/submitOrder.jsp?&orderid=' + address.orderid);
								}
							});
						}else{
							forward('myaccount/orderaddress/orderAddressEdit.jsp?addressid=' + $(this).attr('data-address-id'));
						}
					});
					wx.onMenuShareAppMessage({
		                title: share.sharetitle, 
		                desc: '管理收货地址', 
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
		                title: '管理收货地址',
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
		createAddress : function(item){
			return '<div class="card  border-b address-panel " data-address-id="'+item.addressId+'">' + 
						'<div class="card-content">' + 
							'<div class="card-content-inner">' + 
								'<div class="row">' + 
									'<div class="col-90">' + 
										'<div class="row">' + 
											'<div class="address-user-name col-50"><i class="fa fa-user order-address-icon fa-blue"></i>&nbsp;&nbsp;<strong>' + item.addressName + '</strong></div>' + 
												'<div class="address-user-phone col-50"><i class="fa fa-mobile fa-lg order-address-icon fa-blue"></i>&nbsp;&nbsp;' + item.addressMobile + '</div>' + 
												'<div class="col-100 address-user-detail">'+ (item.addressDefault ? '<span class="order-address-default">默认</span>' : '') + item.addressProvincename + item.addressCityname + item.addressCountyname + item.addressStreet +'</div>' +
											'</div>' +
										'</div>' + 
									'<div class="col-10">' + 
										(item.addressDefault ? '<i class="fa fa fa-check-circle fa-fw fa-2x icon-default-address"></i>' : '') + 
									'</div>' + 
								'</div>' + 
							'</div>' + 
						'</div>' + 
					'</div>';	
		}
};

wx.ready(function(){
	address.init();
});
