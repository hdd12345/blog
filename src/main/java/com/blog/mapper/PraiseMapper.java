package com.blog.mapper;

import org.apache.ibatis.annotations.Param;

import com.blog.entity.Praise;

public interface PraiseMapper {
	
    int deleteByPrimaryKey(String praise_id) throws Exception;

    int insertPraise(Praise record) throws Exception;
    
    Praise selectPraise(@Param(value = "user_id") String user_id,
    		@Param(value = "blog_id") String blog_id) throws Exception;
    
    int deletePraise(@Param(value = "user_id") String user_id,
    		@Param(value = "blog_id") String blog_id) throws Exception;

}