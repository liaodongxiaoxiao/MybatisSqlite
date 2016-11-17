package com.ldxx.lottery.dao;

import com.ldxx.lottery.orm.FirstDistribution;


public interface FirstDistributionDao {
	void deleteByIssue(String issue);

	void insertFirstDistribution(FirstDistribution first);
}
