var edit = {
		addressid : 0,
		orderid : '',
		init: function(){
			  this.addressid = parseInt($.fn.getUrlParam('addressid'));
			  this.orderid = $.fn.getUrlParam('orderid');
			  
			  this.addressid ? this.getAddress() : $('.address-delete-list').hide();
			  
			  $('.btn-saveaddress').click(function(){
				  edit.saveAddress(edit.addressid ? 'updateAddress' : 'saveAddress'); 
			  });
			
			  $("#address_area").cityPicker({
				    toolbarTemplate: '<header class="bar bar-nav">\
				    						<button class="button button-link pull-right close-picker">确定</button>\
				    						<h1 class="title">选择收货地址ַ</h1>\
				    				 </header>'
			  });
			  
			  
			  
			  $(document).on('click','.address-delete-list', function () {
			      var buttons1 = [
			        {
			          text: '请选择',
			          label: true
			        },
			        {
			          text: '删除',
			          bold: true,
			          color: 'danger',
			          onClick: function() {
			            edit.deleteAddress();
			          }
			        },
			      ];
			      var buttons2 = [
			        {
			          text: '取消',
			          bg: 'danger'
			        }
			      ];
			      var groups = [buttons1, buttons2];
			      $.actions(groups);
			  });
		},
		saveAddress : function(url){
			if($('.myvalidate').myVerification()){
				return;
			}
			
			$.ajax({
				url : server.basepath + 'userAddressAction/' + url,
				data : {
					addressId : edit.addressid ? edit.addressid : 0,
					addressProvincename : $('#address_area').val().split(' ')[0],
					addressCityname : $('#address_area').val().split(' ')[1],
					addressCountyname : $('#address_area').val().split(' ')[2],
					addressStreet : $('#address_street').val(),
					addressName : $('#address_name').val(),
					addressMobile : $('#address_mobile').val(),
					addressDefault : ($('#address_default').is(':checked') ? 1 : 0),
					addressPost : $('#address_post').val()
				},
				dataType : 'json',
				success : function(res){
					if(!edit.orderid){
						forward('myaccount/orderaddress/orderAddress.jsp');
					}else{
						$.ajax({
							url : server.basepath + 'orderAction/chenageAddress',
							data : {
								orderid : edit.orderid
							},
							dataType : 'json',
							success : function(res){
								forward('orders/submitOrder.jsp?orderid=' + edit.orderid);
							},
							error : function(){
								
							}
						});
					}
					
				},
				error : function(){
					
				}
			});
		},
		getAddress : function(){
			$.ajax({
				url : server.basepath + 'userAddressAction/getAddress',
				data : {
					addressId : edit.addressid
				},
				dataType : 'json',
				success : function(res){
					wx.onMenuShareAppMessage({
		                title: share.sharetitle, 
		                desc: '编辑收货地址', 
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
		                title: '编辑收货地址',
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
											
					$('#address_name').val(res.addressName);
					$('#address_mobile').val(res.addressMobile);
					$('#address_area').val(res.addressProvincename + ' ' + res.addressCityname + ' ' + res.addressCountyname);
					$('#address_post').val(res.addressPost);
					$('#address_street').val(res.addressStreet);
					 
					if(res.addressDefault){
						$('#address_default').attr('checked','checked');
						$('.address-default-list').hide();
					}
					
					if(!edit.addressid){
						$('.address-delete-list').hide();
					}
					
				},
				error : function(){
					
				}
			});
		},
		deleteAddress : function(){
			$.ajax({
				url : server.basepath + 'userAddressAction/deleteAddress',
				data : {
					addressId : edit.addressid
				},
				dataType : 'json',
				success : function(res){
					forward('myaccount/orderaddress/orderAddress.jsp');
				},
				error : function(){
					
				}
			});
		}
};

//edit.init();

wx.ready(function(){
	edit.init();
});
