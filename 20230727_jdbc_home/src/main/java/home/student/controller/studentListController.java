package home.student.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class studentListController
 */
@WebServlet("/studentListController")
public class studentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get 진입");
		String searchWord=request.getParameter("searchWord");
		String pageNoStr=request.getParameter("PageNo");
		
		int currentPage=1;
		int pageSize=10;
		
		if(pageNoStr!=null) {
			try {
				currentPage=Integer.parseInt(pageNoStr);
			}
			catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}
		
		StudentService service = new StudentService();
		
		Map<String,Object> map=null;
		
		if(searchWord!=null) {
			map=service.selectListStudent(currentPage,pageSize,searchWord);
		}
		else {
			map=service.selectListStudent(currentPage,pageSize);
		}
		request.setAttribute("StudentList",map.get("StudentList"));
		
		int pageBlockSize =5;
		int totalCnt=(Integer)map.get("totalCnt");
		int totalPageNum=totalCnt/pageSize + (totalCnt % pageSize==0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%pageBlockSize)==0) {                             //마지막번호일때 (5배수일때)
			startPageNum=((currentPage/pageBlockSize)-1)*pageBlockSize+1; // -1을 해줘야 startPageNum이 맞음
		} else {
			startPageNum=((currentPage/pageBlockSize))*pageBlockSize+1;  //현재 페이지가 마지막번호가아니면 그대로해야 StartPageNum이맞음
		}
		int endPageNum=(startPageNum + pageBlockSize>totalPageNum) ? totalPageNum: startPageNum+pageBlockSize-1;
		
		request.setAttribute("totalPageNum", totalPageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("currentPage", currentPage);
	if(searchWord!=null) {
		request.setAttribute("searchWord",searchWord);
	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
//	}
	}
}
