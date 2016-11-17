package com.ldxx.lottery.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.ldxx.lottery.dao.ContinuousBallDAO;
import com.ldxx.lottery.orm.ContinuousBall;

public class ContinuousBallDAOImpl implements ContinuousBallDAO {
	private SqlSession sqlSession;
	
	public ContinuousBallDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void deleteByIssue(String issue) {
		sqlSession.update("ContinuousBall.deleteByIssue", issue);
	}

	@Override
	public void insert(ContinuousBall cb) {
		sqlSession.insert("ContinuousBall.insertCB", cb);
	}

}
