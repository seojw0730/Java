package kh.mclass.semim.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kh.mclass.semim.board.model.dto.BoardInsertDto;
import kh.mclass.semim.board.model.dto.FileWriteDto;
import kh.mclass.semim.member.model.dto.MemberInfoDto;
import kh.mclass.semim.member.model.service.BoardService;

/**
 * Servlet implementation class BoardListController
 */
@WebServlet("/board/write")
public class BoardWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BoardService service = new BoardService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prePage = (String) request.getSession().getAttribute("prePage");
		if(prePage != null && prePage.equals("write")) {
			request.getSession().removeAttribute("prePage");
		}
		request.getRequestDispatcher("/WEB-INF/views/semi/board/write.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/board/write doPost()");
		
		String uploadPath = req.getServletContext().getRealPath("/resources/uploadfile");
		System.out.println("uploadPath : " + uploadPath);
		File uploadPathFile = new File(uploadPath);
		if(!uploadPathFile.exists()) {
			uploadPathFile.mkdirs();
		}
		int uploadFileLimit = 10 * 1024 * 1024; // 10MB 제한
		// form enctype="multipart/form-data" 형태로 전달된 경우
		MultipartRequest multiReq = new MultipartRequest(req // jsp -> controller 전달된 객체
				, uploadPath // WAS 서버에 저장할 디렉토리
				, uploadFileLimit // 업로드 파일 크기 제한
				, "UTF-8" // 인코딩 방법
				, new DefaultFileRenamePolicy() // WAS 서버에 저장할 디렉토리에 동일명 존재 시 새로운 이름 부여방식
				);
		// 중요!! 이 시점에 new MultipartRequest() 하면 file 은 uploadPath 에 저장완료
		
		
//		// JSP -> Controller File 1개인 경우
//		String filePath = multiReq.getFilesystemName("uploadfiles");
//		if(filePath == null) {
//			System.out.println("첨부파일X");
//		}else {
//			System.out.println("첨부파일 정보는");
//			System.out.println(filePath);
//			System.out.println(multiReq.getOriginalFileName(filePath));
//		}
		// JSP -> Controller File 0개 이상인 경우
		List<FileWriteDto> filelist = new ArrayList<FileWriteDto>();
		Enumeration<?> fileNames = multiReq.getFileNames(); // enumeration 은 list 랑 같은 계열 iterator 와 같은 개념
		while(fileNames.hasMoreElements()) {
			String name = (String)fileNames.nextElement(); // input type="file" name="xxx" , xxx_0, xxx_1
			String fileName = multiReq.getFilesystemName(name); // WAS 에 저장된 이름
			String originalName = multiReq.getOriginalFileName(name);
			String type = multiReq.getContentType(name);
			File f1 = multiReq.getFile(name);
			if(f1 == null) {
				System.out.println("업로드 실패");
			}else {
				System.out.println(f1.length());
			}
			System.out.println(name + "\t" + fileName + "\t" + originalName + "\t" + type);
			// 파일 경로는 통일시켜야함
			FileWriteDto filedto = new FileWriteDto(fileName, originalName);
			filelist.add(filedto);
		}
		
		
		
		
		
		String title = multiReq.getParameter("title");
		String content = multiReq.getParameter("content");
		System.out.println(title);
		System.out.println(content);
		MemberInfoDto memberInfoDto = (MemberInfoDto) req.getSession().getAttribute("ssLogin");
		String boardWriter = memberInfoDto.getMemId();
		BoardInsertDto dto = new BoardInsertDto(title, content, boardWriter, filelist);
		int result = service.insert(dto);
		resp.sendRedirect(req.getContextPath() + "/board/list");
	}
}
