package kh.mclass.semim.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kh.mclass.semim.board.model.dto.BoardDto;
import kh.mclass.semim.board.model.dto.BoardInsertDto;
import kh.mclass.semim.board.model.dto.BoardListDto;
import kh.mclass.semim.board.model.dto.BoardReadDto;
import kh.mclass.semim.board.model.dto.BoardReplyListDto;
import kh.mclass.semim.board.model.dto.BoardReplyWriteDto;
import kh.mclass.semim.board.model.dto.FileReadDto;
import kh.mclass.semim.board.model.dto.FileWriteDto;

import static kh.mclass.jdbc.common.JdbcTemplate.*;

public class BoardDao {
//	BOARD_REPLY_ID         NOT NULL NUMBER         
//	BOARD_ID               NOT NULL NUMBER         
//	BOARD_REPLY_WRITER     NOT NULL VARCHAR2(20)   
//	BOARD_REPLY_CONTENT    NOT NULL VARCHAR2(4000) 
//	BOARD_REPLY_WRITE_TIME NOT NULL TIMESTAMP(6)   
//	BOARD_REPLY_LOG_IP              VARCHAR2(15)   
//	BOARD_REPLY_LEVEL      NOT NULL NUMBER(2)      
//	BOARD_REPLY_REF        NOT NULL NUMBER         
//	BOARD_REPLY_STEP       NOT NULL NUMBER(3)
	
	// select list - all
	public List<FileReadDto> selectFileList(Connection con, Integer boardId) {
		List<FileReadDto> result = null;
		String sql = "SELECT BOARD_ID, BOARD_FILE_ID, SAVED_FILE_PATH_NAME, ORIGINAL_FILENAME FROM BOARD_FILE WHERE BOARD_ID = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			
			// ResultSet 처리
			if(rs.next()) {
				result = new ArrayList<FileReadDto>();
				do {
					FileReadDto dto = new FileReadDto(
							rs.getInt("BOARD_ID")
							, rs.getInt("BOARD_FILE_ID")
							, rs.getString("SAVED_FILE_PATH_NAME")
							, rs.getString("ORIGINAL_FILENAME")
							);
					result.add(dto);
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return result;
	}
	
	// selectList - board reply : board_id
		public List<BoardReplyListDto> selectBoardReplyList(SqlSession session, Integer boardId) {
			return session.selectList("boardns.selectBoardReplyList", boardId);
		}
	
	// selectTotalCount
	public Integer selectTotalCount(SqlSession session) {
		return session.selectOne("boardns.selectTotalCount");
	}
	
	// selectPageList
	public List<BoardListDto> selectPageListMybatis(SqlSession session, int pageSize, int currentPageNum) {
		List<BoardListDto> result = null;
		int offset = (currentPageNum - 1) * pageSize;
		RowBounds rbounds = new RowBounds(offset, pageSize);
		result = session.selectList("boardns.selectPageList", null, rbounds);
		
		return result;
	}
	
	// selectList - board reply
	public List<BoardListDto> selectBoardReplyList(Connection con) {
		List<BoardListDto> result = null;
		String sql = "SELECT BOARD_ID, TITLE, WRITE_TIME, BOARD_WRITER, READ_COUNT FROM BOARD "
				+ " WHERE BOARD_ID = ? "
				+ " ORDER BY BOARD_ID DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// ResultSet 처리
			if(rs.next()) {
				result = new ArrayList<BoardListDto>();
				do {
					BoardListDto dto = new BoardListDto(
							rs.getInt("BOARD_ID")
							, rs.getString("TITLE")
							, rs.getString("WRITE_TIME")
							, rs.getString("BOARD_WRITER")
							, rs.getInt("READ_COUNT")
							);
					result.add(dto);
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return result;
	}
	
	// select list - all
	public List<BoardListDto> selectAllList(Connection con) {
		List<BoardListDto> result = null;
		String sql = "SELECT BOARD_ID, TITLE, WRITE_TIME, BOARD_WRITER, READ_COUNT FROM BOARD "
				+ ""
				+ ""
				+ ""
				+ "ORDER BY BOARD_ID DESC";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// ResultSet 처리
			if(rs.next()) {
				result = new ArrayList<BoardListDto>();
				do {
					BoardListDto dto = new BoardListDto(
							rs.getInt("BOARD_ID")
							, rs.getString("TITLE")
							, rs.getString("WRITE_TIME")
							, rs.getString("BOARD_WRITER")
							, rs.getInt("READ_COUNT")
							);
					result.add(dto);
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return result;
	}
	
	// selectOne
	public BoardReadDto selectOne(Connection con, Integer boardId) {
		BoardReadDto result = null;
		String sql = "SELECT BOARD_ID, TITLE, CONTENT, WRITE_TIME, BOARD_WRITER, LOG_IP, READ_COUNT FROM BOARD WHERE BOARD_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			pstmt.setInt(1, boardId);
			
			rs = pstmt.executeQuery();
			// ResultSet 처리
			if(rs.next()) {
				result = new BoardReadDto(
						rs.getInt("BOARD_ID")
						, rs.getString("TITLE")
						, rs.getString("CONTENT")
						, rs.getString("WRITE_TIME")
						, rs.getString("BOARD_WRITER")
						, rs.getString("LOG_IP")
						, rs.getInt("READ_COUNT")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return result;
	}
	
	// select 
		public int getSequenceNum(Connection con) {
			int result = 0;
			String sql = "SELECT SEQ_BOARD_ID.nextval FROM DUAL";
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				pstmt = con.prepareStatement(sql);
				// ? 처리
				rs = pstmt.executeQuery();
				// ResetSet처리
				if(rs.next()) {
					result = rs.getInt(1);
				}			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			close(rs);
			close(pstmt);
			return result;
		}
	
	// insert - reply 대댓글~
	public int insertRReply(Connection con, BoardReplyWriteDto dto) {
		int result = 0; // 1 정상, 0 비정상
//		INSERT INTO MEMBER VALUES('kh'||K, 'pwd'||K, 'kh'||K||'@a.com', '이름'||K);
		String sql = "INSERT INTO BOARD_REPLY VALUES ( (SELECT NVL(MAX(BOARD_REPLY_ID),0)+1 FROM BOARD_REPLY), ?,"
				+ "            ?, ? , DEFAULT , NULL, "
				+ "            (SELECT BOARD_REPLY_LEVEL+1 FROM BOARD_REPLY WHERE BOARD_REPLY_ID = ? )  , "
				+ "            (SELECT BOARD_REPLY_REF     FROM BOARD_REPLY WHERE BOARD_REPLY_ID = ? )  , "
				+ "            (SELECT BOARD_REPLY_STEP+1  FROM BOARD_REPLY WHERE BOARD_REPLY_ID = ? )  )";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			pstmt.setInt(1, dto.getBoardId());
			pstmt.setString(2, dto.getBoardReplyWriter());
			pstmt.setString(3, dto.getBoardReplyContent());
			pstmt.setInt(4, dto.getBoardReplyId());
			pstmt.setInt(5, dto.getBoardReplyId());
			pstmt.setInt(6, dto.getBoardReplyId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
		return result;
	}
	
	// insert - reply 댓글
	public int insertReply(Connection con, BoardReplyWriteDto dto) {
		int result = 0; // 1 정상, 0 비정상
//		INSERT INTO MEMBER VALUES('kh'||K, 'pwd'||K, 'kh'||K||'@a.com', '이름'||K);
		String sql = "INSERT INTO BOARD_REPLY VALUES "
				+ "        ( (SELECT NVL(MAX(BOARD_REPLY_ID),0)+1 FROM BOARD_REPLY) , ?, "
				+ "            ?, ? , default , null, "
				+ "            DEFAULT , (SELECT NVL(MAX(BOARD_REPLY_ID),0)+1 FROM BOARD_REPLY), DEFAULT )";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			pstmt.setInt(1, dto.getBoardId());
			pstmt.setString(2, dto.getBoardReplyWriter());
			pstmt.setString(3, dto.getBoardReplyContent());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
		return result;
	}
	
	// insert
	public int insert(SqlSession session, BoardInsertDto dto) {
		return session.insert("memberMapper.insert", dto);
	}
	
	// update - reply step
	public int updateReplyStep(Connection con, Integer boardReplyId) {
		int result = -1; // 0~n 정상 --> -1 비정상
		String sql = " UPDATE BOARD_REPLY SET BOARD_REPLY_STEP = BOARD_REPLY_STEP+1  WHERE "
				+ "            BOARD_REPLY_REF = ( SELECT BOARD_REPLY_REF FROM BOARD_REPLY WHERE BOARD_REPLY_ID = ?)"
				+ "            AND "
				+ "            BOARD_REPLY_STEP > ( SELECT BOARD_REPLY_STEP FROM BOARD_REPLY WHERE BOARD_REPLY_ID = ? )";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardReplyId);
			pstmt.setInt(2, boardReplyId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
		return result;
	}
	
	// update - readCount
	public int updateReadCount(Connection con, Integer boardId) {
		int result = 0;
		String sql = "UPDATE BOARD SET READ_COUNT = READ_COUNT + 1 WHERE BOARD_ID = ?"; // TODO
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, boardId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
		System.out.println("boardDao updateReadCount() return : " + result);
		return result;
	}
	
	// update
	public int update(Connection con, BoardDto dto) {
		int result = -1;
		String sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WRITE_TIME = DEFAULT, LOG_IP = ? WHERE BOARD_ID = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getLogIp());
			pstmt.setInt(4, dto.getBoardId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
		return result;
	}
	
	// delete
	public int delete(Connection con, int boardId) {
		int result = 0;
		String sql = "DELETE FROM BOARD WHERE BOARD_ID = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			pstmt.setInt(1, boardId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
		return result;
	}
}
