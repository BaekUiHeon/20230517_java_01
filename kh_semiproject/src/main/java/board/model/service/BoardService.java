package board.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import board.model.dao.BoardDao;
import board.model.vo.WriterVo;
import board.model.vo.boardVo;

import static common.jdbc.JdbcTemplate.*;

public class BoardService {
	
	private static Connection conn=null;
	
	public int rewrite(String idx,String subject,String content) {
		int result =0;
		conn=getConnection();
		BoardDao dao=new BoardDao();
		result=dao.rewrite(conn,idx,subject,content);
		if(result==0) {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int write(String id,String subject,String content) {
		int result =0;
		conn=getConnection();
		BoardDao dao=new BoardDao();
		result=dao.write(conn,id,subject,content);
		close(conn);
		return result;
	}
	
	public String login(String id,String password) {
		conn=getConnection();
		BoardDao dao=new BoardDao();
		String result=(dao.login(conn,id,password));
		close(conn);
		return result;
	}
	public Map<String,Object> selectSearchList(int currentPage,int pageSize,String searchWord){
		conn=getConnection();
		BoardDao dao=new BoardDao();
		List<boardVo> list=null;
		int totalCnt=dao.getSearchTotalCount(conn,searchWord);
		list=dao.selectSearchList(conn,currentPage,pageSize,totalCnt,searchWord);
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("totalcnt",totalCnt);
		map.put("list",list);
		close(conn);
		return map;
	}
	public Map<String,Object> selectList(int currentPage,int pageSize){
		conn=getConnection();
		BoardDao dao=new BoardDao();
		Map<String,Object> map=new HashMap<String,Object>();
		int totalCnt= dao.getTotalCount(conn);
		List<boardVo> list=null;
		list=dao.selectList(conn,currentPage,pageSize,totalCnt);
		map.put("totalCnt",totalCnt);
		map.put("list",list);
		close(conn);
		return map;
	}
	public int signup(WriterVo vo) {
		conn=getConnection();
		BoardDao dao=new BoardDao();
		int result=dao.signup(conn,vo);
		return result;
	}
}
