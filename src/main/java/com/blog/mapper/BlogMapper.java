package com.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.blog.entity.Blog;
import com.blog.entity.BlogInfo;

public interface BlogMapper {
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
    //分页模糊搜索（根据标题和摘要排序）
    List<BlogInfo> selectVague(@Param(value = "keyword") String keyword,
    		@Param(value = "start") int start,
    		@Param(value = "currentCount") int currentCount) throws Exception;
    //模糊搜索总数量
    int selectVagueCount(String keyword) throws Exception;
    //查询博客总数量
    int selectCount() throws Exception;
    //根据分类id查询博客总数量
    int selectCountByCategory(String category_id);
    //分页查询
    List<BlogInfo> selectPage(@Param(value = "start") int start,
    		@Param(value = "currentCount") int currentCount) throws Exception;
    //根据分类分页查询
    List<BlogInfo> selectPageByCategory(@Param(value = "start") int start,
    		@Param(value = "currentCount") int currentCount,
    		@Param(value = "category_id") String category_id) throws Exception;
}