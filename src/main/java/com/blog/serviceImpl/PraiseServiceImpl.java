package com.blog.serviceImpl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.entity.Blog;
import com.blog.entity.Praise;
import com.blog.mapper.BlogMapper;
import com.blog.mapper.PraiseMapper;
import com.blog.service.PraiseService;
@Service("praiseServiceImpl")
public class PraiseServiceImpl implements PraiseService {
	
	@Autowired
	private PraiseMapper praiseMapper;
	@Autowired
	private BlogMapper blogMapper;
	
	@Override
	@Transactional
	public int insertPraise(Praise record) throws Exception {
		int i = 0;
		i+=praiseMapper.insertPraise(record);
		Blog blog = blogMapper.selectByPrimaryKey(record.getBlog_id());
		blog.setPraise_count(blog.getPraise_count()+1);
		i+=blogMapper.updateBlog(blog);
		return i;
	}

	@Override
	public Praise selectPraise(String user_id, String blog_id) throws Exception {
		return praiseMapper.selectPraise(user_id, blog_id);
	}

	@Override
	@Transactional
	public int deletePraise(String user_id, String blog_id) throws Exception {
		int i=0;
		i+=praiseMapper.deletePraise(user_id, blog_id);
		Blog blog = blogMapper.selectByPrimaryKey(blog_id);
		blog.setPraise_count(blog.getPraise_count()-1);
		i+=blogMapper.updateBlog(blog);
		return i;
	}
	
	/**
	 * 添加点赞返回正数，取消点赞返回负数
	 */
	@Override
	@Transactional
	public int addOrCancel(String user_id, String blog_id) throws Exception {
		int i = 0;
		Praise praise = praiseMapper.selectPraise(user_id, blog_id);
		if(praise == null) {
			praise = new Praise();
			praise.setPraise_id(UUID.randomUUID().toString().replace("-",""));
			praise.setBlog_id(blog_id);
			praise.setUser_id(user_id);
			praise.setPraise_time(new Date());
			i+=praiseMapper.insertPraise(praise);
			Blog blog = blogMapper.selectByPrimaryKey(blog_id);
			blog.setPraise_count(blog.getPraise_count()+1);//点赞量+1
			i+=blogMapper.updateBlog(blog);
		}else {
			i+=praiseMapper.deleteByPrimaryKey(praise.getPraise_id());
			Blog blog = blogMapper.selectByPrimaryKey(blog_id);
			blog.setPraise_count(blog.getPraise_count()-1);//点赞量-1
			i+=blogMapper.updateBlog(blog);
			i = 0-i;
		}
		return i;
	}

}
