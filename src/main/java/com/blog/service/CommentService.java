package com.blog.service;

import java.util.List;

import com.blog.entity.Comment;
import com.blog.entity.CommentInfo;
import com.blog.entity.Reply;

public interface CommentService {
	//根据主键删除评论（级联删除，删除评论及该评论的所有回复）
    int deleteCommentByPrimaryKey(String comment_id) throws Exception;
    //添加评论
    int insertCommend(Comment record) throws Exception;
    //根据主键查询评论
    Comment selectCommentByPrimaryKey(String comment_id) throws Exception;
    //修改评论
    int updateComment(Comment record) throws Exception;
    //根据博客id查询（关联查询：包含回复）
    List<CommentInfo> selectByBlog_id(String blog_id) throws Exception;
    //根据主键删除回复
    int deleteByPrimaryKey(String reply_id) throws Exception;
    //添加回复
    int insertReply(Reply record) throws Exception;
    //根据主键查询
    Reply selectReplyByPrimaryKey(String reply_id) throws Exception;
    //修改回复
    int updateReply(Reply record) throws Exception;
}
