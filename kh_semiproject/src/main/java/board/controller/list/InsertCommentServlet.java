package board.controller.list;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import board.model.service.BoardService;
import board.model.vo.CommentVo;

/**
 * Servlet implementation class InsertCommentSevlet
 */
@WebServlet("/insertcomment")
public class InsertCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idx= request.getParameter("idx");
		String content= request.getParameter("content");
		String depth=request.getParameter("depth");
		String step=request.getParameter("step");
		String mid=(String)request.getSession().getAttribute("mid");
		String cidx=request.getParameter("cidx");
		int result=-1;
		BoardService bs= new BoardService();
		System.out.println("idx번호:"+idx);
		System.out.println("content:"+content);
		if(cidx==null) {
			result=bs.insertComment(idx,content,mid);
			if(result==1)
				System.out.println("comment 입력완료.");
			else if(result==-1)
				System.out.println("comment 입력실패");
			List<CommentVo> commentlist= bs.getComment(cidx);
			Gson gson = new Gson();
			
			PrintWriter out = response.getWriter();
			out.print(gson.toJson(commentlist));
			out.flush();
			out.close();
			System.out.println("commentlist 전송완료(from insertCommentServlet)");
		}
		

		else {
		result=bs.insertComment(idx,content,depth,step,mid,cidx);
		
		if(result==1)
			System.out.println("comment 입력완료.");
		else if(result==-1)
			System.out.println("comment 입력실패");
		
		List<CommentVo> commentlist= bs.getComment(cidx);
		Gson gson = new Gson();
		
		PrintWriter out = response.getWriter();
		out.print(gson.toJson(commentlist));
		out.flush();
		out.close();
		System.out.println("commentlist 전송완료(from insertCommentServlet)");
	    }
	}
}
