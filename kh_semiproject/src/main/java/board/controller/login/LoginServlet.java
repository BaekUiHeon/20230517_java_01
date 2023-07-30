package board.controller.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.boardVo;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/signup/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardService bs=new BoardService();
		System.out.println("로그인 시도시작");
		int result=0;
		result = bs.login(request.getParameter("id"),request.getParameter("password"));
		if(result==1) {
			request.setAttribute("success", 1);
			System.out.println("로그인 완료");
			List<boardVo> list=bs.selectlist();
			request.setAttribute("list", list)
			request.getRequestDispatcher("/WEB-INF/view/content/list.jsp").forward(request, response);	
		}
		if(result==0) {
			request.setAttribute("success", 1);
			System.out.println("로그인 실패");
			request.getRequestDispatcher("/WEB-INF/view/signup/login.jsp").forward(request, response);
		}
	}

}
