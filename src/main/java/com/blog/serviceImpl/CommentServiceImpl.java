package com.blog.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.entity.Comment;
import com.blog.entity.CommentInfo;
import com.blog.entity.Reply;
import com.blog.mapper.CommentMapper;
import com.blog.mapper.ReplyMapper;
import com.blog.service.CommentService;

@Service("commentServiceImpl")
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private ReplyMapper replyMapper;

	@Override
	@Transactional
	public int deleteCommentByPrimaryKey(String comment_id) throws Exception {
		return commentMapper.deleteByPrimaryKey(comment_id);
	}

	@Override
	@Transactional
	public int insertCommend(Comment record) throws Exception {
		record.setComment_time(new Date());
		record.setComment_id(UUID.randomUUID().toString().replace("-",""));
		return commentMapper.insertCommend(record);
	}

	@Override
	public Comment selectCommentByPrimaryKey(String comment_id) throws Exception {
		return commentMapper.selectByPrimaryKey(comment_id);
	}

	@Override
	@Transactional
	public int updateComment(Comment record) throws Exception {
		return commentMapper.updateComment(record);
	}

	@Override
	public List<CommentInfo> selectByBlog_id(String blog_id) throws Exception {
		return commentMapper.selectByBlog_id(blog_id);
	}

	@Override
	@Transactional
	public int deleteByPrimaryKey(String reply_id) throws Exception {
		return replyMapper.deleteByPrimaryKey(reply_id);
	}

	@Override
	@Transactional
	public int insertReply(Reply record) throws Exception {
		record.setReply_id(UUID.randomUUID().toString().replace("-",""));
		record.setReply_time(new Date());
		return replyMapper.insertReply(record);
	}

	@Override
	public Reply selectReplyByPrimaryKey(String reply_id) throws Exception {
		return replyMapper.selectByPrimaryKey(reply_id);
	}

	@Override
	@Transactional
	public int updateReply(Reply record) throws Exception {
		return replyMapper.updateReply(record);
	}

}
