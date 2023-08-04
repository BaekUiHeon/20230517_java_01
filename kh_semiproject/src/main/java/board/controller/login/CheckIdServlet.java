package board.controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;

/**
 * Servlet implementation class CheckIdServlet
 */
@WebServlet("/checkid")
public class CheckIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("아이디 체크를 위한 서블릿진입.");
		int result=0;
		String id=request.getParameter("id");
		System.out.println("id");
		PrintWriter out = response.getWriter();
		BoardService bs = new BoardService();
		result=bs.checkId(id);
		if(result==1) {
			out.print("중복된 아이디입니다.");
			out.flush();
			out.close();
		}
	}
}
