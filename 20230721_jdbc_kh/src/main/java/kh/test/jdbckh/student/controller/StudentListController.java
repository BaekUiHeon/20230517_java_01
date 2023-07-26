package kh.test.jdbckh.student.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.student.model.service.StudentService;
import kh.test.jdbckh.student.model.vo.StudentVo;

/**
 * Servlet implementation class StudentListController
 */
@WebServlet({"/student/list", "/aaa"})
public class StudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/student/list doGet() 진입");
		//// 1. 전달받은 parameter 읽어내기
		String searchWord = request.getParameter("searchWord");
		String pageNoStr = request.getParameter("pageNo"); //pageNo만을 이용해서 startNum,endNum,currentNum을구함.
		// String --> int
		int currentPage = 1;  // 현재페이지
		int pageSize = 10;  // 페이지당 개수
		if(pageNoStr != null) {
			try {
				currentPage = Integer.parseInt(pageNoStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}
		//// 2. 전달받은 데이터를 활용해 
		// 2. DB학생 상세 정보 가져오기
		StudentService service = new StudentService(); 
		//List<StudentVo> result = null;
		Map<String, Object> map = null;
		if(searchWord != null) {
			// 검색
			//result = service.selectListStudent(searchWord);
			map = service.selectListStudent(currentPage, pageSize, searchWord); //현재 페이지와 페이지사이즈와 검색어가 데이터를 구하기위한 입력값임.
		} else {
			// 전체
//			result = dao.selectListStudent();
			// 페이징
			map = service.selectListStudent(currentPage, pageSize); //현재 페이지와 페이지사이즈가 데이터를 구하기위한 입력값임. 출력값으로는 List<student>와 총데이터갯수
		}
		// 3. DB로부터 전달받은 데이터를 JSP에 전달함.
		request.setAttribute("studentList", map.get("studentList"));
		// 페이징 - 
		int pageBlockSize = 5;
		int totalCnt = (Integer)map.get("totalCnt");	// 총 데이터갯수
		int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize == 0 ? 0 : 1);	//총페이지수 = 데이터갯수/페이지사이즈, + 딱안떨어지면 +1
		int startPageNum = 1;
		if((currentPage%pageBlockSize) == 0) {
			startPageNum = ((currentPage/pageBlockSize)-1)*pageBlockSize +1;
		} else {
			startPageNum = ((currentPage/pageBlockSize))*pageBlockSize +1;
		}
		int endPageNum = (startPageNum+pageBlockSize > totalPageNum) ? totalPageNum : startPageNum+pageBlockSize-1;
		request.setAttribute("totalPageNum", totalPageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("currentPage", currentPage);
		
		if(searchWord != null) {
			request.setAttribute("searchWord", searchWord);
		}
		// 4. JSP 파일 forward로 열기
		request.getRequestDispatcher("/WEB-INF/view/student/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
//	}

}
