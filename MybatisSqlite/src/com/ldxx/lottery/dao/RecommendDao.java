package com.ldxx.lottery.dao;

import java.util.List;

import com.ldxx.lottery.orm.RecDer;
import com.ldxx.lottery.orm.Recommender;

public interface RecommendDao {

	Recommender getRecommender(String issue);

	void updateRemmendData(Recommender re);

	List<Recommender> getRecommendData(String issue);

	void updateRemmend(Recommender rc);

	void insertRecDer(RecDer rec);

	RecDer getRecDer(String p_name);

	void updateRecDer(RecDer rec);

}
