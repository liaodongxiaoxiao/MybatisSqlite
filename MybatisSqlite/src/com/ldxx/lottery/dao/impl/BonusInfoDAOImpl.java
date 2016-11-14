package com.ldxx.lottery.dao.impl;

import org.apache.ibatis.session.SqlSession;

import com.ldxx.lottery.dao.BonusInfoDAO;
import com.ldxx.lottery.orm.BonusInfo;

public class BonusInfoDAOImpl implements BonusInfoDAO {
	private SqlSession sqlSession;

	public BonusInfoDAOImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	@Override
	public void insertBonus(BonusInfo info) {
		sqlSession.insert("BonusInfo.insert",info);
	}

	@Override
	public void deleteByIssue(String issue) {
		sqlSession.delete("BonusInfo.deleteByIssue",issue);
	}

}
