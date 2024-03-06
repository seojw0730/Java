package kh.mclass.jdbc.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.jdbc.model.service.DeptService;
import kh.mclass.jdbc.model.vo.Dept;

/**
 * Servlet implementation class DeptSelectOneController
 */
@WebServlet("/dept/select1")
public class DeptSelectOneController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptSelectOneController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptnoStr = request.getParameter("deptno");
		int deptno = Integer.parseInt(deptnoStr);
		DeptService service = new DeptService();
		Dept vo = service.selectOne(deptno);
		request.setAttribute("vo", vo);
		if (vo == null) {
			request.setAttribute("msg", "시스템 오류로 데이터 읽기 실패");
			request.getRequestDispatcher("/views/errorPage.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/views/deptlist1.jsp").forward(request, response);
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
