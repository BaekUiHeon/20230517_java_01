package kh.test.jdbckh.student.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.student.model.vo.StudentVo;

public class StudentDao { 
	public List<StudentVo> selectListStudent() {
		Connection conn=null;
		Statement stmt=null; //보안에 취약
		PreparedStatement pstmt=null; // statement의 진화버전  
		List<StudentVo> result=null;
		try {
			//1. 드라이버 없다면 오류발생. 
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			//2. Conection 객체 생성. (데이터베이스와 연결시도)
			conn= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","kh","kh");
			if(conn!=null) {
				System.out.println("DB연결 성공!!!!!!!");
			}
			else {
				System.out.println("-------DB연결 실패-------");
			}
			//3. Statement/PrepareStatement 객체 생성 -conn 객체로부터, query문을 실어서보냄.
//			stmt= conn.createStatement();
			String sql="select * from tb_student"; // 또는 String query=
			pstmt= conn.prepareStatement(sql);
			//4. query문을 실행하고 그결과값을 return받음.
			ResultSet rs=pstmt.executeQuery();
			//5. ResultSet에서 레코드 한줄 읽어오기 위해 cursor(포인트)를 이동함.
			result = new ArrayList<StudentVo>();
			while(rs.next() == true) {
				System.out.println(rs.getString("STUDENT_NAME"));
				StudentVo vo= new StudentVo();
				vo.setStudentName(rs.getString("STUDENT_NAME"));
				vo.setDepartmentNo(rs.getString("DEPARTMENT_no"));
				vo.setStudentNo(rs.getString("STUDENT_NO"));
				vo.setStudentSsn(rs.getString("STUDENT_SSN"));
				vo.setStudentAddress(rs.getString("STUDENT_ADDRESS"));
				vo.setEntranceDate(rs.getDate("ENTRANCE_DATE"));
				vo.setAbsenceYn(rs.getString("ABSENCE_YN"));
				vo.setCoachProfessorNo(rs.getString("COACH_PROFESSOR_NO"));
				result.add(vo);
			}
			System.out.println(result);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		finally {
//			try {
//			if(pstmt!=null)
//				pstmt.close();
//			if(stmt!=null)
//				stmt.close();
//			if(conn!=null)
//				conn.close();
//			}
//			catch(SQLException e) {
//				e.printStackTrace();
//			}
//		}
		return result;
	}
}