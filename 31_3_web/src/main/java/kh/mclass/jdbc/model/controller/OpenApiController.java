//package kh.mclass.jdbc.model.controller;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import kh.mclass.jdbc.model.service.OpenApiService;
//import kh.mclass.jdbc.model.vo.OpenApiVo;
//
///**
// * Servlet implementation class OpenApiController
// */
//@WebServlet("/openapi")
//public class OpenApiController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public OpenApiController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		OpenApiService service = new OpenApiService();
////		List<OpenApiVo> result = service.getCtprvnRltmMesureDnsty();
//		Map<String, Object> result = (Map<String, Object>) service.getCtprvnRltmMesureDnstyByJson();
//		System.out.println(result);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
