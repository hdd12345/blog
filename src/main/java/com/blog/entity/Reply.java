package com.blog.entity;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * @author hdd
 * @date 2018-12-01
 */
public class Reply {
    private String reply_id;

    private String reply_content;

    private Date reply_time;

    private String target_id;

    private String comment_id;

    private String user_id;

    public String getReply_id() {
        return reply_id;
    }

    public void setReply_id(String reply_id) {
        this.reply_id = reply_id == null ? null : reply_id.trim();
    }

    public String getReply_content() {
        return reply_content;
    }

    public void setReply_content(String reply_content) {
        this.reply_content = reply_content == null ? null : reply_content.trim();
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
        this.target_id = target_id == null ? null : target_id.trim();
    }

    public String getComment_id() {
        return comment_id;
    }

    public void setComment_id(String comment_id) {
        this.comment_id = comment_id == null ? null : comment_id.trim();
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id == null ? null : user_id.trim();
    }
    
    @Override
	public String toString() {
		return JSONObject.toJSONString(this).toString();
	}
    
}