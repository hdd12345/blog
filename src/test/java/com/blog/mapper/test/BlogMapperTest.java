package com.blog.mapper.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blog.entity.Blog;
import com.blog.entity.BlogInfo;
import com.blog.mapper.BlogMapper;
import com.blog.mapper.UserMapper;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogMapperTest {
	
	@Autowired
	private BlogMapper bm;
	
	@Test
	public void testDeleteByPrimaryKey() throws Exception {
		System.out.println(bm.deleteByPrimaryKey("10"));
	}

	@Test
	public void testInsertBlog() throws Exception {
		Blog blog = new Blog();
		blog.setBlog_id("10");
		blog.setCategory_id("2");
		blog.setUser_id("1");
		blog.setTitle("这是一篇博客的标题");
		blog.setSummary("这是一篇博客的摘要");
		blog.setContent("这是一篇博客的内容");
		blog.setKeyword("blog blog");
		blog.setCreate_time(new Date());
//		System.out.println(bm.insertBlog(blog));
	}

	@Test
	public void testUpdateBlog() throws Exception {
		Blog blog = new Blog();
		blog.setBlog_id("10");
		blog.setCategory_id("2");
		blog.setUser_id("1");
		blog.setTitle("这是一篇博客的标题");
		blog.setSummary("这是一篇博客的摘要");
		blog.setContent("这是一篇博客的内容");
		blog.setKeyword("blog--blog");
		blog.setCreate_time(new Date());
//		System.out.println(bm.updateBlog(blog));
	}

	@Test
	public void testSelectByPrimaryKey() throws Exception {
		System.out.println(bm.selectByPrimaryKey("10"));
	}
	
	@Test
	public void testSelectInfoByPrimaryKey() throws Exception {
		System.out.println(bm.selectInfoByPrimaryKey("10"));
	}

	@Test
	public void testSelectAllBlog() throws Exception {
		List<BlogInfo> list = bm.selectAllBlog();
		Iterator<BlogInfo> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	@Test
	public void testSelectByUser_id() throws Exception {
		List<BlogInfo> list = bm.selectByUser_id("1");
		Iterator<BlogInfo> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	@Test
	public void testSelectByCategory() throws Exception {
		List<BlogInfo> list = bm.selectByCategory("1");
		Iterator<BlogInfo> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	@Test
	public void testSelectNewBlog() throws Exception {
		List<Blog> list = bm.selectNewBlog();
		Iterator<Blog> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

	@Test
	public void testSelectHotBlog() throws Exception {
		List<Blog> list = bm.selectHotBlog();
		Iterator<Blog> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
