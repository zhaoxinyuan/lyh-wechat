(function($) {
    var $ajax = $.ajax;

    $.ajax = function(opt) {
        var fn = {
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                },
            success: function(data, textStatus) {
                }
        };
        
        if(opt.data){
        	opt.data.now =  Math.uuid(32) + Math.ceil(Math.random()*1000);
        }else{
        	opt.data = {
        			now : Math.uuid(32) + Math.ceil(Math.random()*1000)
        	}
        }
        
        opt.ifModified = true;
        
        opt.beforeSend = function(xmlHttp){ 
            xmlHttp.setRequestHeader("If-Modified-Since","0"); 
            xmlHttp.setRequestHeader("Cache-Control","no-cache");
        },
        opt.cache = false;
        
        opt.error ? fn.error = opt.error : function() {};
        opt.success ? fn.success = opt.success : function() {};
        
        opt.error = function() {};
        opt.success = function() {};
        $.showIndicator();

        var $opt = $.extend(opt, {
            error: function(XMLHttpRequest, textStatus, errorThrown) {
            	$.hideIndicator();
            },
            success: function(data, textStatus) {
            	fn.success(data, textStatus);
            	$.hideIndicator();
            }
        });
        $ajax($opt);
    };

})(Zepto);