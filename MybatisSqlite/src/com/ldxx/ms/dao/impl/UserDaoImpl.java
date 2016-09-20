package com.ldxx.ms.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ldxx.ms.dao.UserDao;
import com.ldxx.ms.orm.User;

public class UserDaoImpl implements UserDao {

	private SqlSession sqlSession;

	public UserDaoImpl(SqlSession sqlSession) {
		super();
		this.sqlSession = sqlSession;
	}

	/**
	 * 插入一个User
	 * 
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user) {
		return 1 == sqlSession.insert("com.ldxx.ms.orm.User.insert", user);
	}

	/**
	 * 更新User
	 * 
	 * @param user
	 *            待更新的User
	 * @return
	 */
	public boolean updateUser(User user) {
		return 1 == sqlSession.update("com.ldxx.ms.orm.User.update", user);
	}

	/**
	 * 根据用户名删除User
	 * 
	 * @param name
	 * @return
	 */
	public boolean deleteUserByName(String name) {
		return sqlSession.delete("com.ldxx.ms.orm.User.delete", name) > 0;
	}

	/**
	 * 获取状态值为 “status”的用户列表
	 * 
	 * @param status
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUsersByStatus(int status) {
		return sqlSession.selectList("com.ldxx.ms.orm.User.getUserByStatus", status);
	}

}
