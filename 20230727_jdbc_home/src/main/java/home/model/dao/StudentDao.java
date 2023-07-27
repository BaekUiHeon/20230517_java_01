package home.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import static home.template.JdbcTemplate.*;

import home.student.model.vo.StudentVo;

public class StudentDao {
	public List<StudentVo> selectListStudent(Connection conn, int currentPage, int pageSize, int totalCnt) {  // 페이징처리
		List<StudentVo> result = new ArrayList<StudentVo>();
		String query= " select * from "
				+ " (\r\n"
				+ " select tb1.*, rownum rn from"
				+ "    (select STUDENT_NO,DEPARTMENT_NO,STUDENT_NAME,STUDENT_SSN, STUDENT_ADDRESS ,to_char(ENTRANCE_DATE,'yyyy-mm-dd') ENTRANCE_DATE, ABSENCE_YN, COACH_PROFESSOR_NO from tb_student order by student_no desc) tb1"
				+ " ) tb2"
				+ " where rn between ? and ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int startRownum = 0;
		int endRownum = 0;
		System.out.println("총글개수:"+totalCnt);
		startRownum = (currentPage-1)*pageSize +1;
		endRownum = ((currentPage*pageSize) > totalCnt) ? totalCnt: (currentPage*pageSize);
		System.out.println("startRownum:"+startRownum);
		System.out.println("endRownum:"+endRownum);
		
		try {
			// 페이지당 글 읽어오기 위한 query 실행
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, startRownum);
			pstmt.setInt(2, endRownum);
			rs = pstmt.executeQuery();
			
			while(rs.next() == true) {
				StudentVo vo = new StudentVo();
				vo.setStudentNo(rs.getString("Student_No"));
				vo.setDepartmentNo( rs.getString("department_no"));
				vo.setStudentName( rs.getString("Student_Name"));
				vo.setAbsenceYn( rs.getString("Absence_Yn"));
				vo.setCoachProfessorNo( rs.getString("Coach_Professor_No"));
				vo.setStudentAddress( rs.getString("Student_Address"));
//				vo.setEntranceDate( rs.getDate("Entrance_Date") );
				vo.setEntranceDate( rs.getString("Entrance_Date") );
				
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}

		//  확인용 
		System.out.println(result);
		return result;
	}
}
