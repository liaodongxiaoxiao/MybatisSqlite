package com.ldxx.lottery.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.ldxx.lottery.dao.FirstDistributionDao;
import com.ldxx.lottery.orm.FirstDistribution;


public class FirstDistributionDaoImpl implements FirstDistributionDao {
	
	private SqlSession sqlSession;

	

	public FirstDistributionDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public void deleteByIssue(String issue) {
		sqlSession.delete("FirstDistribution.deleteByIssue",issue);
	}

	@Override
	public void insertFirstDistribution(FirstDistribution first) {
		sqlSession.insert("FirstDistribution.insertFirstDistribution", first);
	}

}
