package com.ldxx.ms.dao;

import java.util.List;

import com.ldxx.ms.orm.User;

public interface UserDao {
	/**
	 * 插入一个User
	 * 
	 * @param user
	 * @return
	 */
	boolean insertUser(User user);

	/**
	 * 更新User
	 * 
	 * @param user
	 *            待更新的User
	 * @return
	 */
	boolean updateUser(User user);

	/**
	 * 根据用户名删除User
	 * 
	 * @param name
	 * @return
	 */
	boolean deleteUserByName(String name);

	/**
	 * 获取状态值为 “status”的用户列表
	 * 
	 * @param status
	 * @return
	 */
	List<User> getUsersByStatus(int status);

}
