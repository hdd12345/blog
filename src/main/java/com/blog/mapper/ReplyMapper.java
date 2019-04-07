package com.blog.mapper;

import com.blog.entity.Reply;

public interface ReplyMapper {
	//根据主键删除
    int deleteByPrimaryKey(String reply_id) throws Exception;
    //添加
    int insertReply(Reply record) throws Exception;
    //根据主键查询
    Reply selectByPrimaryKey(String reply_id) throws Exception;
    //修改
    int updateReply(Reply record) throws Exception;

}