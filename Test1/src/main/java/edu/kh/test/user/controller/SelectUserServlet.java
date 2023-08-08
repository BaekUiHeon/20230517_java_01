package edu.kh.test.user.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;

/**
 * Servlet implementation class SelectUserServlet
 */
@WebServlet("/selectUser")
public class SelectUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNo= request.getParameter("userNo");
		if(userNo!=null) {
			//service,dao 만든이후 작성해야함.
			UserDAO dao= new UserDAO();
			UserDTO dto=dao.getUser(userNo);
			if(dto!=null) {
			request.setAttribute("vo",dto);
			request.getRequestDispatcher("/WEB-INF/views/searchSuccess.jsp").forward(request, response);;
			}
			else {
			request.getRequestDispatcher("/WEB-INF/views/searchFail.jsp").forward(request, response);
			}
		}
		else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
}
