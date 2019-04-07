package com.blog.mapper;

import com.blog.entity.User;

public interface UserMapper {
	//根据主键删除
    int deleteByPrimaryKey(String user_id) throws Exception;
    //添加用户
    int insertUser(User record) throws Exception;
    //根据主键查询用户
    User selectByPrimaryKey(String user_id) throws Exception;
    //修改用户信息
    int updateUser(User user) throws Exception;
    //查询用户
    User selectUser(User user) throws Exception;
    //根据用户名查询用户
    User selectByUsername(String username) throws Exception;
    
}