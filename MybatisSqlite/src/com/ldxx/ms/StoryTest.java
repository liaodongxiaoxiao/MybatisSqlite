package com.ldxx.ms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.ldxx.ms.dao.StoryDao;
import com.ldxx.ms.dao.impl.StoryDaoImpl;
import com.ldxx.ms.orm.Story;
import com.ldxx.ms.utils.DBUtils;
import com.spreada.utils.chinese.ZHConverter;

public class StoryTest {
	public static void main(String[] args) {
		StoryDao dao = new StoryDaoImpl(DBUtils.getSqlSession());
		List<Story> list =dao.getStory();
		String date;
		Calendar c = Calendar.getInstance();
		ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd hh:MM", Locale.getDefault());
		for(Story story :list){
			System.out.println("----"+story.getPid()+" "+format.format(story.getDate_time()));
			story.setTitle(converter.convert(story.getTitle()));
			story.setContent(converter.convert(story.getContent()));
			dao.updateStory(story);
			
			/*c.setTime(story.getDate_time());
			if(c.get(Calendar.YEAR)>2016){
				c.set(Calendar.YEAR, 2016);
				story.setDate_time(c.getTime());
				dao.updateStory(story);
			}*/
			/*date = story.getDate_time();
			if(date.contains("Posted:")){
				date = date.substring(date.lastIndexOf("Posted:")+7, date.length()).trim();
				System.out.println(story.getPid()+" "+date);
				story.setDate_time(date);
				dao.updateStory(story);
			}
			if(date.length()>date.trim().length()){
				System.out.println(story.getPid()+" "+date);
				story.setDate_time(date.trim());
				dao.updateStory(story);
			}
			if(date.length()!=16){
				System.out.println("----"+story.getPid()+" "+date);
			}
			try {
				story.setDate_time(String.valueOf(format.parse(date).getTime()));
				dao.updateStory(story);
			} catch (ParseException e) {
				e.printStackTrace();
			}*/
			//System.out.println("----"+story.getPid()+" "+date);
			
		}
	}
}
