package com.ldxx.lottery.dao;

import com.ldxx.lottery.orm.ContinuousBall;

public interface ContinuousBallDAO {
	void deleteByIssue(String issue);
	void insert(ContinuousBall cb);
}
