package home.test.jdbc.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import home.test.jdbc.student.model.model.StudentVo;

public class StudentDao {
	public List<StudentVo> selectListStudent() {
		Connection conn=null;
//		Statement stmt=null;
		PreparedStatement pstmt=null;
		List<StudentVo> result=new ArrayList<StudentVo>();
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클 드라이버 생성
		conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","kh","kh");
		String sql="select * from tb_student";
		pstmt=conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()==true) {
			StudentVo vo=new StudentVo();
			vo.setStudentName(rs.getString("STUDENT_NAME"));
			vo.setStudentAddress(rs.getString("STUDENT_ADDRESS"));
			vo.setStudentNo(rs.getString("STUDENT_NO"));
			result.add(vo);
		}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
