package kh.mclass.semim.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.semim.member.model.service.BoardService;

/**
 * Servlet implementation class BoardReadController
 */
@WebServlet("/board/read")
public class BoardReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardReadController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardIdStr = request.getParameter("id");
		Integer boardId = Integer.parseInt(boardIdStr);
		request.setAttribute("dto", service.selectOne(boardId));
		request.getRequestDispatcher("/WEB-INF/views/semi/board/read.jsp").forward(request, response);
		try {
		} catch (NumberFormatException e) {
			System.out.println("!!!!!!!!!!!!!");
			response.sendRedirect(request.getContextPath() + "board/list");
		}
		
	}

}
