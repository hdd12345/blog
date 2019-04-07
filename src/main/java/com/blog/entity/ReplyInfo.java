package com.blog.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

public class ReplyInfo {
	private String reply_id;

    private String reply_content;

    private Date reply_time;

    private String target_id;

    private String comment_id;

    private String user_id;
    //以下为扩展属性
    private User user;
    
    private User target;

	public String getReply_id() {
		return reply_id;
	}

	public void setReply_id(String reply_id) {
		this.reply_id = reply_id;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public Date getReply_time() {
		return reply_time;
	}

	public void setReply_time(Date reply_time) {
		this.reply_time = reply_time;
	}

	public String getTarget_id() {
		return target_id;
	}

	public void setTarget_id(String target_id) {
		this.target_id = target_id;
	}

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getTarget() {
		return target;
	}

	public void setTarget(User target) {
		this.target = target;
	}

	@Override
	public String toString() {
		return JSONObject.toJSONString(this).toString();
	}
    
    
}
