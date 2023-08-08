package kh.test.jdbckh.student.controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.student.model.dao.DepartmentDao;
import kh.test.jdbckh.student.model.vo.DepartmentVo;


/**
 * Servlet implementation class DeptGetController
 */
@WebServlet("/onedepartment")
public class DeptGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentDao dao= new DepartmentDao();
		String dept=request.getParameter("deptno");
		DepartmentVo vo=dao.selectOneDepartment(dept);
		request.setAttribute("VO", vo);
		request.getRequestDispatcher("/WEB-INF/view/tb_department_one.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
