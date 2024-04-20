package kh.mclass.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTemplate {
	public static SqlSession getSqlSession(boolean autoCommit) {
		String resource = "mybatis-config.xml";
		SqlSession sqlSession = null;
		
		try {
			// InputStream으로 Mybatis 설정 정보 읽어옴
			// InputStream is = Resources.getResourceAsStream(resource); // singleton
			// 읽어온 Mybatis 설정 정보를 바탕으로 SqlSessionFactoryBuilder 생성
			
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			sqlSession = sqlSessionFactory.openSession(autoCommit);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}
}
