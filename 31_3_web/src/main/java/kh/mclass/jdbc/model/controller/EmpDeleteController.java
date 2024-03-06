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
 * Servlet implementation class EmpDeleteController
 */
@WebServlet("/emp/delete")
public class EmpDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empnoStr = request.getParameter("empno");
		int empno = Integer.parseInt(empnoStr);
		
		EmpService service = new EmpService();
		int result = service.delete(empno);
		
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/emplist");
		}else {
			request.setAttribute("msg", "사원 삭제 실패");
			request.getRequestDispatcher("/views/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
