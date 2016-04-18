var forward = function(url,basepath){
	window.location.href = (basepath ? '' : server.basepath) + url;
};