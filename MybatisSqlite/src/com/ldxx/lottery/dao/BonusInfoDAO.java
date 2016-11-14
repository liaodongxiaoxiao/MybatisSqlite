package com.ldxx.lottery.dao;

import com.ldxx.lottery.orm.BonusInfo;

public interface BonusInfoDAO {
	void insertBonus(BonusInfo info);
	
	void deleteByIssue(String issue);
}
