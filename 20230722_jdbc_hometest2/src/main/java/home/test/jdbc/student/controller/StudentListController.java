package home.test.jdbc.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.test.jdbc.student.model.dao.StudentDao;
import home.test.jdbc.student.model.vo.StudentVo;

/**
 * Servlet implementation class StudentListController
 */
@WebServlet("/studentlist")
public class StudentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 접속완료!!!!");
		StudentDao dao = new StudentDao();
		List<StudentVo> list=dao.selectListStudent();
		request.setAttribute("StudentList", list);
		request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
}
