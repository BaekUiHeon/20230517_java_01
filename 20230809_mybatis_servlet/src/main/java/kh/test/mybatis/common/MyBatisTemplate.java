package kh.test.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTemplate {
	public static SqlSession getSqlSession() { 
		String resource = "mybatis/mybatis-config.xml"; // 만들게될 SqlSessionFactory에 대한 정의가 존재하는 경로의 문자열
		SqlSession session = null;   					// 가져오게될 세션을 위한 대한 변수 선언
		try {
			InputStream is = Resources.getResourceAsStream(resource); // InputStream으로 경로에 존재하는 정보를 가져옴
			
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); // 읽어온 정보로 Factorybuilder를 만듬
			SqlSessionFactory factory = builder.build(is); // Factorybuilder로 Factory를 만듬
			session = factory.openSession();				// factory로 SqlSession 객체를 만듬
		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}														// close()는 필요없는지?
}
