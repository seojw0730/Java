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
 * Servlet implementation class EmpInsertController
 */
@WebServlet("/emp/insert")
public class EmpInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpInsertController() {
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
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		String mgrStr = request.getParameter("mgr");
		int mgr = Integer.parseInt(mgrStr);
		String salStr = request.getParameter("sal");
		double sal = Double.parseDouble(salStr);
		String commStr = request.getParameter("comm");
		double comm = Double.parseDouble(commStr);
		String deptnoStr = request.getParameter("deptno");
		int deptno = Integer.parseInt(deptnoStr);
		Emp vo = new Emp(empno, ename, job, mgr, null, sal, comm, deptno);
		EmpService service = new EmpService();
		int result = service.insert(vo);

		if (result > 0) {
			response.sendRedirect(request.getContextPath() + "/emplist");
		} else {
			request.setAttribute("msg", "사원 추가 실패");
			request.getRequestDispatcher("/views/errorPage.jsp").forward(request, response);
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
