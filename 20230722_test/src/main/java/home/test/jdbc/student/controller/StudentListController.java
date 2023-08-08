package home.test.jdbc.student.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.test.jdbc.student.model.StudentVo;
import home.test.jdbc.student.model.vo.StudentDao;

/**
 * Servlet implementation class StudentListController
 */
@WebServlet("/home/test") // url에서 입력할 주소 
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // 
		System.out.println("doGet 진입했습니다.");
		StudentDao dao=new StudentDao();
		List<StudentVo> result=dao.selectListStudent();
		request.setAttribute("studentList", result);
		request.setAttribute("aaa", "AAA테스트");
		request.setAttribute("bbb", "BBB테스트");
		request.getRequestDispatcher("/WEB-INF/view/student/list.jsp").forward(request,response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // 평소에 잘 안씀
//		
//	}

}
