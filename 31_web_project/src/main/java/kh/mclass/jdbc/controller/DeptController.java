package kh.mclass.jdbc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException; // javax --> apache-tomcat 에 지원 
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.jdbc.model.service.DeptService;
import kh.mclass.jdbc.model.vo.Dept;
/**
 * Servlet implementation class DeptController
 */
@WebServlet("/deptlist") // Annotation, @WebServlet("/url명")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨짐 방지
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		// Controller 역할
		// 2. Service - Dao 호출
		DeptService service = new DeptService();
		List<Dept> result = service.selectList();
		// 3. view 에 데이터 전달
		response.getWriter().append("DeptList");
		request.setAttribute("data1", result);
		request.setAttribute("data2", "컨트롤러에 usp-view로 값 전달");
		request.setAttribute("data3", 300);
		// 1. view 선택
		request.getRequestDispatcher("/views/deptlist.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
