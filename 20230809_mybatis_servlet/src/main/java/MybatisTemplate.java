import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisTemplate {
	public static SqlSessionFactory getSqlSessionFactory() {
		String resource="mybatis/mybatis-config.xml";
		SqlSessionFactory factory=null;
		try {
			InputStream ins=Resources.getResourceAsStream(resource);
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			factory= builder.build(ins);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return factory;
	}
}
