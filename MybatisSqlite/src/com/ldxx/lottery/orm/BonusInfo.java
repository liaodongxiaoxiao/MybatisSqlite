package com.ldxx.lottery.orm;

public class BonusInfo {
    private String issue;

    private String bonus_type;

    private String bonus;

    private String bonus_num;

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getBonus_type() {
        return bonus_type;
    }

    public void setBonus_type(String bonus_type) {
        this.bonus_type = bonus_type;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public String getBonus_num() {
        return bonus_num;
    }

    public void setBonus_num(String bonus_num) {
        this.bonus_num = bonus_num;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("insert into Bonus_Info values('");
        sb.append(this.issue).append("','").append(this.bonus_type).append("','").append(this.bonus)
        .append("','").append(this.bonus_num).append("');");
        return sb.toString();
    }
}
