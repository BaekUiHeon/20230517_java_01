package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.kh.test.user.model.vo.UserDTO;

public class UserDAO {
	public UserDTO getUser(String userNo){
	ResultSet rs=null;
	PreparedStatement pstmt=null;
	Connection conn=null;
	UserDTO dto=null;
	String query="select user_no,user_id,user_name,user_age from tb_user where user_no=?";
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","system","oracle");
		pstmt=conn.prepareStatement(query);
		pstmt.setString(1, userNo);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			dto=new UserDTO();
			dto.setUserNo(rs.getString(1));
			dto.setUserId(rs.getString(2));
			dto.setUserName(rs.getString(3));
			dto.setUserAge(rs.getString(4));
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
		if(pstmt!=null) {
			pstmt.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	return dto;
	}
}
