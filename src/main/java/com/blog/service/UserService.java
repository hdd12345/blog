package com.blog.service;

import com.blog.entity.User;

public interface UserService {
	public int insertUser(User user) throws Exception;
	public User selectByPrimaryKey(String user_id) throws Exception;
	public int updateUser(User user) throws Exception;
	public User selectUser(User user) throws Exception;
	public User selectByUsername(String username) throws Exception;
	
}
