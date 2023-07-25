package kh.test.jdbckh.student.model.dao;
import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;
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
		conn = getConnection();
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
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
		close(rs);
		close(pstmt);
		close(conn);
		}
		return result;
	}
	public List<DepartmentVo> selectListDepartment(String searchWord){
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<DepartmentVo> result=null;
		try {
		conn = getConnection();
		pstmt=conn.prepareStatement("select * from tb_department where CATEGORY=?");
		pstmt.setString(1,searchWord);
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
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
		close(rs);
		close(pstmt);
		close(conn);
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
		conn = getConnection();
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
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
		close(rs);
		close(pstmt);
		close(conn);
		}
		return dept;
	}
}