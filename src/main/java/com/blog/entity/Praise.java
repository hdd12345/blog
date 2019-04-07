package com.blog.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * @author hdd
 * @date 2018-12-01
 */
public class Praise {
    private String praise_id;

    private Date praise_time;

    private String user_id;

    private String blog_id;

    public String getPraise_id() {
        return praise_id;
    }

    public void setPraise_id(String praise_id) {
        this.praise_id = praise_id == null ? null : praise_id.trim();
    }

    public Date getPraise_time() {
        return praise_time;
    }

    public void setPraise_time(Date praise_time) {
        this.praise_time = praise_time;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }

    public String getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(String blog_id) {
        this.blog_id = blog_id == null ? null : blog_id.trim();
    }
    
    @Override
	public String toString() {
		return JSONObject.toJSONString(this).toString();
	}
    
}