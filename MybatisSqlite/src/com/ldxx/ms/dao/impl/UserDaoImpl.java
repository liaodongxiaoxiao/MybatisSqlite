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
	 * ����һ��User
	 * 
	 * @param user
	 * @return
	 */
	public boolean insertUser(User user) {
		return 1 == sqlSession.insert("com.ldxx.ms.orm.User.insert", user);
	}

	/**
	 * ����User
	 * 
	 * @param user
	 *            �����µ�User
	 * @return
	 */
	public boolean updateUser(User user) {
		return 1 == sqlSession.update("com.ldxx.ms.orm.User.update", user);
	}

	/**
	 * �����û���ɾ��User
	 * 
	 * @param name
	 * @return
	 */
	public boolean deleteUserByName(String name) {
		return sqlSession.delete("com.ldxx.ms.orm.User.delete", name) > 0;
	}

	/**
	 * ��ȡ״ֵ̬Ϊ ��status�����û��б�
	 * 
	 * @param status
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUsersByStatus(int status) {
		return sqlSession.selectList("com.ldxx.ms.orm.User.getUserByStatus", status);
	}

}
