package home.mybatis.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTemplate {
	public static SqlSession getsqlSession() {
		String resource = "mybatis/mybatis-config.xml";
		SqlSession session=null;
		try {
		InputStream is=Resources.getResourceAsStream(resource);
		
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
	    SqlSessionFactory factory = builder.build(is);
	    session=factory.openSession();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return session;
	}
}
