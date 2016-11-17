package com.ldxx.lottery.orm;

public class Recommender {

    private String pid;

    private String p_name;

    private String issue;

    private String red_balls;

    private String blue_balls;

    private int redwin_num;

    private int bluewin_num;

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getRed_balls() {
        return red_balls;
    }

    public void setRed_balls(String red_balls) {
        this.red_balls = red_balls;
    }

    public String getBlue_balls() {
        return blue_balls;
    }

    public void setBlue_balls(String blue_balls) {
        this.blue_balls = blue_balls;
    }

    public int getRedwin_num() {
        return redwin_num;
    }

    public void setRedwin_num(int redwin_num) {
        this.redwin_num = redwin_num;
    }

    public int getBluewin_num() {
        return bluewin_num;
    }

    public void setBluewin_num(int bluewin_num) {
        this.bluewin_num = bluewin_num;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return this.issue + "|" + this.red_balls + "|" + this.blue_balls;
    }
}
