$(function(){
	//show reply comment
	$(".hfpl").click(function () {
		var comment_id = $(this).attr("name");
		$(".cancelReply").trigger("click");
	    $(this).parent(".comment-body").append($(".comment").clone(true));
	    $(this).parent(".comment-body").find(".comment").removeClass("hidden");
	    $(this).hide();  
	});
	
	//cancel reply comment
	$(".cancelReply").on('click',function () {
	    $(this).parents(".comment-body").find(".hfpl").show();
	    $(this).parents(".comment-body").find(".comment").remove();
	    
	});
	
	//show reply reply
	$(".hfhf").click(function () {
	    
	   	$(this).parents(".commentList").find(".cancelReply2").trigger("click");
	    $(this).parent(".comment-body").append($(".comment2").clone(true));
	    $(this).parent(".comment-body").find(".comment2").removeClass("hidden");
	    $(this).hide();
	});
	
	//cancel reply reply
	$(".cancelReply2").on('click',function () {
	    $(this).parents(".comment-body").find(".hfhf").show();
	    $(this).parents(".comment-body").find(".comment2").remove();
	});
	
	//删除博客
	$(".deleteBlog").on("click",function(){
		var blog_id = $(this).attr("name");
		$.ajax({
			url:"/blog/blog/deleteBlog/"+blog_id,
			type:"delete",
			dataType:"json",
			success:function(result){
				if(result>0){
					layer.msg("删除成功！");
					setTimeout(function(){
						window.location.href="/blog";
					},1000);
				}else{
					layer.msg("删除失败！");
				}
			},
			error:function(result){
				layer.msg("删除失败！");
			}
		});
	});
	
	//删除评论
	$(".deleteComment").on("click",function(){
		var currentThis = $(this);
		var comment_id = currentThis.attr("name");
		$.ajax({
			url:"/blog/comment/deleteComment/"+comment_id,
			type:"delete",
			dataType:"json",
			success:function(result){
				if(result>0){
					layer.msg("删除成功！");
					currentThis.parents(".comment-item").remove();
				}else{
					layer.msg("删除失败！");
				}
			},
			error:function(result){
				layer.msg("删除失败！");
			}
		});
	});
	
	//删除回复
	$(".deleteReply").on("click",function(){
		var currentThis = $(this);
		var reply_id = currentThis.attr("name");
		$.ajax({
			url:"/blog/comment/deleteReply/"+reply_id,
			type:"delete",
			dataType:"json",
			success:function(result){
				if(result>0){
					layer.msg("删除成功！");
					currentThis.parents(".reply-item").remove();
//					setTimeout(function(){
//						window.location.reload();
//					},1000);
				}else{
					layer.msg("删除失败！");
				}
			},
			error:function(result){
				layer.msg("删除失败！");
			}
		});
	});
});