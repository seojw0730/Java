package kh.mclass.jdbc.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.mclass.jdbc.model.service.DeptService;
import kh.mclass.jdbc.model.vo.Dept;

/**
 * Servlet implementation class DeptInsertController
 */
@WebServlet("/dept/insert")
public class DeptInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeptInsertController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("=====req.getParameterNames()====="); // ex) 카테고리별 검색 잡코리아 경력/지역/연봉/알바...
		Enumeration<String> enumNames = req.getParameterNames();
		System.out.println(enumNames);
		while (enumNames.hasMoreElements()) {
			String name = enumNames.nextElement();
			System.out.println(req.getParameter(name));
		}
		System.out.println("=====req.getParameterValues()====="); // ex) 레시피 재료들... 선호 장르 선택
		// ?genre=g1&genre=g2&genre=g3
		String[] genreArr = req.getParameterValues("genre");
		List<String> genreList = Arrays.asList(genreArr);
		System.out.println(genreList);

		System.out.println("=====req.getParameterMap()====="); // Arrays.asList()함께 - 레시피 재료들... 선호 장르 선택
		Map<String, String[]> paramMap = req.getParameterMap();
		System.out.println(paramMap);
		Set<String> keySet = paramMap.keySet();
		for (String key : keySet) {
			String[] valueArr = paramMap.get(key);
			List<String> valueList = Arrays.asList(valueArr);
			System.out.println(key + ": " + valueList);
		}

		// ?no=60&dname=60&loc=seoul
		// 5. 데이터 수신
		String noStr = req.getParameter("no");
		String dname = req.getParameter("dname");
		String loc = req.getParameter("loc");
		int deptno = Integer.parseInt(noStr);
		Dept vo = new Dept(deptno, dname, loc);
		DeptService service = new DeptService();
		int result = service.insert(vo);

		if (result > 0) {
			res.sendRedirect(req.getContextPath() + "/deptlist");
//			List<Dept> volist = service.selectList();
//			req.setAttribute("volist", volist);
//			req.setAttribute("data2", "컨트롤러");
//			req.getRequestDispatcher("/views/deptlist.jsp").forward(req, res);
		} else {
			req.setAttribute("msg", "부서를 추가하지 못했습니다.");
			req.getRequestDispatcher("/views/errorPage.jsp").forward(req, res);
		}
		System.out.println("result: " + result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, response);
	}

}
