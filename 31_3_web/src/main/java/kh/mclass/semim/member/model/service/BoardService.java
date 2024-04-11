package kh.mclass.semim.member.model.service;

import static kh.mclass.jdbc.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kh.mclass.semim.board.model.dao.BoardDao;
import kh.mclass.semim.board.model.dto.BoardDto;
import kh.mclass.semim.board.model.dto.BoardInsertDto;
import kh.mclass.semim.board.model.dto.BoardListDto;

public class BoardService {
	private BoardDao dao = new BoardDao();

//	// selectTotalCount - con 재연결 하지 않게
//	public int selectTotalCount() {
//		int result = 0;
//		Connection con = getConnectionSemi(true);
//		result = dao.selectTotalCount(con);
//		close(con);
//		return result;
//	}
	// selectList - page
	public Map<String, Object> selectPageList(int pageSize, int pageBlockSize, int currentPageNum) {
		Map<String, Object> result = null;
		Connection con = getConnectionSemi(true);
		
		int start = pageSize * (currentPageNum - 1) + 1;
		int end = pageSize * currentPageNum;
		
		
		// 총글수 100
		int totalCount = dao.selectTotalCount(con);
		
		// 전체 페이지 = ceil(총글수 / 페이지당글수)
		int totalPageCount = (totalCount % pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1;
		
		
		int startPageNum = (currentPageNum % pageBlockSize == 0) ? ((currentPageNum / pageBlockSize) - 1) * pageBlockSize + 1 : ((currentPageNum / pageBlockSize)) * pageBlockSize + 1; 
		int endPageNum = (startPageNum + pageBlockSize > totalPageCount) ? totalPageCount : startPageNum + pageBlockSize - 1;
		
		List<BoardListDto> dtolist = dao.selectPageList(con, start, end);
		close(con);
		
		result = new HashMap<String, Object>();
		result.put("dtolist", dtolist);
		result.put("totalPageCount", totalPageCount);
		result.put("startPageNum", startPageNum);
		result.put("endPageNum", endPageNum);
		result.put("currentPageNum", currentPageNum);
		
		System.out.println("selectPageList() : " + result);
		
		return result;
	}

	// selectList - all
	public List<BoardListDto> selectAllList() {
		List<BoardListDto> result = null;
		Connection con = getConnectionSemi(true);
		result = dao.selectAllList(con);
		close(con);
		return result;
	}

	// selectOne
	public BoardDto selectOne(int boardId) {
		BoardDto result = null;
		Connection con = getConnectionSemi(true);
		result = dao.selectOne(con, boardId);
		close(con);
		return result;
	}

	// insert
	public int insert(BoardInsertDto dto) {
		int result = -1;
		Connection con = getConnectionSemi(true);
		result = dao.insert(con, dto);
		close(con);
		return result;
	}

	// update
	public int update(BoardDto dto) {
		int result = -1;
		Connection con = getConnectionSemi(true);
		result = dao.update(con, dto);
		close(con);
		return result;
	}

	// delete
	public int delete(int boardId) {
		int result = 0;
		Connection con = getConnectionSemi(true);
		result = dao.delete(con, boardId);
		close(con);
		return result;
	}
}
