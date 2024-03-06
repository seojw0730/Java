package kh.mclass.jdbc.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.jdbc.model.service.EmpService;
import kh.mclass.jdbc.model.vo.Emp;

/**
 * Servlet implementation class EmpSelectOneController
 */
@WebServlet("/emp/select1")
public class EmpSelectOneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpSelectOneController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empnoStr = request.getParameter("empno");
		int empno = Integer.parseInt(empnoStr);
		EmpService service = new EmpService();
		Emp vo = service.selectOne(empno);
		request.setAttribute("vo", vo);
		if (vo == null) {
			request.setAttribute("msg", "시스템 오류로 데이터 읽기 실패");
			request.getRequestDispatcher("/views/errorPage.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/emplist1.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
