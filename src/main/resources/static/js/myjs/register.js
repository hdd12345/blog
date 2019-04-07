
$(function(){
	
	$("#register-label").show();
	$("#toregister-div").hide();
	$("#tosearch-div").hide();
	$.validator.addMethod("checkUsername",function(value, element){
		var flag = true;
		$.ajax({
			url:"/blog/user/isExist",
			type:"post",
			async:false,
			dataType:"json",
			data:{
				"username":value
			},
			success:function(result){
				flag = result;
			}
		});
		return flag;
	},"用户名已存在！");
	

		$("#register-form").validate({
			rules:{
				"username":{				
					required:true,
					checkUsername:true
				},
				"email":{
					required:true,
					email:true
				},
				"password":{
					required:true,
					rangelength:[6,16]
				},
				"repassword":{
					required:true,
					rangelength:[6,16],
					equalTo:"#password"
				}
			},
			messages:{
				"username":{
					required:"用户名不能为空！"
				},
				"email":{
					required:"邮箱不能为空！",
					email:"邮箱格式不正确！"
				},
				"password":{
					required:"密码不能为空！",
					rangelength:"密码控制在6~16位！"
				},
				"repassword":{
					required:"请确认密码！",
					rangelength:"密码控制在6~16位！",
					equalTo:"两次密码不一致！"
				}
			},
			errorElement:"em",
			errorPlacement : function(error, element) { //指定错误信息位置
				error.insertAfter(element);
			},
			submitHandler:function (form){
				var sex = $("input[name='sex']:checked").val(); 
				$.ajax({
					url:"/blog/user/register",
					type:"post",
					dataType:"json",
					contentType:"application/json",
					data:JSON.stringify({
						"username":$("#username").val(),
						"password":$("#password").val(),
						"email":$("#email").val(),
						"sex":sex
					}),
					success:function(result){
						if(result>0){
							layer.msg("注册成功！即将跳转至登录页面...");
							setTimeout(function(){
								window.location.href="/blog/tologin";
							},2000);
						}else{
							layer.msg("注册失败！");
						}
					},
					error:function(result){
						layer.msg("注册失败！");
					}
				});
			}
		});
});