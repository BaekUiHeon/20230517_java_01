package home.mybatis.student.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import home.mybatis.student.model.dao.StudentDao;
import home.mybatis.student.model.vo.StudentVo;

import static home.mybatis.common.MyBatisTemplate.*;

public class StudentService {

	private StudentDao dao;
	
	public StudentService() {
		super();
		dao= new StudentDao();
	}
	
	public List<StudentVo> selectList(){
		List<StudentVo> result = null;
		SqlSession session = getsqlSession();
		result = dao.selectList(session);
		session.close();
		return result;
	}
}
