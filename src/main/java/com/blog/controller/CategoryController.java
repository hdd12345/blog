package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.Category;
import com.blog.service.CategoryService;

@RestController
@RequestMapping(value="/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 获取所有分类
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/getAllCategory",method= {RequestMethod.GET,RequestMethod.POST})
	public List<Category> getAllCategory() throws Exception{
		return categoryService.selectAllCategory();
	}
}
