package kh.mclass.semim.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.semim.board.model.dto.BoardDto;
import kh.mclass.semim.member.model.service.BoardService;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/board/list")
public class BoardListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한페이지당글수 3씩
		int pageSize = 3;
		// 화면 하단 페이지수 5씩
		int pageBlockSize = 5;
		// 현재페이지
		int currentPageNum = 1; // 기본 1
		// 페이지 지정하고 들어오면 현재페이지 바꿔줌
		String pageNum = request.getParameter("page");
		if(pageNum != null && !pageNum.equals("")) {
			try {
				currentPageNum = Integer.parseInt(pageNum);
			} catch (NumberFormatException e) {
				System.out.println("!!!!!!!!!!!numberformatexception!!!!!!!!!!!");
				e.printStackTrace();
			}
		}
		
		request.setAttribute("map", service.selectPageList(pageSize, pageBlockSize, currentPageNum));
//		request.setAttribute("dtolist", service.selectAllList());
		request.getRequestDispatcher("/WEB-INF/views/semi/board/list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
