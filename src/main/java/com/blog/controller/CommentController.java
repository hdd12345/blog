package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.entity.Comment;
import com.blog.entity.Reply;
import com.blog.service.CommentService;

@Controller
@RequestMapping(value="/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value="/addComment",method=RequestMethod.POST)
	@ResponseBody
	public int addComment(@RequestBody Comment comment) throws Exception{
		return commentService.insertCommend(comment);
	}
	
	@RequestMapping(value="/addReply",method=RequestMethod.POST)
	@ResponseBody
	public int addReply(@RequestBody Reply reply) throws Exception{
		return commentService.insertReply(reply);
	}
	
	@RequestMapping(value="/deleteComment/{comment_id}",method = RequestMethod.DELETE)
	@ResponseBody
	public int deleteComment(@PathVariable String comment_id) throws Exception{
		return commentService.deleteCommentByPrimaryKey(comment_id);
	}
	
	@RequestMapping(value="/deleteReply/{reply_id}",method = RequestMethod.DELETE)
	@ResponseBody
	public int deleteReply(@PathVariable String reply_id) throws Exception{
		return commentService.deleteByPrimaryKey(reply_id);
	}
	
}
