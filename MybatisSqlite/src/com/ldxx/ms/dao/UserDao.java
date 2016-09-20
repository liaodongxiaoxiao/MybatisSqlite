package com.ldxx.ms.dao;

import java.util.List;

import com.ldxx.ms.orm.User;

public interface UserDao {
	/**
	 * ����һ��User
	 * 
	 * @param user
	 * @return
	 */
	boolean insertUser(User user);

	/**
	 * ����User
	 * 
	 * @param user
	 *            �����µ�User
	 * @return
	 */
	boolean updateUser(User user);

	/**
	 * �����û���ɾ��User
	 * 
	 * @param name
	 * @return
	 */
	boolean deleteUserByName(String name);

	/**
	 * ��ȡ״ֵ̬Ϊ ��status�����û��б�
	 * 
	 * @param status
	 * @return
	 */
	List<User> getUsersByStatus(int status);

}
