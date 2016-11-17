package com.ldxx.lottery.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ldxx.lottery.dao.RecommendDao;
import com.ldxx.lottery.orm.RecDer;
import com.ldxx.lottery.orm.Recommender;

public class RecommendDaoImpl implements RecommendDao {
	private SqlSession sqlSession;

	public RecommendDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public Recommender getRecommender(String issue) {
		@SuppressWarnings("unchecked")
		List<Recommender> list = (List<Recommender>) sqlSession.selectList("Recommend.getRecommender", issue);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void updateRemmendData(Recommender re) {
		sqlSession.update("Recommend.updateRecommendData", re);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recommender> getRecommendData(String issue) {

		return (List<Recommender>) sqlSession.selectList("Recommend.getRecommendData", issue);
	}

	@Override
	public void updateRemmend(Recommender re) {
		sqlSession.update("Recommend.updateRemmend", re);
	}

	@Override
	public void insertRecDer(RecDer rec) {
		sqlSession.insert("Recommend.insertRecDer", rec);
	}

	@Override
    public RecDer getRecDer(String p_name) {
        @SuppressWarnings("unchecked")
        List<RecDer> list = (List<RecDer>) sqlSession.selectList(
                "Recommend.getRecDer", p_name);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

	@Override
    public void updateRecDer(RecDer rec) {
        sqlSession.update("Recommend.updateRecDer", rec);
    }

}
