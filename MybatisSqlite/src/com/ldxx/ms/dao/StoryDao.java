package com.ldxx.ms.dao;

import java.util.List;

import com.ldxx.ms.orm.Story;

public interface StoryDao {
	List<Story> getStory();
	boolean updateStory(Story story);
}
