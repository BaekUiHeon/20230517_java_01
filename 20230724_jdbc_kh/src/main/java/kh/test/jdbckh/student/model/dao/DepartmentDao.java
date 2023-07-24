package kh.test.jdbckh.student.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import kh.test.jdbckh.student.model.vo.DepartmentVo;

public class DepartmentDao {
	public List<DepartmentVo> selectListDepartment(){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<DepartmentVo> result=null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 연결완료");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","kh","kh");
		System.out.println("데이터베이스 접속완료.");
		pstmt=conn.prepareStatement("select * from tb_department");
		rs=pstmt.executeQuery();
		result=new ArrayList<DepartmentVo>();
		while(rs.next()==true) {
			DepartmentVo dept= new DepartmentVo(); 
			dept.setDepartmentNo(rs.getString("DEPARTMENT_NO"));
			dept.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
			dept.setCategory(rs.getString("CATEGORY")); 
			dept.setCapacity(rs.getInt("CAPACITY"));
			dept.setOpenYN(rs.getString("OPEN_YN"));
			result.add(dept);
		}
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
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
	public DepartmentVo selectOneDepartment(String deptNo) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<DepartmentVo> result=null;
		DepartmentVo dept=null;
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 연결완료");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","kh","kh");
		System.out.println("데이터베이스 접속완료.");
		pstmt=conn.prepareStatement("select * from tb_department where department_no="+"'"+deptNo+"'");
		rs=pstmt.executeQuery();
		rs.next();
		dept= new DepartmentVo(); 
		dept.setDepartmentNo(rs.getString("DEPARTMENT_NO"));
		dept.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
		dept.setCategory(rs.getString("CATEGORY")); 
		dept.setCapacity(rs.getInt("CAPACITY"));
		dept.setOpenYN(rs.getString("OPEN_YN"));
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try{
				if(rs!=null)
					rs.close();
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dept;
	}
}