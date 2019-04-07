
package com.blog.mapper.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blog.entity.Praise;
import com.blog.mapper.PraiseMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PraiseMapperTest {
	
	@Autowired
	private PraiseMapper pm;
	
	@Test
	public void testDeleteByPrimaryKey() throws Exception {
//		System.out.println(pm.deleteByPrimaryKey("1"));
	}

	@Test
	public void testInsertPraise() throws Exception {
//		Praise p = new Praise();
//		p.setPraise_id("1");
//		p.setBlog_id("1");
//		p.setUser_id("1");
//		p.setPraise_time(new Date());
//		System.out.println(pm.insertPraise(p));
	}
	
	@Test
	public void testSelectPraise() throws Exception {
		System.out.println(pm.selectPraise("1","1"));
	}
	
	@Test
	public void testDeletePraise() throws Exception {
		System.out.println(pm.deletePraise("1","1"));
	}

}
