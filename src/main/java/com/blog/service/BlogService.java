package com.blog.service;

import java.util.List;

import com.blog.entity.Blog;
import com.blog.entity.BlogInfo;
import com.blog.entity.PageBean;

public interface BlogService {
	//根据主键删除（级联删除，删除博客，以及该博客的所有评论、回复、点赞）
    int deleteByPrimaryKey(String blog_id) throws Exception;
    //添加
    int insertBlog(Blog record) throws Exception;
    //修改
    int updateBlog(Blog record) throws Exception;
    //根据主键查询
    Blog selectByPrimaryKey(String blog_id) throws Exception;
    //根据主键查询（关联查询该博客用户）
    BlogInfo selectInfoByPrimaryKey(String blog_id) throws Exception;
    //查询所有博客
    List<BlogInfo> selectAllBlog() throws Exception;
    //根据用户id查询
    List<BlogInfo> selectByUser_id(String user_id) throws Exception;
    //根据分类查询
    List<BlogInfo> selectByCategory(String category_id) throws Exception;
    //查询最新
    List<Blog> selectNewBlog() throws Exception;
    //查询最热
    List<Blog> selectHotBlog() throws Exception;
    //模糊搜索（根据标题和摘要排序）
    PageBean<BlogInfo> selectVague(String keyword,int currentPage) throws Exception;
    //分页查询
    PageBean<BlogInfo> selectPage(int currentPage) throws Exception;
    //根据分类分页查询
    PageBean<BlogInfo> selectPageByCategory(String category_id,int currentPage) throws Exception;
}
