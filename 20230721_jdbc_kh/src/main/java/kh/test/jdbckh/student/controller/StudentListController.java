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
		String searchWord = request.getParameter("searchWord");
		String pageNoStr = request.getParameter("pageNoStr");
		int currentPage = 1; 
		int pageSize = 10;  
		if(pageNoStr != null) {
			try {
				currentPage = Integer.parseInt(pageNoStr);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		StudentService service = new StudentService(); 
		Map<String, Object> map = null;
		if(searchWord != null) {
			map = service.selectListStudent(currentPage, pageSize, searchWord);
		} else {
			map = service.selectListStudent(currentPage, 10);
		}
		request.setAttribute("studentList", map.get("studentList"));
		int pageBlockSize = 5;
		int totalCnt = (Integer)map.get("totalCnt");
		int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize == 0 ? 0 : 1);
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
		request.getRequestDispatcher("/WEB-INF/view/student/list.jsp").forward(request, response);
	}
}
