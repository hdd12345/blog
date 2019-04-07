package com.blog.mapper.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.blog.entity.Category;
import com.blog.mapper.CategoryMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryMapperTest {
	
	@Autowired
	private CategoryMapper cm;
	
	@Test
	public void testDeleteByPrimaryKey() {
//		System.out.println(cm.deleteByPrimaryKey("3"));
	}

	@Test
	public void testInsertCategory() throws Exception {
//		Category c = new Category();
//		c.setCategory_id("2");
//		c.setName("框架");
//		System.out.println(cm.insertCategory(c));
	}

	@Test
	public void testSelectByPrimaryKey() throws Exception {
		System.out.println(cm.selectByPrimaryKey("2"));
	}

	@Test
	public void testUpdateCategory() throws Exception {
//		Category c = new Category();
//		c.setCategory_id("2");
//		c.setName("框架");
//		System.out.println(cm.updateCategory(c));
	}

	@Test
	public void testSelectAllCategory() throws Exception {
		System.out.println(cm.selectAllCategory());
	}

}
