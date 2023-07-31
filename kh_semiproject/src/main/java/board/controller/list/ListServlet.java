package board.controller.list;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.service.BoardService;
import board.model.vo.boardVo;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchWord=(String)request.getAttribute("searchWord");
		String PageNoStr=(String)request.getAttribute("PageNo");
		int currentPage=1;
		int pageSize=10;
		int pageBlockSize=10;
		try {
			currentPage=Integer.parseInt(PageNoStr);
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		BoardService bs=new BoardService();
		if(searchWord==""||searchWord==null) {
			Map<String,Object> map = bs.selectList(currentPage,pageSize);
			List<boardVo> list=(List<boardVo>)map.get("list");
			int totalCnt=(int)map.get("totalCnt");
			int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize == 0 ? 0 : 1);
			int startPageNum = 1;
			if((currentPage%pageBlockSize) == 0) {
				startPageNum = ((currentPage/pageBlockSize)-1)*pageBlockSize +1;
			} else {
				startPageNum = ((currentPage/pageBlockSize))*pageBlockSize +1;
			}
			int endPageNum = (startPageNum+pageBlockSize > totalPageNum) ? totalPageNum : startPageNum+pageBlockSize-1;
			request.setAttribute("totalPageNum", totalPageNum);
			request.setAttribute("startPageNum", startPageNum);
			request.setAttribute("endPageNum", endPageNum);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("list",list);
			request.setAttribute("totalCnt",totalCnt);
			request.getRequestDispatcher("/WEB-INF/view/content/list.jsp");
		}
		else {
		Map<String,Object> map = bs.selectSearchList(currentPage,pageSize,searchWord);
		List<boardVo> list=(List<boardVo>)map.get("list");
		int totalCnt=(int)map.get("totalCnt");
		int totalPageNum = totalCnt/pageSize + (totalCnt%pageSize == 0 ? 0 : 1);
		int startPageNum = 1;
		if((currentPage%pageBlockSize) == 0) {
			startPageNum = ((currentPage/pageBlockSize)-1)*pageBlockSize +1;
		} else {
			startPageNum = ((currentPage/pageBlockSize))*pageBlockSize +1;
		}
		int endPageNum = (startPageNum+pageBlockSize > totalPageNum) ? totalPageNum : startPageNum+pageBlockSize-1;
		request.setAttribute("totalPageNum", totalPageNum);
		request.setAttribute("startPageNum", startPageNum);
		request.setAttribute("endPageNum", endPageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("list",list);
		request.setAttribute("searchWord", searchWord);
		request.setAttribute("totalCnt",totalCnt);
		request.getRequestDispatcher("/WEB-INF/view/content/list.jsp");
		}
	}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}
//}