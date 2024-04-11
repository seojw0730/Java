package kh.mclass.semim.main.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.semim.board.model.service.MemberService;
import kh.mclass.semim.member.model.dto.MemberInfoDto;
import kh.mclass.semim.member.model.dto.MemberLoginDto;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prePage = request.getParameter("prePage");
		request.getSession().setAttribute("prePage", prePage);
		
		request.getRequestDispatcher("/WEB-INF/views/semi/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		MemberLoginDto dto = new MemberLoginDto(id, pwd);
		System.out.println("/login doPost : " + dto);
//		/login doPost : MemberLoginDto [memId=aaa, memPwd=aaa]
		// TODO login
		
		// ajax
		// 성공 : 1
		// 실패 : 0
		// int result = new MemberService().login(dto);
		int result = 0;
		if(service.selectInfoLogin(dto) != null) {
			// 성공
//			request.getSession().setAttribute("ssLogin", id);
			result = 1;
			request.getSession().setAttribute("ssLogin", service.selectInfoLogin(dto));
		}
		response.getWriter().append(String.valueOf(result));
	}

}
