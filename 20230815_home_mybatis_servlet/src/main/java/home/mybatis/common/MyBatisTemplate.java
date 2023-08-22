package home.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTemplate {
	public static SqlSession getSession() {
		SqlSession session=null;
		try {
			session=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml")).openSession();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
}
