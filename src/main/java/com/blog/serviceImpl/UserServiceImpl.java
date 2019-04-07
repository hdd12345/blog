package com.blog.serviceImpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.entity.User;
import com.blog.mapper.UserMapper;
import com.blog.service.UserService;
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	@Transactional
	public int insertUser(User user) throws Exception {
		user.setUser_id(UUID.randomUUID().toString().replace("-",""));
		return userMapper.insertUser(user);
	}

	@Override
	public User selectByPrimaryKey(String user_id) throws Exception{
		return userMapper.selectByPrimaryKey(user_id);
	}

	@Override
	@Transactional
	public int updateUser(User user) throws Exception {
		return userMapper.updateUser(user);
	}

	@Override
	public User selectUser(User user) throws Exception {
		return userMapper.selectUser(user);
	}

	@Override
	public User selectByUsername(String username) throws Exception {
		return userMapper.selectByUsername(username);
	}

}
