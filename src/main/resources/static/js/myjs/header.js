$(function(){
	$.ajax({
		url:"/blog/category/getAllCategory",
		type:"get",
		dataType:"json",
		success:function(result){
			var content = "";
			for(var i=0;i<result.length;i++){
				content+="<li class='nav-item active'><a class='nav-link' href='/blog/"+result[i].category_id+"'>"
						+result[i].name+"</a></li>";
			}
			$("#categoryList").html(content);
		},
		error:function(result){
			alert("请求超时！");
		}
	});
	
	$("#search-btn").on("click",function(){
		var keyword = $("#search-keyword").val();
		if(keyword == ""){
			layer.tips('请输入关键字！', '#search-keyword',{tipsMore: true});
		}else{
			window.location.href = "/blog/blog/search/"+keyword;
		}
	});
});