package com.blog.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.entity.Category;
import com.blog.mapper.CategoryMapper;
import com.blog.service.CategoryService;
@Service("categoryServiceImpl")
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryMapper categoryMapper;
	
	@Override
	@Transactional
	public int deleteByPrimaryKey(String category_id) throws Exception {
		return categoryMapper.deleteByPrimaryKey(category_id);
	}

	@Override
	@Transactional
	public int insertCategory(Category record) throws Exception {
		return categoryMapper.insertCategory(record);
	}

	@Override
	public Category selectByPrimaryKey(String category_id) throws Exception {
		return categoryMapper.selectByPrimaryKey(category_id);
	}

	@Override
	@Transactional
	public int updateCategory(Category record) throws Exception {
		return categoryMapper.updateCategory(record);
	}

	@Override
	public List<Category> selectAllCategory() throws Exception {
		return categoryMapper.selectAllCategory();
	}

}
