package board.controller.write;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시물작성 서블릿 doget접속.");
		String subject = request.getParameter("subject");
		
		if(subject!=null) { //제목이 있다는것은 수정이라는 뜻이니    제목,내용,게시글번호를 가지고 write.jsp를 열어라 (계정작업필요)
			request.setAttribute("subject", subject);
			request.setAttribute("content", request.getParameter("content"));
			request.setAttribute("idx",request.getParameter("idx"));
			request.getRequestDispatcher("/WEB-INF/view/content/write.jsp").forward(request, response);
		}
		else { // 아니라면 수정이 아니라 새로운 작성이므로 그냥 연다. (계정작업필요)
			request.getRequestDispatcher("/WEB-INF/view/content/write.jsp").forward(request, response);
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
