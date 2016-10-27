package com.ldxx.ms.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ldxx.ms.dao.StoryDao;
import com.ldxx.ms.orm.Story;

public class StoryDaoImpl implements StoryDao {
	private SqlSession sqlSession;

	public StoryDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Story> getStory() {
		return sqlSession.selectList("com.ldxx.ms.orm.Story.getStory");
	}

	@Override
	public boolean updateStory(Story story) {
		
		return 1== sqlSession.update("com.ldxx.ms.orm.Story.update", story);
	}

}
