var order = {
	orderid : '',
	orderno : '',
	orderamt : 0,
	isAgree : false,
	init : function() {
		this.orderid = $.fn.getUrlParam('orderid');
		
		$('input').iCheck({
			checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%'
		});
		
		$('input').on('ifChecked',function(e){
			order.isAgree = true;
			$('.btn-submitorder').removeClass('disabled');
		});
		
		$('.address-default-panel').click(function(){
			forward('myaccount/orderaddress/orderAddress.jsp?type=1&orderid=' + order.orderid);
		});
		
		$('.btn-submitorder').click(function(){
			order.submitOrder();
		});
		
		$('.order-error').hide();
		
		this.getOrder();
	},
	getOrder : function(){
		$.ajax({
			url : server.basepath + 'orderAction/getOrderInfo',
			data : {
				orderid : this.orderid
			},
			dataType : 'json',
			success : function(res){
				if(res){
					console.log(res);
					
					if(!res.orderAddress.addressId){
						 $.alert('您还未添加收货地址，请先添加收货地址', '提示', function () {
							 forward('myaccount/orderaddress/orderAddressEdit.jsp?orderid='+order.orderid);
					     });
					}else{
						order.orderno = res.orderNo;
						order.orderamt = res.orderTotalAmount;
						
						$('.order-address-user-name').append('<i class="fa fa-user fa-blue"></i>&nbsp;&nbsp;' + res.orderAddress.addressName);
						$('.order-address-user-phone').append('<i class="fa fa-mobile fa-lg fa-blue"></i>&nbsp;&nbsp;' + res.orderAddress.addressMobile);
						$('.order-address-user-detail').append((res.orderAddress.addressDefault ? '<span class="order-address-default">默认</span>' : '') + res.orderAddress.addressProvincename + res.orderAddress.addressCityname + res.orderAddress.addressCountyname + res.orderAddress.addressStreet);
						
						$('.order-product-img').css('background-image','url(' + server.productImagePath + res.orderProducts.productImageurl + '?v=' + new Date().getTime()+')');
						$('.order-product-name').append(res.orderProducts.productName);
						$('.order-product-qty').append('× ' + res.orderProducts.qty);
						$('.order-product-price').append('<i class="fa fa-rmb fa-fw"></i>' + res.orderProducts.productPrice.toFixed(2));
						$('.order-product-spec').append(res.orderProducts.productSpec);
						$('.order-product-amount').append('<i class="fa fa-rmb fa-fw"></i>' + res.orderTotalAmount.toFixed(2));
						$('.order-product-expressPrice').append('<i class="fa fa-rmb fa-fw"></i>' + res.orderProducts.productExpressPrice.toFixed(2) + ')');
						
					}
				}else{
					$('.order-error').show();
					$('.orders-detail').hide();
				}
				
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
	submitOrder : function(){
		if(this.isAgree){
			$('.btn-submitorder').off();
			
			$.ajax({
				url : server.basepath + 'orderAction/submitOrder',
				data : {
					orderid : this.orderid
				},
				dataType : 'json',
				success : function(res){
					console.log(res);
					forward('pay/pay.jsp?orderno=' + res.orderNo + '&orderamt=' + res.orderProductAmt);
				},
				error : function(){
					
				}
			});
		}
	}
};


wx.ready(function(){
	order.init();
});