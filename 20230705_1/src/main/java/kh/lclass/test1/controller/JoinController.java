package kh.lclass.test1.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Join
 */
@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/WEB-INF/view/join.jsp").forward(request, response);
		System.out.println("여기 get 들어왔음");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("여기 POST 들어왔음");
		String id= request.getParameter("mid");
		String pwd=request.getParameter("mpwd");
		System.out.println("id:"+id);
		System.out.println("pwd:"+pwd);
		int result=1;
		
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/login"); //오류 
		}
		else {
			
		}
		//DB에 저장하러가기 할것임
		//DB에 잘 저장했다면
		//로그인 화면으로 이동 
		//메인화면으로 이동 
		
		//DB에 저장하지 못했다면
		//경고창 띄우고 다시 회원가입화면
		//또는 메인화면으로 
	}
}
