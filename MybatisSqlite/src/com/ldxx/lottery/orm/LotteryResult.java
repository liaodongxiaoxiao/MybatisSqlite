package com.ldxx.lottery.orm;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LotteryResult implements Serializable {

    /**
     * 期次
     */
    private String issue;

    /**
     * �?��时间
     */
    private String lottery_dates;

    /**
     * 兑奖截止日期
     */
    private String ticket_deadline;

    /**
     * 售出金额
     */
    private String sale;

    /**
     * 奖池金额
     */
    private String pool;

    /**
     * 红球
     */
    private String red_balls;

    /**
     * 蓝球
     */
    private String blue_ball;

    /**
     * �?��信息
     */
    private String bonus_info;

    /**
     * 额外信息
     */
    private String extra_info;

    /**
     * 头奖个数
     */
    private int first_prize_num;
    
    /**
     * 出球顺序
     */
    private String ball_order;
    
    

    public String getBall_order() {
		return ball_order;
	}

	public void setBall_order(String ball_order) {
		this.ball_order = ball_order;
	}

	public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getLottery_dates() {
        return lottery_dates;
    }

    public void setLottery_dates(String lottery_dates) {
        this.lottery_dates = lottery_dates;
    }

    public String getTicket_deadline() {
        return ticket_deadline;
    }

    public void setTicket_deadline(String ticket_deadline) {
        this.ticket_deadline = ticket_deadline;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getRed_balls() {
        return red_balls;
    }

    public void setRed_balls(String red_balls) {
        this.red_balls = red_balls;
    }

    public String getBlue_ball() {
        return blue_ball;
    }

    public void setBlue_ball(String blue_ball) {
        this.blue_ball = blue_ball;
    }

    public String getBonus_info() {
        return bonus_info;
    }

    public void setBonus_info(String bonus_info) {
        this.bonus_info = bonus_info;
    }

    @Override
    public boolean equals(Object obj) {

        LotteryResult lo = (LotteryResult) obj;
        return this.issue == lo.issue;

    }

    @Override
    public int hashCode() {
        return -1;
    }

    public String getExtra_info() {
        return extra_info;
    }

    public void setExtra_info(String extra_info) {
        this.extra_info = extra_info;
    }

    public int getFirst_prize_num() {
        return first_prize_num;
    }

    public void setFirst_prize_num(int first_prize_num) {
        this.first_prize_num = first_prize_num;
    }

}
