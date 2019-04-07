package com.blog.mapper;

import java.util.List;

import com.blog.entity.Category;

public interface CategoryMapper {
	
    int deleteByPrimaryKey(String category_id) throws Exception;

    int insertCategory(Category record) throws Exception;

    Category selectByPrimaryKey(String category_id) throws Exception;

    int updateCategory(Category record) throws Exception;
    
    List<Category> selectAllCategory() throws Exception;
    
}