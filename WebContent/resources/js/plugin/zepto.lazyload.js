(function(root, factory) {
	if (typeof define === 'function' && define.amd) {
		define(['$'], factory);
	} else if (typeof exports === 'object') { //umd
		module.exports = factory();
	} else {
		root.lazyload = factory(window.Zepto || window.jQuery || $);
	}
})(this, function($) {
	$.fn.lazyload = function(settings) {
		var ll = new lazyload();
		var options = $.extend({
			elements: $(this)
		}, settings);
		ll.init(options);
		return ll;
	};

	function lazyload() {
		this.loadImg = 'data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAANSURBVBhXYzh8+PB/AAffA0nNPuCLAAAAAElFTkSuQmCC';
		this.settings = {
			container: window,
			effect: 'show',
			effectArgs: null,
			elements: null,
			load: null,
			offset: 0,
			event: 'scroll'
		};
	}
	lazyload.prototype = {
		init: function(settings) {
			this.settings = $.extend(this.settings, settings);
			this.elements = $(this.settings.elements);
			this.loadImg = this.settings.loadImg || this.loadImg;
			this.bindEvent();
			if (this.settings.event == "scroll") {
				this.load();
			}
			this.initImg();
		},
		initImg: function() {
			var _this = this;
			this.elements.each(function() {
				var $this = $(this);
				if(!$this.attr('inited')){
					if ($this.is('img')) {
						$this.attr('src', _this.loadImg);
						
					} else {
						$this.css('background-image', "url('" + _this.loadImg + "')");
					}
					$this.attr('inited',true);
				}
			});
		},
		bindEvent: function() {
			var container = $(this.settings.container);
			var _this = this;
			container.on(_this.settings.event, function() {
				_this.load();
			});
			
			indexScroll.on('scroll',function(){
				_this.load();		 
			 });
		},
		load: function() {
			var _this = this;
			this.elements.each(function() {
				if (this.loaded) {
					return;
				}
				if (_this.checkPosition(this)) {
					_this.show(this);
				}
				_this.settings.load && _this.settings.load.call(_this, this)
			});
		},
		checkPosition: function(img) {
			var offsetTop = $(img).offset().top;
			var clientHeight = window.clientHeight || document.documentElement.clientHeight || document.body.clientHeight; //可视区域
			var clientWidth = window.clientWidth || document.documentElement.clientWidth || document.body.clientWidth;
			var scrollTop = $(window).scrollTop();
			if (offsetTop + this.settings.offset <= clientHeight + scrollTop) {
				return true;
			}
			return false;
		},
		show: function(img) {
			var _this = this;
			var $this = $(img);
			var self = img;
			self.loaded = false;
			var original = $this.attr('data-src');
			var loaded = $this.attr('loaded');
			if(!loaded){
				$('<img/>').attr('src', original).on('load', function() {
					self.loaded = true;
					$this.hide();
					if ($this.is('img')) {
						 setTimeout(function(){
							 $this.attr('src', original);
							 _this.settings.callback ? _this.settings.callback() : '' ;
						 }, 500); 
						
					} else {
						setTimeout(function(){
							$this.css('background-image', "url('" + original + "')");
							 _this.settings.callback ? _this.settings.callback() : '' ;
						 }, 500); 
					}
					$this.attr('loaded',true);
					$this[_this.settings.effect](_this.settings.effectArgs);
				});
			}
			
		}
	}
	return lazyload;
});