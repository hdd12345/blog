package com.blog.service;

import java.util.List;

import com.blog.entity.Category;

public interface CategoryService {
	//根据主键删除
	int deleteByPrimaryKey(String category_id) throws Exception;
	//添加分类
    int insertCategory(Category record) throws Exception;
    //根据主键查询
    Category selectByPrimaryKey(String category_id) throws Exception;
    //修改分类
    int updateCategory(Category record) throws Exception;
    //查询所有分类
    List<Category> selectAllCategory() throws Exception;
    
}
