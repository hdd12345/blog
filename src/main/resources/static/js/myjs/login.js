$(function (){
	$("#login-label").show();
	$("#tologin-div").hide();
	$("#tosearch-div").hide();
	$("#login").on("click",function(){
		$.ajax({
			url:"/blog/user/login",
			type:"post",
			contentType:"application/json",
			data:JSON.stringify({
				"username":$("#username").val(),
				"password":$("#password").val()
			}),
			success:function(result){
				if(result==1){
					window.location.href="/blog";
				}else{
					layer.msg("用户名或密码错误！");
				}
			},
			error:function(result){
				layer.msg("登录失败！");
			}
		});
	});
});

