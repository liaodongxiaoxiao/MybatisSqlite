package com.ldxx.ms.orm;

import java.util.Date;

public class Story {
	private String pid;
	private String title;
	private Date date_time;
	private String content;
	private String favorite_flag;
	private Date favorite_time;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFavorite_flag() {
		return favorite_flag;
	}
	public void setFavorite_flag(String favorite_flag) {
		this.favorite_flag = favorite_flag;
	}
	public Date getFavorite_time() {
		return favorite_time;
	}
	public void setFavorite_time(Date favorite_time) {
		this.favorite_time = favorite_time;
	}
	
}
