package com.blog.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//为内置服务器配置虚拟目录（用于访问图片）
		registry.addResourceHandler("/pic/**").addResourceLocations("file:D:\\pic\\");
	}
	
}
