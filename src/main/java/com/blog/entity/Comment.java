package com.blog.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * @author hdd
 * @date 2018-12-01
 */
public class Comment {
    private String comment_id;

    private String comment_content;

    private Date comment_time;

    private String user_id;

    private String blog_id;

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id == null ? null : comment_id.trim();
    }

    public String getComment_content() {
        return comment_content;
    }

    public void setComment_content(String comment_content) {
        this.comment_content = comment_content == null ? null : comment_content.trim();
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
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