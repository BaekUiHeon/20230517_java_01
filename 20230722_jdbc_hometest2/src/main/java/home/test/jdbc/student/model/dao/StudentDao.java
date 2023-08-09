package home.test.jdbc.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import home.test.jdbc.student.model.vo.StudentVo;

public class StudentDao {
	public List<StudentVo> selectListStudent(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<StudentVo> result=new ArrayList<StudentVo>();
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 불러오기완료");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","kh","kh"); //계정접속
		System.out.println("데이터베이스 접속완료");
	    pstmt=conn.prepareStatement("Select * from tb_Student"); 
	    rs=pstmt.executeQuery();
	    while(rs.next()==true) {
	    	StudentVo vo=new StudentVo();
	    	vo.setStudentName(rs.getString("Student_Name"));
	    	vo.setStudentNo(rs.getString("Student_No"));
	    	vo.setStudentSSN(rs.getString("Student_SSN"));
	    	result.add(vo);
	    }
	    }
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null)
				pstmt.close();
			if(conn!=null)
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
