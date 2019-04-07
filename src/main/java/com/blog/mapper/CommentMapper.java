package com.blog.mapper;

import java.util.List;

import com.blog.entity.Comment;
import com.blog.entity.CommentInfo;

public interface CommentMapper {
	//根据主键删除（级联删除）
    int deleteByPrimaryKey(String comment_id) throws Exception;
    //添加
    int insertCommend(Comment record) throws Exception;
    //根据主键查询
    Comment selectByPrimaryKey(String comment_id) throws Exception;
    //修改
    int updateComment(Comment record) throws Exception;
    //根据博客id查询（关联查询：包含回复）
    List<CommentInfo> selectByBlog_id(String blog_id) throws Exception;
}