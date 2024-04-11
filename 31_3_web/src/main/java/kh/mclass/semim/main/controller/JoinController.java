package kh.mclass.semim.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.semim.board.model.service.MemberService;
import kh.mclass.semim.member.model.dto.MemberDto;

/**
 * Servlet implementation class JoinController
 */
@WebServlet("/join")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/semi/join.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memId = request.getParameter("id");
		String memPwd = request.getParameter("pwd");
		String memEmail = request.getParameter("email");
		String memName = request.getParameter("name");
		MemberDto dto = new MemberDto(memId, memPwd, memEmail, memName);
		int result = new MemberService().insert(dto);
		if(result < 0) {
			// 회원가입 실패 시
			response.sendRedirect(request.getContextPath()+"/main");
			return;
		}
		// 회원가입 성공 시
		response.sendRedirect(request.getContextPath()+"/login");
	}

}
