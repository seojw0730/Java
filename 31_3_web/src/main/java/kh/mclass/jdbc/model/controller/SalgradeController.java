package kh.mclass.jdbc.model.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.jdbc.model.service.SalgradeService;
import kh.mclass.jdbc.model.vo.Salgrade;

/**
 * Servlet implementation class SalgradeController
 */
@WebServlet("/sallist")
public class SalgradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SalgradeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SalgradeService service = new SalgradeService();
		List<Salgrade> volist = service.selectList();
		request.setAttribute("volist", volist);
		
		if(volist==null) {
			request.setAttribute("msg", "데이터 오류로 등급 조회 실패");
			request.getRequestDispatcher("/views/errorPage.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/views/sallist.jsp").forward(request, response);
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
