package com.ldxx.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtils {
	private static SqlSession sqlSession = null;

	static {
		try {
			// 加载配置文件
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);
			//设置为true 自动提交事务
			sqlSession = sqlMapper.openSession(true);
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private DBUtils() {

	}

	public static SqlSession getSqlSession() {
		return sqlSession;
	}
}
