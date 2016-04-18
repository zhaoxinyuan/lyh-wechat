var edit = {
		editTypes : [{'type' : 'mobile','method' : 'createMobilEditer','valueid' : 'user_mobile','valuename' : 'userMobile','re' : /^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/},{'type' : 'email','method' : 'creatEmailEditer','valueid' : 'user_email','valuename' : 'userEmail','re' : /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/}],
		editType : '',
		editValue : '',
		editId : '',
		editItem : new Object(),
		init: function(){
			this.editType = $.fn.getUrlParam('edittype');
			this.editValue = $.fn.getUrlParam('editvalue');
			this.editId = $.fn.getUrlParam('userid');
			$.each(this.editTypes,function(idx,itm){
				if(this.type == edit.editType){
					edit[this.method]();
					edit.editItem = this;
				}
			});
			$('.btn-saveuserinfo').click(function(){
				edit.saveUserInfo();
			});
			
			wx.onMenuShareAppMessage({
                title: share.sharetitle, 
                desc: '编辑我的信息', 
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
                title: '编辑我的信息',
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
		createMobilEditer : function(){
			$('.title').append('绑定手机');
			$('.item-input').append('<input type="tel" id="user_mobile" placeholder="手机号码" value="' + (this.editValue ? this.editValue : '') + '"/>');
		},
		creatEmailEditer : function(){
			$('.title').append('绑定邮箱');
			$('.item-input').append('<input type="email" id="user_email" placeholder="邮箱" value="' + (this.editValue ? this.editValue : '') + '"/>');
		},
		saveUserInfo : function(){
			var $data = {
					userId : this.editId,
			};
			$data[this.editItem.valuename] = $('#' + this.editItem.valueid).val();
			if(!this.editItem.re.test($('#' + this.editItem.valueid).val())) return;
			$.ajax({
				url : server.basepath + 'userAction/updateUserDetail',
				data : $data,
				dataType : 'json',
				success : function(res){
					console.log(res);
					forward('myaccount/userinfo/myInfo.jsp');
				},
				error : function(){
					
				}
			});
		}
};

wx.ready(function(){
	edit.init();
});
