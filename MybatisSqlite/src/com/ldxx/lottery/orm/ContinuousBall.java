package com.ldxx.lottery.orm;

public class ContinuousBall {
	private String issue;
	private String continuous_ball;
	private int continuous_num;

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getContinuous_ball() {
		return continuous_ball;
	}

	public void setContinuous_ball(String continuous_ball) {
		this.continuous_ball = continuous_ball;
	}

	public int getContinuous_num() {
		return continuous_num;
	}

	public void setContinuous_num(int continuous_num) {
		this.continuous_num = continuous_num;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder(
				" insert into continuous_balls values ('");
		s.append(this.issue).append("','").append(this.continuous_ball)
				.append("',").append(this.continuous_num).append(")");
		return s.toString();
	}

}
