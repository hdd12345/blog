package com.blog.service;

import com.blog.entity.Praise;

public interface PraiseService {
	//添加点赞(修改对应博客的点赞数量)
	int insertPraise(Praise record) throws Exception;
    //查询点赞
    Praise selectPraise(String user_id,String blog_id) throws Exception;
    //删除点赞(修改对应博客的点赞数量)
    int deletePraise(String user_id,String blog_id) throws Exception;
    //添加或删除
    int addOrCancel(String user_id,String blog_id) throws Exception;
}
