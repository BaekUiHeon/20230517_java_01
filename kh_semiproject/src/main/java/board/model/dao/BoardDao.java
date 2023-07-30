package board.model.dao;
import static common.jdbc.JdbcTemplate.*;
import static common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.model.vo.boardVo;

public class BoardDao {
	public int login(Connection conn,String id,String password) {
		int result=0;
		PreparedStatement pstmt=null;
		String query="select id,password,writer from TBL_WRITER where id=? and password=?";
		ResultSet rs= null;
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,id);
				pstmt.setString(2,password);
				rs=pstmt.executeQuery();
				if(rs.next()==true) {
					result=1;
					System.out.println("로그인 가능");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				close(pstmt);
				close(rs);
			}
		return result;
	}
	public List<boardVo> selectList(Connection conn, int currentPage, int pageSize, int totalCnt){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<boardVo> result=null;
		int startRownum = 0;
		int endRownum = 0;
		System.out.println("총글개수:"+totalCnt);
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
		System.out.println("startRownum:"+startRownum);
		System.out.println("endRownum:"+endRownum);
		String query="select * from (select tb1.*,rownum rn from((select IDX,SUBJECT,CONTENT,to_char(WDATE,'yyyy-mm-dd'),ID from TBL_BOARD order by IDX) Tb1) where rn between ? and ?)";	
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,startRownum);
			pstmt.setInt(2,endRownum);
			rs=pstmt.executeQuery();
			result=new ArrayList<boardVo>();
			while(rs.next()==true) {
				boardVo vo=new boardVo
						(rs.getInt("NUMBER"),
						rs.getString("SUBJECT"),
						rs.getString("CONTENT"),
						rs.getString("wdate"),
						rs.getString("id"));
					result.add(vo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
			close(pstmt);
			close(rs);
			}
		return result;
	}
	public int getTotalCount(Connection conn) {
		int result=0;
		String query="select count(*) total_count from tbl_board";
		ResultSet rs= null;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(query);
			rs=pstmt.executeQuery();
			if(rs.next()==true)
				result=rs.getInt("total_count");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int getSearchTotalCount(Connection conn,String searchWord) {
		int result=0;
		String query="select count(*) total_count from tbl_board where content like ? or subject like ?";
		ResultSet rs= null;
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(query);
			String searchWord1="%"+searchWord+"%";
			pstmt.setString(1, searchWord1);
			pstmt.setString(1, searchWord1);
			rs=pstmt.executeQuery();
			if(rs.next()==true)
				result=rs.getInt("total_count");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public List<boardVo> selectSearchList(Connection conn, int currentPage, int pageSize, int totalCnt,String searchWord){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<boardVo> result=null;
		int startRownum = 0;
		int endRownum = 0;
		System.out.println("총글개수:"+totalCnt);
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
		System.out.println("startRownum:"+startRownum);
		System.out.println("endRownum:"+endRownum);
		String query="select * from (select tb1.*,rownum rn from((select IDX,SUBJECT,CONTENT,to_char(WDATE,'yyyy-mm-dd'),ID from TBL_BOARD where subject like ? or content like ? order by IDX) Tb1) where rn between ? and ?)";	
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,searchWord);
			pstmt.setString(2,searchWord);
			pstmt.setInt(3,startRownum);
			pstmt.setInt(4,endRownum);
			rs=pstmt.executeQuery();
			result=new ArrayList<boardVo>();
			while(rs.next()==true) {
				boardVo vo=new boardVo
						(rs.getInt("NUMBER"),
						rs.getString("SUBJECT"),
						rs.getString("CONTENT"),
						rs.getString("wdate"),
						rs.getString("id"));
					result.add(vo);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
			close(pstmt);
			close(rs);
			}
		return result;
	}
}
