package com.blog.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.entity.Blog;
import com.blog.entity.BlogInfo;
import com.blog.entity.PageBean;
import com.blog.mapper.BlogMapper;
import com.blog.service.BlogService;
@Service("blogServiceImpl")
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogMapper blogMapper;
	
	@Override
	@Transactional
	public int deleteByPrimaryKey(String blog_id) throws Exception {
		return blogMapper.deleteByPrimaryKey(blog_id);
	}

	@Override
	@Transactional
	public int insertBlog(Blog record) throws Exception {
		record.setBlog_id(UUID.randomUUID().toString().replace("-",""));
		record.setCreate_time(new Date());
		return blogMapper.insertBlog(record);
	}

	@Override
	@Transactional
	public int updateBlog(Blog record) throws Exception {
		return blogMapper.updateBlog(record);
	}

	@Override
	public Blog selectByPrimaryKey(String blog_id) throws Exception {
		return blogMapper.selectByPrimaryKey(blog_id);
	}

	@Override
	public BlogInfo selectInfoByPrimaryKey(String blog_id) throws Exception {
		Blog blog = blogMapper.selectByPrimaryKey(blog_id);
		blog.setRead_count(blog.getRead_count()+1);//浏览量+1
		blogMapper.updateBlog(blog);
		return blogMapper.selectInfoByPrimaryKey(blog_id);
	}

	@Override
	public List<BlogInfo> selectAllBlog() throws Exception {
		return blogMapper.selectAllBlog();
	}

	@Override
	public List<BlogInfo> selectByUser_id(String user_id) throws Exception {
		return blogMapper.selectByUser_id(user_id);
	}

	@Override
	public List<BlogInfo> selectByCategory(String category_id) throws Exception {
		return blogMapper.selectByCategory(category_id);
	}

	@Override
	public List<Blog> selectNewBlog() throws Exception {
		return blogMapper.selectNewBlog();
	}

	@Override
	public List<Blog> selectHotBlog() throws Exception {
		return blogMapper.selectHotBlog();
	}
	
	/**
	 * 分页模糊搜索
	 */
	@Override
	public PageBean<BlogInfo> selectVague(String keyword,int currentPage) throws Exception {
		int totalCount = blogMapper.selectVagueCount(keyword);
		int totalPage = totalCount%3>0?totalCount/3+1:totalCount/3;
		System.out.println(totalPage);
		int start = (currentPage - 1) * 3;
		List<BlogInfo> list = blogMapper.selectVague(keyword, start,3);
		PageBean<BlogInfo> pageBean = new PageBean<>();
		pageBean.setCurrentCount(3);
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}
	
	/**
	 * 分页查询
	 */
	@Override
	public PageBean<BlogInfo> selectPage(int currentPage) throws Exception {
		int totalCount = blogMapper.selectCount();
		int totalPage = totalCount%3>0?totalCount/3+1:totalCount/3;
		int start = (currentPage - 1) * 3;
		List<BlogInfo> list = blogMapper.selectPage(start,3);
		PageBean<BlogInfo> pageBean = new PageBean<>();
		pageBean.setCurrentCount(3);
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}
	
	/**
	 * 根据博客分类分页查询
	 */
	@Override
	public PageBean<BlogInfo> selectPageByCategory(String category_id, int currentPage) throws Exception {
		int totalCount = blogMapper.selectCountByCategory(category_id);
		int totalPage = totalCount%3>0?totalCount/3+1:totalCount/3;
		int start = (currentPage - 1) * 3;
		List<BlogInfo> list = blogMapper.selectPageByCategory(start,3, category_id);
		PageBean<BlogInfo> pageBean = new PageBean<>();
		pageBean.setCurrentCount(3);
		pageBean.setCurrentPage(currentPage);
		pageBean.setList(list);
		pageBean.setTotalCount(totalCount);
		pageBean.setTotalPage(totalPage);
		return pageBean;
	}

}
