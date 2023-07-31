package board.model.dao;
import static common.jdbc.JdbcTemplate.*;
import static common.jdbc.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.model.vo.WriterVo;
import board.model.vo.boardVo;

public class BoardDao {
	public String login(Connection conn,String id,String password) {
		String result=null;
		PreparedStatement pstmt=null;
		String query="select password from TBL_WRITER where id=?";
		ResultSet rs= null;
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,id);
				rs=pstmt.executeQuery();
				if(rs.next()==true) {
					result=rs.getString("password");
					System.out.println("데이터 베이스에서 로그인 가능여부 확인");
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
		String query="select * from (select tb1.*,rownum rn from((select writer,IDX,subject,content,to_char(WDATE,'yyyy-mm-dd') wdate,ID from TBL_BOARD join TBL_writer using (id) order by IDX) Tb1)) where rn between ? and ?";	
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,startRownum);
			pstmt.setInt(2,endRownum);
			rs=pstmt.executeQuery();
			result=new ArrayList<boardVo>();
			while(rs.next()==true) {
				boardVo vo=new boardVo
						(rs.getString("idx"),
						rs.getString("subject"),
						rs.getString("content"),
						rs.getString("wdate"),
						rs.getString("id"),
						rs.getString("writer"));
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
		String query="select * from (select tb1.*,rownum rn from((select IDX,subject,content,to_char(WDATE,'yyyy-mm-dd'),ID from TBL_BOARD where subject like ? or content like ? order by IDX) Tb1) where rn between ? and ?)";	
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
						(rs.getString("idx"),
						rs.getString("subject"),
						rs.getString("content"),
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
	public int signup(Connection conn,WriterVo vo) {
		int result=0;
		String query="insert into tbl_writer values(?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2,vo.getWriter());
			pstmt.setString(3,vo.getPassword());
			pstmt.setString(4,vo.getEmailAddress());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
}
