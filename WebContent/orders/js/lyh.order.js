var orders = {
	tab : '',
	init : function() {
		/*
		$(document).on('click', '.button-success', function() {
			$.confirm('是否确认收货?', function() {
				//$.alert('You clicked Ok button');
			}, function() {
				//$.alert('You clicked Cancel button');
			});
		});*/
		
		this.tab = $.fn.getUrlParam('tab');
		
		$('.tab-link').click(function(){
			$('#' + $(this).attr('data-table-id')).empty();
			orders.getOrders($(this));
		});
		
		this.tab ? $('.' + this.tab).click() : $($('.buttons-tab').find('a')[0]).click();
	},
	getOrders : function(tab){
		$.ajax({
			url : server.basepath + 'orderAction/getOrders',
			data : {
				statusCode : tab.attr('data-order-status')
			},
			dataType : 'json',
			success : function(res){
				if(res.length){
					var ordersHtml = '';
					$.each(res,function(idx,itm){
						ordersHtml += orders.createOrderInfo(this);
					});
					$('#' + tab.attr('data-table-id')).append(ordersHtml);
					$('.order-product').off().on('click',function(){
						var $this = $(this);
						$.get(server.basepath + 'product/product.jsp?productid=' + $this.data('productid'), function( response, status, xhr ) {
							$('.popup-product').html(response);
							$.getScript(server.basepath + 'resources/swiper/dist/js/swiper.min.js',function(data){
								$.getScript(server.basepath + 'resources/js/plugin/zepto.fx_methods.js',function(data){
									$.getScript(server.basepath + 'product/js/lyh.product.js',function(data){
										product.productid = $this.data('productid');
										product.init();
										$.popup('.popup-product');
									});
								});
							});
							$.popup('.popup-product');
						});
					});
					
					orders.addOrderButtonEvents();
				}
				wx.onMenuShareAppMessage({
	                title: share.sharetitle, 
	                desc: '我的订单', 
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
	                title: '我的订单',
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
	createOrderInfo : function(item){
		return '<div class="card">' + 
					'<div class="card-header">' + 
						'<div>' + 
							'<span class="order-orderno-title">订单号&nbsp;&nbsp;</span>' + 
							'<span class="order-orderno">' + item.orderNo + '</span>' + 
						'</div>' + 
						'<div class=" order-status">' + item.orderStatus.statusName +'</div>' + 
					'</div>' + 
				'<div class="card-content">' + 
					'<div class="list-block media-list">' + 
						'<div class="card-content order-product" data-productid="'+item.orderProduct.productId+'">' + 
							'<div class="card-content-inner row">' + 
								'<div class="col-20 order-product-image" style="background-image: url('+server.productImagePath + item.orderProduct.productImageurl+');"></div>' +
								'<div class="col-60 order-product-info">' + 
									'<div class="order-product-name">' + item.orderProduct.productName + '</div>' +
									'<div class="order-product-spec">' + item.orderProductSpec + '</div>' + 
								'</div>' + 
								'<div class="col-20 text-right">' + 
									'<div class="order-product-price"><i class="fa fa-rmb"></i>&nbsp;' + item.orderProduct.productPrice.toFixed(2) + '</div>' +
									'<div class="order-product-qty">' + '× ' + item.orderProductQty +  '</div>' +
								'</div>' + 
							'</div>' + 
							'<div class="col-100 text-right order-product-total border-b">' + 
								'共' + item.orderProductQty + '件商品&nbsp;合计：<i class="fa fa-rmb"></i>&nbsp;' + item.orderProductAmt.toFixed(2) + '&nbsp;(含运费 <i class="fa fa-rmb"></i>&nbsp;' + item.orderProduct.productExpressPrice.toFixed(2) + ')' + 
							'</div>' + 
						 '</div>' + 
					'</div>' + 
				'</div>' + 
				(item.orderStatus.statusCode == 'status_02' || item.orderStatus.statusCode == 'status_05' ? '' : ('<div class="card-footer">' + orders.createOrderButton(item) + '</div>')) + 
			'</div>';						
	},
	createOrderButton : function(item){
		var statusCode = item.orderStatus.statusCode;
		if(statusCode == 'status_01'){
			return '<a href="#" class="order-button button button-succes button-right order-pay-button" data-order-no="' + item.orderNo + '" data-order-amt="' + item.orderProductAmt + '" >去付款</a>' +
				   '<a href="#" class="order-button button button-danger button-right order-cancel-button" data-order-status="status_02" data-order-id="' + item.orderId + '">取消订单</a>' ;
		}else if(statusCode == 'status_03'){
			return '<a href="#" class="order-button button button-success button-warning order-remind-button">提醒发货</a>';
		}else if(statusCode == 'status_04'){
			return '<a href="#" class="order-button button button-right order-express-button" data-order-expressno="' + item.orderExpress.expressNo + '"  data-order-id="' + item.orderId + '">查看物流</a>' +
			   	   '<a href="#" class="order-button button button-right button-success order-received-button" data-order-status="status_05" data-order-id="' + item.orderId + '">确认收货</a>' ;
		}
		return '';
	},
	addOrderButtonEvents : function(){
		$('.order-pay-button').off().on('click',function(){
			forward('pay/pay.jsp?orderno=' + $(this).attr('data-order-no') + '&orderamt=' + $(this).attr('data-order-amt'));
		});
		
		$('.order-cancel-button').off().on('click',function(){
			var $this = $(this);
			$.confirm('是否确取消订单?', function() {
				orders.updateOrderStatus($this);
			}, function() {
			});
		});
		
		$('.order-remind-button').off().on('click',function(){
			var $this = this;
			$.alert('已提醒发货',function(){
				$($this).html('已提醒发货').addClass('disabled').off();
			});
		});
		
		$('.order-express-button').off().on('click',function(){
			forward('http://m.kuaidi100.com/index_all.html?type=youshuwuliu&postid=' + $(this).attr('data-order-expressno') + '&callbackurl=' + window.location.href,true);
		});
		
		$('.order-received-button').off().on('click',function(){
			orders.updateOrderStatus($(this));
		});
		
	},
	payOrder : function(){
		
	},
	updateOrderStatus : function(btn){
		$.ajax({
			url : server.basepath + 'orderAction/changeOrderStatus',
			data : {
				orderId : btn.attr('data-order-id'),
				orderStatusCode : btn.attr('data-order-status')
			},
			dataType : 'json',
			success : function(res){
				window.location.reload();
			},
			error : function(){
				
			}
		});
	}	
};

wx.ready(function(){
	orders.init();
});