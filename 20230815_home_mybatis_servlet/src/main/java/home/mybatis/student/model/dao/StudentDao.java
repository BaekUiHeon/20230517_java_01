package home.mybatis.student.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import home.mybatis.student.model.vo.StudentVo;

public class StudentDao {
	
	public List<StudentVo> selectList(SqlSession session){
		List<StudentVo> result = session.selectList("student.selectList");
		return result;
	}
}
