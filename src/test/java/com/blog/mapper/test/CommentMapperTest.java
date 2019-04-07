package com.blog.mapper.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blog.entity.Comment;
import com.blog.entity.CommentInfo;
import com.blog.mapper.CommentMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentMapperTest {
	
	@Autowired
	private CommentMapper cm;

	@Test
	public void testDeleteByPrimaryKey() throws Exception {
//		System.out.println(cm.deleteByPrimaryKey("10"));
	}

	@Test
	public void testInsertCommend() throws Exception {
		Comment comment = new Comment();
		comment.setComment_id("10");
		comment.setComment_content("哈哈哈");
		comment.setBlog_id("10");
		comment.setUser_id("1");
		comment.setComment_time(new Date());
//		System.out.println(cm.insertCommend(comment));
	}

	@Test
	public void testSelectByPrimaryKey() throws Exception {
		System.out.println(cm.selectByPrimaryKey("1"));
	}

	@Test
	public void testUpdateComment() throws Exception {
		Comment comment = new Comment();
		comment.setComment_id("10");
		comment.setComment_content("哈哈哈哈哈");
		comment.setBlog_id("10");
		comment.setUser_id("1");
		comment.setComment_time(new Date());
//		System.out.println(cm.updateComment(comment));
	}

	@Test
	public void testSelectByBlog_id() throws Exception {
		List<CommentInfo> list = cm.selectByBlog_id("1");
		for(CommentInfo commentInfo:list) {
			System.out.println(commentInfo);
		}
	}

}
