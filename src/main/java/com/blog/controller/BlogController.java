package com.blog.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.blog.entity.Blog;
import com.blog.entity.BlogInfo;
import com.blog.entity.User;
import com.blog.service.BlogService;
import com.blog.service.CommentService;

@Controller
@RequestMapping(value="/blog")
public class BlogController {
	
	@Resource(name="blogServiceImpl")
	private BlogService blogService;
	@Resource(name="commentServiceImpl")
	private CommentService commentService;
	
	/**
	 * 添加博客
	 * @param blog
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addBlog",method=RequestMethod.POST)
	@ResponseBody
	public int addBlog(@RequestBody Blog blog,HttpServletRequest request) throws Exception{
		User currentUser = (User)request.getSession().getAttribute("user");
		blog.setUser_id(currentUser.getUser_id());
		return blogService.insertBlog(blog);
	}
	
	@RequestMapping(value="/updateBlog",method=RequestMethod.POST)
	@ResponseBody
	public int updateBlog(@RequestBody Blog blog) throws Exception{
		return blogService.updateBlog(blog);
	}
	
	@RequestMapping(value="/deleteBlog/{blog_id}",method=RequestMethod.DELETE)
	@ResponseBody
	public int deleteBlog(@PathVariable String blog_id) throws Exception{
		return blogService.deleteByPrimaryKey(blog_id);
	}
	
	@RequestMapping(value="/getByCategory",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public List<BlogInfo> getByCategory(String category_id) throws Exception{
		return blogService.selectByCategory(category_id);
	}
	
	@RequestMapping(value="/blogInfo/{blog_id}",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView blogInfo(@PathVariable String blog_id,HttpSession session) throws Exception{
		ModelAndView mav = new ModelAndView("blog");
		mav.addObject("blogInfo",blogService.selectInfoByPrimaryKey(blog_id));
		mav.addObject("commentList",commentService.selectByBlog_id(blog_id));
		mav.addObject("hotBlogList",blogService.selectHotBlog());
		User user = (User) session.getAttribute("user");
		mav.addObject("currentUser",user==null?new User():user);
		return mav;
	}
	
	/**
	 * 根据关键字模糊搜索文章
	 * @param keyword
	 * @param currentPage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/search/{keyword}",method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView search(@PathVariable String keyword,
			@RequestParam(required=false,defaultValue="1") int currentPage) throws Exception{
		ModelAndView mav = new ModelAndView("search");
		mav.addObject("pageBean",blogService.selectVague(keyword, currentPage));
		mav.addObject("hotBlogList",blogService.selectHotBlog());
		mav.addObject("newBlogList",blogService.selectNewBlog());
		mav.addObject("keyword",keyword);
		return mav;
	}
	
}
