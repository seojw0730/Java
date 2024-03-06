package kh.mclass.jdbc.model.controller;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gradeStr = request.getParameter("grade");
		int grade = Integer.parseInt(gradeStr);
		String losalStr = request.getParameter("losal");
		int losal = Integer.parseInt(losalStr);
		String hisalStr = request.getParameter("hisal");
		int hisal = Integer.parseInt(hisalStr);
		
		Salgrade vo = new Salgrade(grade, losal, hisal);
		SalgradeService service = new SalgradeService();
		int result = service.insert(vo);
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/sallist");
		}else {
			request.setAttribute("msg", "등급 추가 실패");
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
