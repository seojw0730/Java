package kh.mclass.jdbc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.jdbc.model.service.SalgradeService;

/**
 * Servlet implementation class SalgradeDeleteController
 */
@WebServlet("/sal/delete")
public class SalgradeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalgradeDeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String gradeStr = req.getParameter("grade");
		int grade = Integer.parseInt(gradeStr);
		SalgradeService service = new SalgradeService();
		int result = service.delete(grade);

		if (result > 0) {
			res.sendRedirect(req.getContextPath() + "/sallist");
		} else {
			req.setAttribute("msg", "등급 삭제 실패");
			req.getRequestDispatcher("/views/errorPage.jsp").forward(req, res);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
