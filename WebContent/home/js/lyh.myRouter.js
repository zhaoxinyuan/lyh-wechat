$(function () {
	myRouter.init();
});

var myRouter = {
	init : function(){
		$('.page-topointsmall').on('click',function(){
			mall.init();
			$.router.load('#page_pointsmall');
		});
		
		var productid = $.fn.getUrlParam('productid');
		if(productid){
			var productPanle = myRouter.openProduct(productid);
			new productMaster(productid);
			$.router.load('#' + 'page_product_' + productid,true);
		}
	},
	openProduct : function(productid){
		$('.page-group').append('<div class="page" id="page_product_' + productid + '">' + 
									'<div class="product">' + 
										'<div class="wrapper" id="wrapper_info_' + productid + '">' + 
											'<div class="scroller">' +
												'<div class="swiper-container swiper-container-product" data-space-between="10">' + 
													'<div class="swiper-wrapper border-b"></div>' +
													'<div class="pagination"></div>' +
												'</div>' + 
												'<div class="product-info hide">' + 
													'<div class="product-info-name"></div>' + 
													'<div class="product-info-title" >市场价</div>' +
													'<div class="product-info-mallprice" ></div>' + 
													'<div class="product-info-title">抢购价</div>' +
													'<div class="product-info-price"></div>' + 
													'<div class="product-info-title">物流费</div>' + 
													'<div class="product-info-expressprice"></div>' + 
													'<div class="product-info-title">服务</div>' +
													'<div class="product-info-service">由零元汇商城提供优质服务</div>' + 
												'</div>' + 
												'<div class="product-spec list-block hide">' + 
													'<ul>' +
														'<li class="item-content item-link">' + 
															'<div class="item-inner">' + 
																'<div class="item-title">选择</div>' +
																'<div class="item-after"></div>' +
															'</div>' +
														'</li>' +
													'</ul>' + 
												'</div>' +
												'<div class="product-like hide">' +
													'<div class="list-block">' + 
														'<ul>' + 
															'<li class="item-content">' + 
																'<div class="item-inner">' + 
																	'<div class="item-title">热门推荐</div>' + 
																	'<div class="item-after"></div>' +
																'</div>' + 
															'</li>' +
														'<ul>' + 
													'</div>' +
													'<div class="product-like-items row"></div>' +
												'</div>' + 
												'<div class="product-todetail hide">' + 
													'<div class="border-t modular-title-line"></div>' + 
													'<div class="modular-title"><i class="fa fa-angle-up"></i>&nbsp;查看图文详情</div>' + 
													'<div class="border-t  modular-title-line"></div>' +
												'</div>' +
											'</div>' +
										'</div>' +
									'</div>' +
									'<div class="product-detail hide" >' + 
										'<div class="product-detail-upload-msg upload-msg"><i class="fa fa-arrow-up"></i>&nbsp;上拉返回商品详情</div>' + 
										'<div class="wrapper" id="wrapper_detail_' + productid + '">' +
											'<div class="scroller">' + 
												'<div class="buttons-tab">' + 
													'<a href="#" tab="product_detail_photo" class="tab-link active button">图文详情</a>' + 
													'<a href="#" tab="product_detail_spec" class="tab-link button">规格参数</a>' + 
												'</div>' + 
												'<div class="content-block">' +
													'<div class="tabs">' + 
														'<div class="tab active product_detail_photo">' + 
															'<div class="product-detail-imgs"></div>' +
														'</div>' + 
														'<div class="tab product_detail_spec">' + 
															'<div class="content-block product-detail-specs">' + 
																'<div class="list-block">' + 
																	'<ul>' +
																		'<li class="item-content">' +
																			'<div class="item-inner product-detail-spec">' + 
																				'<div class="item-title row"></div>' + 
																			'</div>' + 
																		'</li>' + 
																	'</ul>' + 
																'</div>' + 
															'</div>' +	
														'</div>' +						
													'</div>' +	
												'</div>' +
											'</div>' +
										'</div>' +	
									'</div>' +	
									'<div class="product-button row no-gutter">' +
										'<span class="col-40 product-button-toindex row no-gutter">' + 
											'<a class="col-50 product-button-menu product-button-index">' + 
												'<span class="product-button-menu-icon">' + 
													'<i class="fa fa-home"></i>' +
												'</span>' + 
												'<span class="col-50 product-button-title">' +
													'首页' + 
												'</span>' + 
											'</a>' + 
											'<a class="col-50 product-button-menu product-button-back back">' +
												'<span class="product-button-menu-icon">' +
													'<i class="fa fa-angle-left"></i>' +
												'</span>' +
												'<span class="col-50 product-button-title">' + 
													'返回' + 
												'</span>' + 
											'</a>' + 
										'</span>' + 
										'<span class="col-30 product-button-followus">关注我们</span>' + 
										'<span class="col-30 product-button-buy">立即领取</span>' + 
									'</div>' + 
									'<div class="product-spec-list hide">' +
										'<div class="row no-gutter">' + 
											'<div class="col-20 product-spec-image"></div>' +
											'<div class="col-80">' +
												'<div class="product-spec-close"><i class="fa fa-close"></i></div>' +
												'<div class="product-spec-info">' +
													'<div class="product-spec-info-name"></div>' + 
													'<div class="product-spec-info-msg">请选择</div>' +
												'</div>' + 
											'</div>' + 
										'</div>' +
										' <div class="product-spec-fixed">' +
											'<a href="#" class="button button-fill button-danger button-big button-fixed">确定</a>' + 
										'</div>' + 
									'</div>' +	
								'</div>' + 
							'</div>'	
		);
		
		return 'page_product_' + productid;
	},
	openPointsmall : function(){
		mall.init();
	}
};

function iScrollClick(){
	if (/iPhone|iPad|iPod|Macintosh/i.test(navigator.userAgent)) return false;
	if (/Chrome/i.test(navigator.userAgent)) return (/Android/i.test(navigator.userAgent));
	if (/Silk/i.test(navigator.userAgent)) return false;
	if (/Android/i.test(navigator.userAgent)) {
	   var s=navigator.userAgent.substr(navigator.userAgent.indexOf('Android')+8,3);
	   return parseFloat(s[0]+s[3]) < 44 ? false : true
    }
}
