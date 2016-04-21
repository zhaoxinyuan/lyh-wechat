//wx.ready(function(){
$(function () {
	indexScroll = new IScroll('#wrapper_index', {  
        probeType: 1,//probeType：1对性能没有影响。在滚动事件被触发时，滚动轴是不是忙着做它的东西。probeType：2总执行滚动，除了势头，反弹过程中的事件。这类似于原生的onscroll事件。probeType：3发出的滚动事件与到的像素精度。注意，滚动被迫requestAnimationFrame（即：useTransition：假）。  
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
	
	indexScroll.on('scroll',function(){
		 if(this.y > 0){
			 $('#index_upload_msg').css({'line-height' : this.y + 'px'}); 
			 if(this.y > 50){
				 index.scrollOptions.loading = true;
			 }
		 }	 
	 });
	 
	indexScroll.on('scrollEnd',function(){
		if(index.scrollOptions.loading){
			$('#index_upload_msg').css({'line-height' : '50px'}).empty().append('<i class="fa fa-circle-o-notch fa-spin"></i>&nbsp;加载中');
			$('#wrapper_index').css({top : '50px;'});
			index.getProducts();
		}
		
		if(this.y < (this.maxScrollY + 30) && !index.loadend){
			 index.getProducts();
		 }	
		
		$('.lazyload').lazyload({
			container: $('#page_index'),
			effect: 'show',
			effectArgs: 'slow',
			loadImg: server.basepath + 'resources/img/default.jpg',
			load: null,
			offset: 0
		});
     });	
	
  index.init();
  $.init();
});

var index = {
		searchOptions : new Object(),
		scrollOptions : new Object(),
		loadend : false,
		categoryid : 0,
		init : function() {
			this.categoryid = $.fn.getUrlParam('categoryid');
			if(this.categoryid)
				$('.title').html(this.categoryid == 1 ? '零元区' : '精品区');
			
			$(".swiper-container-index").swiper({
				pagination : '.swiper-pagination',
				nextButton : '.swiper-button-next',
				prevButton : '.swiper-button-prev',
				paginationClickable : true,
				spaceBetween : 30,
				centeredSlides : true,
				autoplay : 2500,
				autoplayDisableOnInteraction : false
			});
			
			$('.home-category').click(function(){
				forward('category/product.jsp?categoryid=' + $(this).data('category'));
			});
			
			$('.index-topoints').click(function(){
				forward('pointsmall/pointsMall.jsp');
			});
			
			$('.icon-refresh').click(function(){
				$('.product-item').remove();
				index.searchOptions.pageNo = 1;
				index.getProducts();
			});
			
			this.searchOptions = {
					pageNo : 1,
					pageSize : 10
				};
				
			this.scrollOptions = {
					loading : false,
					maxLoadPage : 10,
			};
			
			this.getRTime();
			
			this.getProducts();
		},
		getProducts : function() {
			$.ajax({
				url : server.basepath + (this.categoryid ?  'productAction/getProductsByCategory' : 'productAction/getProducts'),
				data : {
					productCategoryid : this.categoryid,
					pageNo : this.searchOptions.pageNo,
					pageSize : this.searchOptions.pageSize
				},
				dataType : 'json',
				success : function(res){
					index.scrollOptions.loading = false;
					$('#index_upload_msg').css({'line-height' : '50px'}).empty().append('<i class="fa fa-arrow-down"></i>&nbsp;下拉即可刷新');
					$('#wrapper_index').css({top : '0px;'});
					
					var productPanel = '';
					
					if(res.length < index.searchOptions.pageSize){
		                 $('.infinite-scroll-preloader').remove();
		                 index.loadend = true;
					}
					
					$.each(res,function(idx,itm){
						productPanel += index.createProductPanel(this);
					});
					
					$('.product-items').append(productPanel);					
					
					
					indexScroll.refresh();
					
					$('.lazyload').lazyload({
						container: $('#page_index'),
						effect: 'show',
						effectArgs: 'slow',
						loadImg: server.basepath + 'resources/img/default.jpg',
						load: null,
						offset: 0
					});
					
					$('.product-item').off().on('click',function(e){
						var $this = $(this);
						if($('#page_product_' + $this.data('productid')).length == 0){
							var productPanle = myRouter.openProduct($this.data('productid'));
							new productMaster($this.data('productid'));
						}
						$.router.load('#' + 'page_product_' + $this.data('productid'));
						
					});
					
					index.searchOptions.pageNo += 1;
		            
		            wx.onMenuShareAppMessage({
		                title: share.sharetitle, 
		                desc: '零元汇首页', 
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
		                title: '零元汇首页',
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
		createProductPanel : function(item){
			return '<li class="item-content product-item" data-productid="' + item.productId + '">' + 
						'<div class="item-inner">' +
							'<div class="item-title">' + 
								'<div class="row" style="width: 104%">' + 
									'<div class="col-20 product-item-img lazyload" data-src="' + server.productImagePath + item.productImageurl + '?v=' + new Date().getTime() + '"></div>' + 
									'<div class="col-80">' + 
										'<div class="product-item-name"><strong>' + item.productName + '</strong></div>' + 
											'<div class="product-item-price"><i class="fa fa-rmb"></i>&nbsp;<strong>' + item.productPrice.toFixed(2) + '</strong>&nbsp;&nbsp;<s><i class="fa fa-rmb"></i>&nbsp;' + item.productMallPrice.toFixed(2) + '</s></div>' + 
											'<div class="row" style="width: 104%">' + 
												'<div class="col-50 product-item-buy"><strong>立即抢购</strong></div>' + 
												'<div class="col-50 product-item-date">零元汇&nbsp;&nbsp;' + item.productUpdatetime + '</div>' + 
											'</div>' + 
										'</div>' + 
									'</div>' + 
								'</div>' + 
							'</div>' + 
						'</li>';	
		},
		getRTime : function(){
			var nowtime = new Date();
			var endtime= new Date(new Date(nowtime.getFullYear(),nowtime.getMonth(),nowtime.getDay()).addDays(1));
	        var t =endtime.getTime() - nowtime.getTime();

	        var h=Math.floor(t/1000/60/60%24);
	        var m=Math.floor(t/1000/60%60);
	        var s=Math.floor(t/1000%60);
	        
	        
	        $('.product-promotion-countdown-time-hour').empty().append(h < 10 ? '0' + h : h);
	        $('.product-promotion-countdown-time-minute').empty().append(m < 10 ? '0' + m : m);
	        $('.product-promotion-countdown-time-second').empty().append(s <10 ? '0' + s : s);
	        
	        setTimeout("index.getRTime()",1000);
		}
	};
