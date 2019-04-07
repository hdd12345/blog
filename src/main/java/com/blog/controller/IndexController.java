package com.blog.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.blog.service.BlogService;
import com.blog.service.CategoryService;

@Controller
@RequestMapping(value="/")
public class IndexController {
	
	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	
	/**
	 * 首页
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView Index(@RequestParam(required=false,defaultValue="1") int currentPage) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageBean",blogService.selectPage(currentPage));
		mav.addObject("newBlogList",blogService.selectNewBlog());
		mav.addObject("hotBlogList",blogService.selectHotBlog());
		mav.addObject("category_id","0");//0表示无分类
		mav.setViewName("index");
		return mav;
	}
	
	/**
	 * 首页分类
	 * @param category_id
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/{category_id}",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView IndexCategory(@PathVariable String category_id,
			@RequestParam(required=false,defaultValue="1") int currentPage) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageBean",blogService.selectPageByCategory(category_id, currentPage));
		mav.addObject("newBlogList",blogService.selectNewBlog());
		mav.addObject("hotBlogList",blogService.selectHotBlog());
		mav.addObject("category_id",category_id);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/tologin",method= {RequestMethod.GET,RequestMethod.POST})
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping(value="/toregister",method= {RequestMethod.GET,RequestMethod.POST})
	public String toRegister() {
		return "register";
	}
	
	@RequestMapping(value="/toBlogEdit",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView toBlogEdit() throws Exception {
		ModelAndView mav = new ModelAndView("blogedit");
		mav.addObject("categoryList",categoryService.selectAllCategory());
		return mav;
	}
	
	@RequestMapping(value="/toUpdateBlog/{blog_id}",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView toUpdateBlog(@PathVariable String blog_id) throws Exception{
		ModelAndView mav = new ModelAndView("updateBlog");
		mav.addObject("blogInfo",blogService.selectInfoByPrimaryKey(blog_id));
		mav.addObject("categoryList",categoryService.selectAllCategory());
		return mav;
	}
	
	@RequestMapping(value="/toUpdateUser",method= {RequestMethod.GET,RequestMethod.POST})
	public String toUpdateUser(){
		return "profile";
	}
}
