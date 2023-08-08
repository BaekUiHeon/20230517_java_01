package home.test.jdbc.student.model.vo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import home.test.jdbc.student.model.StudentVo;

public class StudentDao {
	public List<StudentVo> selectListStudent(){
		Connection conn=null;
		Statement stmt=null;
		PreparedStatement pstmt=null;
		List<StudentVo> result=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");			
			conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","kh","kh");
			if(conn!=null) {
				System.out.println("DB연결 성공!!!!");
			}
			else {
				System.out.println("------DB연결 실패-------");
			}
			String sql="select * from tb_student";
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			
			result = new ArrayList<StudentVo>();
			
			while(rs.next()==true) {
				System.out.println(rs.getString("STUDENT_NAME"));
				StudentVo vo= new StudentVo();
				vo.setStudentName(rs.getString("STUDENT_NAME"));
				vo.setStudentNo(rs.getString("STUDENT_NO"));
				vo.setDepartmentNo(rs.getString("department_No"));
				vo.setStudentSSN(rs.getString("student_SSN"));
				vo.setStudentAddress(rs.getString("student_Address"));
				vo.setEntranceDate(rs.getDate("entrance_Date"));
				vo.setAbsenceYN(rs.getString("absence_YN"));
				vo.setCoachProfessorNo(rs.getString("coach_Professor_No"));
				result.add(vo);
			}
			System.out.println(result);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
