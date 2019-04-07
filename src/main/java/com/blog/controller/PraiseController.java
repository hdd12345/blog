package com.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.Praise;
import com.blog.service.PraiseService;

@RestController
@RequestMapping(value="/praise")
public class PraiseController {
	
	@Autowired
	private PraiseService praiseService;
	
	/**
	 * 添加点赞
	 * @param praise
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/addPraise",method=RequestMethod.POST)
	public int addPraise(@RequestBody Praise praise) throws Exception {
		return praiseService.insertPraise(praise);
	}
	
	/**
	 * 取消点赞
	 * @param user_id
	 * @param blog_id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/cancelPraise",method=RequestMethod.POST)
	public int cancelPraise(String user_id,String blog_id) throws Exception{
		return praiseService.deletePraise(user_id, blog_id);
	}
	
	@RequestMapping(value="/isPraise/{blog_id}/{user_id}",method= {RequestMethod.GET,RequestMethod.POST})
	public Praise isPraise(@PathVariable String user_id,@PathVariable String blog_id) throws Exception{
		return praiseService.selectPraise(user_id, blog_id);
	}
	
	@RequestMapping(value="/addOrCancel/{blog_id}/{user_id}",method=RequestMethod.POST)
	public int addOrCancel(@PathVariable String user_id,@PathVariable String blog_id) throws Exception{
		return praiseService.addOrCancel(user_id, blog_id);
	}
}
