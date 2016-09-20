package com.ldxx.ms.orm;

import java.util.Date;

/**
 * user java bean
 * 
 * @author ldxx
 *
 */
public class User {
	private String pid;
	private String user_name;
	private Date birthday;
	private int status;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("{ ");
		sb.append("pid:").append(this.pid).append(" ,user_name:").append(this.user_name).append(" ,birthday:")
				.append(this.birthday).append(" ,status:").append(this.status).append(" }");
		return sb.toString();
	}

}
