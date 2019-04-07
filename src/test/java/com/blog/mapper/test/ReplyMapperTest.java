package com.blog.mapper.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blog.entity.Reply;
import com.blog.mapper.ReplyMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReplyMapperTest {
	
	@Autowired
	private ReplyMapper rm;

	@Test
	public void testDeleteByPrimaryKey() throws Exception {
//		System.out.println(rm.deleteByPrimaryKey("10"));
	}

	@Test
	public void testInsertReply() throws Exception {
		Reply reply = new Reply();
		reply.setReply_id("10");
		reply.setComment_id("10");
		reply.setUser_id("1");
		reply.setTarget_id("1");
		reply.setReply_time(new Date());
		reply.setReply_content("嘿嘿嘿");
//		System.out.println(rm.insertReply(reply));
	}

	@Test
	public void testSelectByPrimaryKey() throws Exception {
		System.out.println(rm.selectByPrimaryKey("1"));
	}

	@Test
	public void testUpdateReply() throws Exception {
		Reply reply = new Reply();
		reply.setReply_id("10");
		reply.setComment_id("10");
		reply.setUser_id("1");
		reply.setTarget_id("1");
		reply.setReply_time(new Date());
		reply.setReply_content("嘿嘿嘿嘿嘿");
//		System.out.println(rm.updateReply(reply));
	}

}
