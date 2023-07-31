package board.controller.signup;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.WriterVo;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			request.getRequestDispatcher("/WEB-INF/view/signup/signup.jsp").forward(request, response);
			}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password1=request.getParameter("password1");
		String password2=request.getParameter("password2");
		System.out.println(password1);
		System.out.println(password2);
		
		if(!password1.equals(password2)) {
			request.setAttribute("alert",1);
			System.out.println("alert1");
			request.getRequestDispatcher("/WEB-INF/view/signup/signup.jsp").forward(request, response);
			}
		else{
			BoardService bs = new BoardService();
			WriterVo vo= new WriterVo
									(request.getParameter("id"), 
									request.getParameter("writer"),
									request.getParameter("password1"),
									request.getParameter("emailAddress")
									);
			System.out.println(vo);
			int result = bs.signup(vo);
			if(result==1) {
				System.out.println("회원가입 성공");
				request.setAttribute("alert",1);
				request.getRequestDispatcher("/WEB-INF/view/signup/login.jsp").forward(request, response);
			}
			else {
				System.out.println("회원가입 실패");
				request.setAttribute("alert",1);
				request.getRequestDispatcher("/WEB-INF/view/signup/signup.jsp").forward(request, response);
			}
		}
	}
}
