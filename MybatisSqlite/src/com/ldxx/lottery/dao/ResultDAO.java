package com.ldxx.lottery.dao;

import com.ldxx.lottery.orm.LotteryResult;

public interface ResultDAO {

	LotteryResult getResultByIssue(String issue);
}
