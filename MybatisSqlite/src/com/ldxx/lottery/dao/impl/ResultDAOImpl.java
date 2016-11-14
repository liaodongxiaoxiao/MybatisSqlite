package com.ldxx.lottery.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ldxx.lottery.dao.ResultDAO;
import com.ldxx.lottery.orm.LotteryResult;

public class ResultDAOImpl implements ResultDAO {

	private SqlSession sqlSession;

	public ResultDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public LotteryResult getResultByIssue(String issue) {
		@SuppressWarnings("unchecked")
		List<LotteryResult> list = sqlSession.selectList("LotteryResult.queryByIssue", issue);
		if(list!=null&&!list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

}
