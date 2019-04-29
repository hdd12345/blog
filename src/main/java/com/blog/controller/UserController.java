package com.blog.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.blog.entity.User;
import com.blog.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public int register(@RequestBody User user) throws Exception{
		return userService.insertUser(user);
	}
	
	/**
	 * 用户登录，若登录验证成功，则将当前用户对象保存到session中
	 * @param user
	 * @param request
	 * @return 登录验证成功返回1，登录失败返回0
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value="/login",method= {RequestMethod.GET,RequestMethod.POST})
	public int login(@RequestBody User user,HttpServletRequest request) throws Exception{
		User user1 = userService.selectUser(user);
		if(user1!=null) {
			request.getSession().setAttribute("user",user1);
			return 1;
		}
		return 0;
	}
	
	/**
	 * 清除session，跳转到首页
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/logout",method= {RequestMethod.GET,RequestMethod.POST})
	public String logout(HttpServletRequest request) throws Exception{
		request.getSession().invalidate();
		return "forward:/";
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/updateUser",method=RequestMethod.POST)
	@ResponseBody
	public int updateUser(@RequestBody User user,HttpSession session) throws Exception{
		int i = userService.updateUser(user);
		if(i>0) {
			session.setAttribute("user",userService.selectByPrimaryKey(user.getUser_id()));
		}
		return i;
	}
	
	/**
	 * 判断用户名是否存在
	 * @param username
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/isExist",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public boolean isExist(@RequestParam String username) throws Exception{
		return userService.selectByUsername(username)==null;
	}
}
