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

public class StudentDao { // 데이터베이스와의 연결과  데이터 통신을 위한 클래스. 
	public List<StudentVo> selectListStudent() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		List<StudentVo> result=new ArrayList<StudentVo>();
		try {
		//오라클 드라이버 생성	
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		//드라이버를 통해서 접속생성
		conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","kh","kh");
		String sql="select * from tb_student";
		pstmt=conn.prepareStatement(sql);
		//쿼리에 대한 반환은 ResultSet형태이므로, ResultSet변수를 선언하여 저장한다.
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()==true) {
			StudentVo vo=new StudentVo(); 
			vo.setStudentName(rs.getString("STUDENT_NAME")); //데이터베이스내의 이름으로 가져올수있음.
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