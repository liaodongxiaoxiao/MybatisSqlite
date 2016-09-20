package com.ldxx.ms;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import com.ldxx.ms.dao.UserDao;
import com.ldxx.ms.dao.impl.UserDaoImpl;
import com.ldxx.ms.orm.User;
import com.ldxx.ms.utils.DBUtils;

public class Test {
	public static void main(String[] args) {
		UserDao dao = new UserDaoImpl(DBUtils.getSqlSession());
		/*User green = new User();
		green.setUser_name("GREEN");
		green.setBirthday(Calendar.getInstance().getTime());
		green.setPid(UUID.randomUUID().toString());
		green.setStatus(0);
		dao.insertUser(green);*/
		
		/*User u = new User();
		u.setPid("11");
		u.setStatus(0);
		dao.updateUser(u);*/
		
		List<User> user1 = dao.getUsersByStatus(0);
		System.out.println(user1);
		
		dao.deleteUserByName("22");
		user1 = dao.getUsersByStatus(0);
		System.out.println(user1);
		
	}

}
