package com.ldxx.lottery.orm;


/**
 * 
 * @author wangzhuo
 *
 */


public class FirstDistribution {
	private String pid;
	private String issue;
	private String province_name;
	private String province_py;
	private int num;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getProvince_name() {
		return province_name;
	}
	public void setProvince_name(String province_name) {
		this.province_name = province_name;
	}
	public String getProvince_py() {
		return province_py;
	}
	public void setProvince_py(String province_py) {
		this.province_py = province_py;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		StringBuilder sb =  new StringBuilder(" insert into first_distribution values( '");
		sb.append(this.pid).append("','").append(this.issue).append("','")
		.append(this.province_name).append("','").append(this.province_py)
		.append("','").append(this.num).append("')");
		return sb.toString();
	}
	

}
