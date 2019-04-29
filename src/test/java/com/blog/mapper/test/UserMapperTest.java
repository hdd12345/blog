package com.blog.mapper.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.blog.entity.User;
import com.blog.mapper.UserMapper;

/**
 * 使用注解来协助完成单元测试，不需要手动写代码加载配置文件
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	
	@Autowired
	private UserMapper userMapper;
	
	//根据主键删除用户
	@Test
	public void testDeleteByPrimaryKey() throws Exception {
//		System.out.println(userMapper.deleteByPrimaryKey("2"));
	}
	
	//添加用户
	@Test
	public void testInsertUser() throws Exception {
//		User user = new User();
//		user.setUser_id("11");
//		user.setUsername("abcdef");
//		user.setPassword("123456");
//		user.setEmail("123456@163.com");
//		System.out.println(userMapper.insertUser(user));
	}
	
	//根据主键查询用户
	@Test
	public void testSelectByPrimaryKey() throws Exception {
		System.out.println(userMapper.selectByPrimaryKey("1"));
	}
	
	//修改用户信息
	@Test
	public void testUpdateUser() throws Exception {
//		User user = new User();
//		user.setUser_id("11");
//		user.setUsername("abcdef");
//		user.setPassword("123456");
//		user.setEmail("654321@163.com");
//		user.setSex("女");
//		user.setImage("hbbbb.jpg");
//		System.out.println(userMapper.updateUser(user));
	}
	
	//查询用户
	@Test
	public void testSelectUser() throws Exception {
		User user = new User();
		user.setUsername("hdd");
		user.setPassword("123");
		System.out.println(userMapper.selectUser(user));
	}
	
	//根据用户名查询用户
	@Test
	public void testSelectByUsername() throws Exception {
		System.out.println(userMapper.selectByUsername("abcdef"));
	}

}
