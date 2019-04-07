package com.blog.entity;

import com.alibaba.fastjson.JSONObject;

/**
 * @author hdd
 * @date 2018-12-01
 */
public class Category {
    private String category_id;

    private String name;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id == null ? null : category_id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
    
    @Override
	public String toString() {
		return JSONObject.toJSONString(this).toString();
	}
    
}