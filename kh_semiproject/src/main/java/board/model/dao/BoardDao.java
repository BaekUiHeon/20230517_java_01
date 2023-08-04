package board.model.dao;
import static common.jdbc.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.model.vo.CommentVo;
import board.model.vo.WriterVo;
import board.model.vo.boardVo;

public class BoardDao {
	public List<CommentVo> getComment(Connection conn,String idx){
		List<CommentVo> commentList=null;
		BoardDao dao=new BoardDao();
		commentList=dao.getComment(conn,idx);
		String query="select * from tbl_comment where idx=? order by "; 
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		return commentList;
	}
	
	public int insertLike(Connection conn,String mid,String idx) {
		int result=-1;
		String query="insert into like values(?,?)";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,idx);
			pstmt.setString(2,mid);
			result=pstmt.executeUpdate();
			System.out.println("dao like입력완료");
			if(rs.next()) {
				result=1;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int deleteLike(Connection conn,String mid,String idx) {
		int result=-1;
		String query="delete from tbl_like where idx=? and id=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,idx);
			pstmt.setString(2,mid);
			result=pstmt.executeUpdate();
			System.out.println("dao like삭제완료");
			if(rs.next()) {
				result=1;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int checkLike(Connection conn,String mid,String idx) {
		int result=0;
		String query="select id countlike from like where id=? and idx=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,mid);
			pstmt.setString(2,idx);
			result=pstmt.executeUpdate();
			if(rs.next()) {
				result=1;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
		return result;
	}
	public int countLike(Connection conn,String idx) {
		int result=-1;
		String query="select count(*) countlike from like where idx=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,idx);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally{
			close(rs);
			close(pstmt);
		}
			return result;
	}
	
	public boardVo getBoard(Connection conn,String idx) {
		String query="select idx,subject,content,to_char(wdate),id from tbl_board where idx=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		boardVo vo=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,idx);
			rs=pstmt.executeQuery();
			vo=new boardVo();
			if(rs.next()) {
				vo.setIdx(rs.getString(1));
				vo.setSubject(rs.getString(2));
				vo.setContent(rs.getString(3));
				vo.setWdate(rs.getString(4));
				vo.setId(rs.getString(5));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		return vo;
	}
	
	public int write(Connection conn,String mid,String subject,String content) {
		int result=0;
		String query="insert into tbl_board (id,subject,content) values(?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,mid);
			pstmt.setString(2,subject);
			pstmt.setString(3,content);
			System.out.println("wirte의 exceuteUpdate직전");
			result=pstmt.executeUpdate();
			System.out.println("데이터베이스 게시물 insert완료");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		return result;
	}
	
	public int rewrite(Connection conn,String idx,String subject,String content) {
		int result=0;
		String query="update tbl_board set content=? where idx=?";
		PreparedStatement pstmt=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,content);
			pstmt.setString(2,idx);
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		if(result==1) { //content가 바뀌었다면 뒤이어 제목도 바꿈. service에서 rollback처리.
			query="update tbl_board set subject=? where idx=?";
			try {
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,subject);
				pstmt.setString(2,idx);
				result=pstmt.executeUpdate();
				System.out.println("데이터베이스 게시물 수정완료");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				close(pstmt);
			}
		}
		return result;
	}
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

	public int checkId(Connection conn, String id) {
		System.out.println("dao [checkId] id : "+id);
		int result=0;
		String query="select id from tbl_writer where id=?";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1,id);
			rs=pstmt.executeQuery();
			if(rs.next()) {				
				if(rs.getString("id").equals(id))
					result=1;
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			close(pstmt);
			close(rs);
		}
		System.out.println("dao [checkId] return : "+result);
		return result;
	}
}
