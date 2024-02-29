package kh.mclass.jdbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.jdbc.model.service.DeptService;
import kh.mclass.jdbc.model.vo.Dept;

/**
 * Servlet implementation class DeptDeleteController
 */
@WebServlet("/dept/delete")
public class DeptDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptDeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ?no=52&a=10&b=안녕
		// ?no=61%dname=a%loc=seoul
		String noStr = req.getParameter("no");
		String a = req.getParameter("a");
		String b = req.getParameter("b");
		System.out.println("no: " + noStr);
		System.out.println("a: " + a);
		System.out.println("b: " + b);
		int deptno = Integer.parseInt(noStr);
		DeptService service = new DeptService();
		int result = service.delete(deptno);

		if (result > 0) {
			// DeptController - doGet() 호출
			// 4. url 페이지 이동 /deptlist 이동.
			res.sendRedirect(req.getContextPath() + "/deptlist");
//			List<Dept> volist = service.selectList();
//			req.setAttribute("volist", volist);
//			req.getRequestDispatcher("/views/deptlist.jsp").forward(req, res);
		} else {
			req.setAttribute("msg", "해당하는 부서가 없어 삭제하지 못했습니다.");
			req.getRequestDispatcher("/views/errorPage.jsp").forward(req, res);
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
