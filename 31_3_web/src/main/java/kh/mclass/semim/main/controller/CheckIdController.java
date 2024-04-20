package kh.mclass.semim.main.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kh.mclass.semim.board.model.service.MemberService;
import kh.mclass.semim.member.model.dto.MemberDto;

/**
 * Servlet implementation class CheckIdController
 */
@WebServlet("/checkid.ajax")
public class CheckIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckIdController() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/checkid doPost 진입");
		String k1 = request.getParameter("k1");
		String k2 = request.getParameter("k2");
		System.out.println(k1 + ", " + k2);
		
		String memId = request.getParameter("id");
		System.out.println(memId);
		// TODO DB 갔다올 예정
		int result = new MemberService().selectCheckId(memId);
		response.getWriter().append(String.valueOf(result));
		
		// ajax로 왔다면
		// dispatcher, sendRedirect 로 다른 페이지로 이동하면 안됨!!!
		// 왔던 곳 success / error 의 callback 으로 돌아가야 함
		
		
		// Map, Student 등 참조형 객체는 jsp에서 인식 못함
		// json 이 중간 역할
//		Map<String, Object> map;
		
//		List<MemberDto> result = new MemberService().selectAllList();
//		System.out.println(result);
//		Gson gson = new Gson();
//		String jsonResult = gson.toJson(result);
//		System.out.println(jsonResult);
//		response.getWriter().append(jsonResult);
	}

}
