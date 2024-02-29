package kh.mclass.jdbc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.jdbc.model.service.SalgradeService;
import kh.mclass.jdbc.model.vo.Salgrade;

/**
 * Servlet implementation class SalgradeInsertController
 */
@WebServlet("/sal/insert")
public class SalgradeInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SalgradeInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String salStr = req.getParameter("sal");
		String loStr = req.getParameter("lo");
		String hiStr = req.getParameter("hi");
		int grade = Integer.parseInt(salStr);
		int losal = Integer.parseInt(loStr);
		int hisal = Integer.parseInt(hiStr);
		Salgrade vo = new Salgrade(grade, losal, hisal);
		SalgradeService service = new SalgradeService();
		int result = service.insert(vo);

		if (result > 0) {
			res.sendRedirect(req.getContextPath() + "/sallist");
		} else {
			req.setAttribute("msg", "등급 추가 실패ㅐㅐ");
			req.getRequestDispatcher("/views/errorPage.jsp").forward(req, res);
		}
		System.out.println("result: " + result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}

}
