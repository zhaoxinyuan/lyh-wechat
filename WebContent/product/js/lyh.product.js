function productMaster(productid){
	var product = {
			panel : '', 
			popup : true,
			productid : 0,
			productData : new Object(),
			mySwiper : new Object(),
			spec : '',
			detailPhotoHeight : 0,
			toDetail : false,
			toInfo : false,
			productInfoScroll : null,
			productDetailScroll : null,
			productImgs : new Array(),
			myPhotoBrowserStandalone : new Object(),
			init: function(){
				this.panel = $('#' + 'page_product_' + product.productid);
				
				//this.productid = $.fn.getUrlParam('productid');
				
				$(product.panel).on('mouseup',function(e){
					if( product.toDetail){
			    		 product.toDetail = false; 
			    		 product.panel.find(".product-detail").find('.wrapper').animate({ top : '0px'}, 300);
			    		 product.panel.find(".product").find('.wrapper').animate({bottom : '9999px'},300);
			    		setTimeout(function(){
			    			product.initProductIScroll.detail();
				    		product.productDetailScroll.refresh();
			    		}, 500)
			    	 }
					
					 if( product.toInfo){
			    		 product.toInfo = false;
			    		 product.panel.find('.product-detail-upload-msg').css({'line-height' : 0 + 'px','display' : 'none'});
			    		 product.panel.find('.product-detail').find('.wrapper').animate({top : '9999px'},300);
			    		 product.panel.find(".product").find('.wrapper').animate({bottom : '0px'}, 300);
			    	 }
				});
				
				$(product.panel).on('touchend',function(e){
					if( product.toDetail){
			    		 product.toDetail = false; 
			    		 product.panel.find(".product-detail").find('.wrapper').animate({ top : '0px'}, 300);
			    		 product.panel.find(".product").find('.wrapper').animate({bottom : '9999px'},300);
			    		setTimeout(function(){
			    			product.initProductIScroll.detail();
				    		product.productDetailScroll.refresh();
			    		}, 500)
			    	 }
					
					 if( product.toInfo){
			    		 product.toInfo = false;
			    		 product.panel.find('.product-detail-upload-msg').css({'line-height' : 0 + 'px','display' : 'none'});
			    		 product.panel.find('.product-detail').find('.wrapper').animate({top : '9999px'},300);
			    		 product.panel.find(".product").find('.wrapper').animate({bottom : '0px'}, 300);
			    	 }
				});
			
				product.panel.find('.product-detail').find('.wrapper').css({top : '9999px'});
				product.panel.find('.product-detail-upload-msg').css({'display' : 'none'});
				
				product.panel.find('.product-button-index').on('click',function(){
					if(signuser.userid == 'null'){
						forward('http://mp.weixin.qq.com/s?__biz=MzA3ODMzMDc1MQ==&mid=401626688&idx=1&sn=400d52d33f9f97e132548762c8027dab&scene=0&previewkey=YyKiz7h4aifQX9zQTANiL8NS9bJajjJKzz%2F0By7ITJA%3D#wechat_redirect',true);
					}else{
						$.router.load('#page_index');
					}
				});
				
				product.panel.find('.product-button-back').on('click',function(){
					setTimeout(function(){
						product.panel.remove();
					}, 500);
				});
				
				product.panel.find('.product-button-followus').on('click',function(){
					forward('http://mp.weixin.qq.com/s?__biz=MzA3ODMzMDc1MQ==&mid=401626688&idx=1&sn=400d52d33f9f97e132548762c8027dab&scene=0&previewkey=YyKiz7h4aifQX9zQTANiL8NS9bJajjJKzz%2F0By7ITJA%3D#wechat_redirect',true);
				});
				
				product.panel.find('.product-button-buy').on('click',function(){
					
					if(signuser.userid == 'null'){
						forward('http://mp.weixin.qq.com/s?__biz=MzA3ODMzMDc1MQ==&mid=401626688&idx=1&sn=400d52d33f9f97e132548762c8027dab&scene=0&previewkey=YyKiz7h4aifQX9zQTANiL8NS9bJajjJKzz%2F0By7ITJA%3D#wechat_redirect',true);
					}else if(product.spec == ''){
						$('.product-spec').click();
						product.panel.find(".product-spec-list").animate({height: '70%;',display : 'block'}, 300);
					}else{
						forward('orderAction/createorder?productid=' + product.productid + '&productspec=' + product.spec);
					}
				});
				
				product.panel.find('.product-spec').on('click',function(){
					product.panel.find(".product-spec-list").animate({height: '70%;',display : 'block'}, 300);
				});
				
				product.panel.find('.product-spec-close').on('click',function(){
					
				});
				
				product.panel.find('.button-fixed').on('click',function(){
					product.spec = '';
					if(product.panel.find('.label-list').find('.label-selected').length == product.productData.productSpecs.length){
						$.each(product.panel.find('.label-list').find('.label-selected'),function(idx,itm){
							product.spec += $(this).closest('.product-spec-detail').find('p').html() + ':' + $(this).html() + ';';
						});
					}
					product.panel.find(".product-spec-list").animate({height: '0px;',display : 'none'}, 300);
					product.panel.find('.product-spec-info-msg').empty().append('已选：' + product.spec);
					product.panel.find('.product-spec').find('.item-title').empty().append('已选：' + product.spec);
					forward('orderAction/createorder?productid=' + product.productid + '&productspec=' + product.spec);
				});		
				
				product.panel.find('.tab-link').off().on('click',function(){
					product.panel.find('.tab-link').removeClass('active');
					$(this).addClass('active');
					product.panel.find('.tab').removeClass('active');
					product.panel.find('.' + $(this).attr('tab')).addClass('active');
				});
				
				this.mySwiper = new Swiper(product.panel.find('.swiper-container-product'),{watchSlidesProgress : true,
					watchSlidesVisibility : true,
					longSwipesRatio : 0.1,
					onTransitionEnd : function(swiper){
						product.panel.find('.pagination').empty().append((swiper.activeIndex + 1) + '/' + product.productData.infoImgLenght);
						if(swiper.activeIndex == product.productData.infoImgLenght){
							
							product.panel.find(".product-detail").find('.wrapper').animate({ top : '0px'}, 300);
				    		 
				    		product.panel.find(".product").find('.wrapper').animate({bottom : '9999px'},300);
				    		 
				    		setTimeout(function(){
				    			product.initProductIScroll.detail();
					    		product.productDetailScroll.refresh();
					    		
					    		product.initProductIScroll.detail();
					    		product.productDetailScroll.refresh();
				    		}, 500)
						}
					},
					onTap : function(swiper){
						product.openPhotoBrowser(swiper);
					}
				});		
				this.getProductInfo();
			},
			getProductInfo : function(){
				$.ajax({
					url : server.basepath + 'productAction/getProduct',
					data : {
						productId : this.productid 
					},
					dataType : 'json',
					success : function(res){
						console.log(res);
						if(!res) return;

						product.productData = res;
						product.productData.infoImgLenght = 0;
						product.productData.detailImgLenght = 0;
						product.panel.find('.product-detail-imgs').empty();
						product.initProductIScroll.detail();
						$.each(res.productImage,function(idx,itm){
							if(this.imageType == 1){
								product.mySwiper.appendSlide('<div class="swiper-slide my-carousel">' + '<img src="' + server.productImagePath + this.imageUrl + '?v=' + new Date().getTime() +'"></div>');
								product.productData.infoImgLenght ++;
								product.productImgs.push(server.productImagePath + this.imageUrl);
							}else{
								product.panel.find('.product-detail-imgs').append('<img class="lazyload" id="page_product_'+product.productid+idx+'" data-src="'+server.productImagePath + this.imageUrl+ '?v=' + new Date().getTime() + '">');
								product.productData.detailImgLenght ++;
								product.preload(server.productImagePath +  this.imageUrl,$('#' + 'page_product_'+product.productid+idx));
							}
						});
						
						$('.lazyload').lazyload({
							container: $('.product-detail').find('.scroller'),
							effect: 'show',
							effectArgs: 'slow',
							loadImg: server.basepath + 'product/img/default.png',
							load: null,
							offset: 0
						});
						
						product.mySwiper.appendSlide('<div class="swiper-slide my-carousel swiper-slide-todetail"><div class="swiper-todetail" style="width : '+$(window).width()  + 'px'+';height : '+$(window).width()  + 'px'+'"><div class="swiper-todetail-icon"><i class="fa fa-arrow-circle-o-right"></i></div><div class="swiper-todetail-text">释放查看图文详情</div></div></div>');
						
						product.myPhotoBrowserStandalone = $.photoBrowser({
						      photos : product.productImgs,
						      theme: 'dark',
						      type: 'standalone'
						});
						
						product.panel.find('.pagination').empty().append(1 + '/' + product.productData.infoImgLenght);
						
						product.panel.find('.product-info-name').append('<strong>' + res.productName + '</strong>');
						product.panel.find('.product-info-mallprice').append('<s><i class="fa fa-rmb"></i>&nbsp;' + res.productMallPrice.toFixed(2) + '</s>');
						product.panel.find('.product-info-price').append('<i class="fa fa-rmb"></i>&nbsp;' + res.productPrice.toFixed(2));
						product.panel.find('.product-info-expressprice').append('<i class="fa fa-rmb"></i>&nbsp;' + res.productExpressPrice.toFixed(2));
						
						product.panel.find('.product-spec-info-name').append(res.productName);
						
						var specs = '';
						if(res.productSpecs.length){
							$.each(res.productSpecs,function(idx,itm){
								product.panel.find('.product-spec').find('.item-title').append('&nbsp;' + this.specTitle);
								product.panel.find('.product-spec-info-msg').append('&nbsp;' + this.specTitle);
								product.panel.find('.product-detail-spec').find('.item-title').append('<div class="col-20">' + this.specTitle + '</div>');
								product.panel.find('.product-detail-spec').find('.item-title').append('<div class="col-80">' + this.specName + '</div>');
								specs += '<div class="col-100 border-t product-spec-detail">' + 
											'<p>' + this.specTitle + '</p>' +
											'<div class="label-list">';
								$.each(this.specName.split(','),function(idx,itm){
									specs += '<label class="label spec_'+idx+'">'+this+'</label>';
								});
								specs += '</div></div>';
							});
							
							product.panel.find('.product-spec-list').append(specs);
						}else{
							product.spec = ' ';
							product.panel.find('.product-spec');
						}
						
						product.panel.find('.product-spec-image').css('background-image','url('+server.productImagePath + res.productImageurl+')');
						
						$('.label').on('click',function(){
							$(this).parent().find('.label').removeClass('label-selected');
							$(this).addClass('label-selected');
						});
						
						$.ajax({
							url : server.basepath + 'productAction/getProducts',
							data : {
								pageNo : 1,
								pageSize : 6
							},
							dataType : 'json',
							success : function(res){
								var products = '';
								$.each(res,function(idx,itm){
									products += '<div class="col-33 product-like-item" data-productid="' + this.productId + '">' + 
													'<div class="product-like-item-image border-radius" style="background-image : url('+server.productImagePath + this.productImageurl+ '?v=' + new Date().getTime() + ')"></div>' + 
													'<div class="product-like-item-name nowrap-flex">' + 
														'<strong>' + this.productName + '</strong>' + 
													'</div>' + 
													'<div class="product-like-item-price nowrap-flex">' + 
														'<i class="fa fa-rmb"></i>&nbsp;' + this.productPrice.toFixed(2) +  
													'</div>' + 
												'</div>';	
								});
								product.panel.find('.product-like-items').empty().append(products);
								product.panel.find('.product-like-item').on('click',function(){
									if($('#page_product_' + $(this).data('productid')).length == 0){
										var productPanle = myRouter.openProduct($(this).data('productid'));
										new productMaster($(this).data('productid'));
									}
									$.router.load('#' + 'page_product_' + $(this).data('productid'));
								});
								product.panel.find('.hide').removeClass('hide');								
								product.initProductIScroll.info();
							}
						});
						
						wx.onMenuShareAppMessage({
			                title: share.sharetitle, 
			                desc: res.productName, 
			                link: share.sharepath.replace('productCode',product.productid),
			                imgUrl: share.shareicon,
			                success: function () { 
			                    //alert('success');
			                },
			                cancel: function () { 
			                	//alert('cancel');
			                }
			            });
			            
			            wx.onMenuShareTimeline({
			                title: res.productName,
			                link: share.sharepath.replace('productCode',product.productid),
			                imgUrl: share.shareicon,
			                success: function () { 
			                    // 用户确认分享后执行的回调函数
			                },
			                cancel: function () { 
			                    // 用户取消分享后执行的回调函数
			                }
			            });
					}
				});
			},
			initProductIScroll : {
				info : function(){
					product.productInfoScroll = new IScroll('#wrapper_info_' + product.productid, {  
			            probeType: 2,//probeType：1对性能没有影响。在滚动事件被触发时，滚动轴是不是忙着做它的东西。probeType：2总执行滚动，除了势头，反弹过程中的事件。这类似于原生的onscroll事件。probeType：3发出的滚动事件与到的像素精度。注意，滚动被迫requestAnimationFrame（即：useTransition：假）。  
			            scrollbars: true,//有滚动条  
			            mouseWheel: true,//允许滑轮滚动  
			            fadeScrollbars: true,//滚动时显示滚动条，默认影藏，并且是淡出淡入效果  
			            bounce:true,//边界反弹  
			            interactiveScrollbars:true,//滚动条可以拖动  
			            shrinkScrollbars:'scale',// 当滚动边界之外的滚动条是由少量的收缩。'clip' or 'scale'.  
			            click: iScrollClick() ,// 允许点击事件  
			            keyBindings:true,//允许使用按键控制  
			            momentum:true// 允许有惯性滑动  
			        });
					
					product.productInfoScroll.on('scrollStart',function(){
						console.log();
					});
					
					product.productInfoScroll.on('scroll',function(){
						 if(this.y < (this.maxScrollY - 10)){
							 product.panel.find(".product-detail").find('.wrapper').css({'top' : (product.panel.find(".product").find('.wrapper').height() + this.y - this.maxScrollY) + 'px'});
						 }
						 if(this.y < (this.maxScrollY - 40)){
							 product.toDetail = true;
						 }
					 });
					 
					product.productInfoScroll.on('scrollEnd',function(){
						
				    });
				},
				detail : function(){
					 if(product.productDetailScroll) return;
					 product.productDetailScroll = new IScroll('#wrapper_detail_' + product.productid, {  
				            probeType: 2,//probeType：1对性能没有影响。在滚动事件被触发时，滚动轴是不是忙着做它的东西。probeType：2总执行滚动，除了势头，反弹过程中的事件。这类似于原生的onscroll事件。probeType：3发出的滚动事件与到的像素精度。注意，滚动被迫requestAnimationFrame（即：useTransition：假）。  
				            scrollbars: true,//有滚动条  
				            mouseWheel: true,//允许滑轮滚动  
				            fadeScrollbars: true,//滚动时显示滚动条，默认影藏，并且是淡出淡入效果  
				            bounce:true,//边界反弹  
				            interactiveScrollbars:true,//滚动条可以拖动  
				            shrinkScrollbars:'scale',// 当滚动边界之外的滚动条是由少量的收缩。'clip' or 'scale'.  
				            click: iScrollClick() ,// 允许点击事件  
				            keyBindings:true,//允许使用按键控制  
				            momentum:true// 允许有惯性滑动  
				     });
				     
					 product.productDetailScroll.on('scroll',function(){
						 if(this.y > 0){
							 product.panel.find('.product-detail-upload-msg').css({'line-height' : this.y + 'px','display' : 'block'});
							 if(this.y > 40){
								 product.toInfo = true; 
								 product.mySwiper.slideTo(0, 1000, false);
								 product.panel.find('.pagination').empty().append(1 + '/' + product.productData.infoImgLenght);
							 }
						 }
					 });
				     
					 product.productDetailScroll.on('scrollEnd',function(){
				    	
				     });
				}	
			},
			openPhotoBrowser : function(swiper){
				product.myPhotoBrowserStandalone.open();
				$('.photo-browser-close-link').on('click',function(){
					$('.photo-browser').remove();
				});
			},
			preload : function(url,$img){
				var img = new Image();
				img.src = url; 
				img.onload = function(){
					//product.panel.find('.product-detail').find('.product-detail-imgs').height();
					//$img.attr('src',img.src);
					$img.css('height',img.height + 'px');
		    		product.productDetailScroll.refresh();
				}
			} 
	};
	product.productid = productid;
	product.init();
}
/*
//$(function () {
wx.ready(function(){
	var productid = $.fn.getUrlParam('productid');
	if(productid){
		product.popup = false;
		product.productid = productid;
		$.getScript(server.basepath + 'resources/swiper/dist/js/swiper.min.js',function(data){
			product.init();
		});
	}
});*/