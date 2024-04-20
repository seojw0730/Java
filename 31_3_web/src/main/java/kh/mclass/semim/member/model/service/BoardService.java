package kh.mclass.semim.member.model.service;

import static kh.mclass.jdbc.common.JdbcTemplate.*;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kh.mclass.mybatis.common.MybatisTemplate;
import kh.mclass.semim.board.model.dao.BoardDao;
import kh.mclass.semim.board.model.dto.BoardDto;
import kh.mclass.semim.board.model.dto.BoardInsertDto;
import kh.mclass.semim.board.model.dto.BoardListDto;
import kh.mclass.semim.board.model.dto.BoardReadDto;
import kh.mclass.semim.board.model.dto.BoardReplyListDto;
import kh.mclass.semim.board.model.dto.BoardReplyWriteDto;
import kh.mclass.semim.board.model.dto.FileReadDto;

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
	public Map<String, Object> selectPageListMybatis(int pageSize, int currentPageNum) {
		Map<String, Object> result = null;
		SqlSession session = MybatisTemplate.getSqlSession(true);
		
		List<BoardListDto> boardList = dao.selectPageListMybatis(session, pageSize, currentPageNum);
		
		return result;
	}
	// selectList - page
//	public Map<String, Object> selectPageList(int pageSize, int pageBlockSize, int currentPageNum) {
//		Map<String, Object> result = null;
//		Connection con = getConnectionSemi(true);
//
//		int start = pageSize * (currentPageNum - 1) + 1;
//		int end = pageSize * currentPageNum;
//
//		// 총글수 100
//		int totalCount = dao.selectTotalCount(con);
//
//		// 전체 페이지 = ceil(총글수 / 페이지당글수)
//		int totalPageCount = (totalCount % pageSize == 0) ? totalCount / pageSize : totalCount / pageSize + 1;
//
//		int startPageNum = (currentPageNum % pageBlockSize == 0)
//				? ((currentPageNum / pageBlockSize) - 1) * pageBlockSize + 1
//				: ((currentPageNum / pageBlockSize)) * pageBlockSize + 1;
//		int endPageNum = (startPageNum + pageBlockSize > totalPageCount) ? totalPageCount
//				: startPageNum + pageBlockSize - 1;
//
//		List<BoardListDto> dtolist = dao.selectPageList(con, start, end);
//		close(con);
//
//		result = new HashMap<String, Object>();
//		result.put("dtolist", dtolist);
//		result.put("totalPageCount", totalPageCount);
//		result.put("startPageNum", startPageNum);
//		result.put("endPageNum", endPageNum);
//		result.put("currentPageNum", currentPageNum);
//
//		System.out.println("selectPageList() : " + result);
//
//		return result;
//	}

	// selectList - board reply
	public List<BoardReplyListDto> selectBoardReplyList(int boardId) {
		List<BoardReplyListDto> result = null;
//		Connection con = getConnectionSemi(true);
		SqlSession session = MybatisTemplate.getSqlSession(true);
		result = dao.selectBoardReplyList(session, boardId);
		session.close();
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

	// select one
	public BoardReadDto selectOne(Integer boardId) {
		BoardReadDto result = null;
		Connection con = getConnectionSemi(true);
		result = dao.selectOne(con, boardId);
		if (result != null) {
			dao.updateReadCount(con, boardId);
		}
		List<FileReadDto> filelist = dao.selectFileList(con, boardId);

		// ajax로 대체
//		List<BoardReplyListDto> replylist = dao.selectBoardReplyList(con, boardId);
//		result.setReplydtolist(replylist);
		close(con);
		return result;
	}

	// insert - boardreply
	public int insertReply(BoardReplyWriteDto dto) {
		int result = 0;
		int resultUpdate = 0;
		Connection con = getConnectionSemi(true);
		autoCommit(con, false);
		if (dto.getBoardReplyId() != 0) {
			resultUpdate = dao.updateReplyStep(con, dto.getBoardReplyId());
			if (resultUpdate > -1) {
				result = dao.insertRReply(con, dto);
			}
		} else {
			result = dao.insertReply(con, dto);
		}
		if (resultUpdate > -1 && result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	// insert
	public int insert(BoardInsertDto dto) {
		int result = 0;
//		Connection con = getConnectionSemi(true);
//		int sequenceNum = dao.getSequenceNum(con);
		SqlSession session = MybatisTemplate.getSqlSession(true);
		if (dto.getFilelist() != null && dto.getFilelist().size() > 0) {
			result = dao.insert(session, dto);
		}
		session.close();
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
