$(function(){
	//显示右侧日历
	new calendar('calendar'); 
	$("#tosearch-div").hide();
	
	var E = window.wangEditor;
    var editor = new E('#editor');
    editor.customConfig.uploadImgServer = '/blog/picture/upload'; //上传URL
	editor.customConfig.uploadImgMaxSize = 5 * 1024 * 1024;    
	editor.customConfig.uploadFileName = 'myfile';
	editor.customConfig.uploadImgHeaders = {
		    'Accept': 'text/x-json'
		};
	editor.customConfig.customAlert = function (info) {
//	    alert('自定义提示：' + info)
	};
	editor.customConfig.uploadImgHooks = {
			customInsert: function (insertImg, result, editor) {
	            var url =result.url;
	            insertImg(url);
			},
			before : function(xhr, editor, files) {
			},		
			success : function(xhr, editor, result) {
			},
			fail : function(xhr, editor, result) {
				alert("上传失败，原因是"+result);
			},		
			error : function(xhr, editor) {	
				alert("上传出错！");		
			},		
			timeout : function(xhr, editor) {
				alert("上传超时！");
			}
	};
	
    editor.create();

	/**
	 * 发布监听--------------
	 */
	$("#submitBlog").on("click",function(){
		var flag = true;
		var title = $("#title").val();
		var summary = $("#summary").val();
		var content = editor.txt.html();
		var keyword = $("#key-word").val();
		var category_id = $("#category-select").val();
		if(title==""){
			layer.tips('标题不能为空！', '#title',{tipsMore: true});
			flag = false;
		}
		if(summary==""){
			layer.tips('摘要不能为空！', '#summary',{tipsMore: true});
			flag = false;
		}
		if(editor.txt.text()==""){
			layer.tips('内容不能为空！', '#editor',{tipsMore: true});
			flag = false;
		}
		if(keyword==""){
			layer.tips('关键字不能为空！', '#key-word',{tipsMore: true});
			flag = false;
		}
		if(flag){
			$.ajax({
				url:"/blog/blog/addBlog",
				type:"post",
				data:JSON.stringify({
					"title":title,
					"summary":summary,
					"content":content,
					"keyword":keyword,
					"category_id":category_id
				}),
				dataType:"json",
				contentType:"application/json",
				success:function(result){
					if(result==1){
						layer.msg("发布成功！");
						$("#title").val("");
						$("#summary").val("");
						editor.txt.text("");
						$("#key-word").val("");
					}else{
						layer.msg("发布失败！");
					}
				},
				error:function(result){
					layer.msg("发布失败！");
				}
			});
		}
	});
	
	
	
});