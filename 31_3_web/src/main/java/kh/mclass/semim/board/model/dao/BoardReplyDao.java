package kh.mclass.semim.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.semim.board.model.dto.BoardReplyDto;

import static kh.mclass.jdbc.common.JdbcTemplate.*;

public class BoardReplyDao {
	// selectList - all
	public List<BoardReplyDto> selectAllList(Connection con) {
//		BOARD_REPLY_ID         NOT NULL NUMBER         
//		BOARD_ID               NOT NULL NUMBER         
//		BOARD_REPLY_WRITER     NOT NULL VARCHAR2(20)   
//		BOARD_REPLY_CONTENT    NOT NULL VARCHAR2(4000) 
//		BOARD_REPLY_WRITE_TIME NOT NULL TIMESTAMP(6)   
//		BOARD_REPLY_LOG_IP              VARCHAR2(15)   
//		BOARD_REPLY_LEVEL      NOT NULL NUMBER(2)      
//		BOARD_REPLY_REF        NOT NULL NUMBER         
//		BOARD_REPLY_STEP       NOT NULL NUMBER(3)
		List<BoardReplyDto> result = null;
		String sql = "SELECT BOARD_REPLY_ID, BOARD_ID, BOARD_REPLY_WRITER, BOARD_REPLY_CONTENT, BOARD_REPLY_WRITE_TIME, BOARD_REPLY_LOG_IP, BOARD_REPLY_LEVEL, BOARD_REPLY_REF, BOARD_REPLY_STEP FROM BOARD_REPLY";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// ResultSet 처리
			if(rs.next()) {
				result = new ArrayList<BoardReplyDto>();
				do {
					BoardReplyDto dto = new BoardReplyDto(
							rs.getInt("BOARD_REPLY_ID")
							, rs.getInt("BOARD_ID")
							, rs.getString("BOARD_REPLY_WRITER")
							, rs.getString("BOARD_REPLY_CONTENT")
							, rs.getString("BOARD_REPLY_WRITE_TIME")
							, rs.getString("BOARD_REPLY_LOG_IP")
							, rs.getInt("BOARD_REPLY_LEVEL")
							, rs.getInt("BOARD_REPLY_REF")
							, rs.getInt("BOARD_REPLY_STEP")
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
	public BoardReplyDto selectOne(Connection con, int boardReplyId) {
		BoardReplyDto result = null;
		String sql = "SELECT BOARD_REPLY_ID, BOARD_ID, BOARD_REPLY_WRITER, BOARD_REPLY_CONTENT, BOARD_REPLY_WRITE_TIME, BOARD_REPLY_LOG_IP, BOARD_REPLY_LEVEL, BOARD_REPLY_REF, BOARD_REPLY_STEP FROM BOARD_REPLY WHERE BOARD_REPLY_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			pstmt.setInt(1, boardReplyId);
			
			rs = pstmt.executeQuery();
			// ResultSet 처리
			if(rs.next()) {
				result = new BoardReplyDto(
						rs.getInt("BOARD_REPLY_ID")
						, rs.getInt("BOARD_ID")
						, rs.getString("BOARD_REPLY_WRITER")
						, rs.getString("BOARD_REPLY_CONTENT")
						, rs.getString("BOARD_REPLY_WRITE_TIME")
						, rs.getString("BOARD_REPLY_LOG_IP")
						, rs.getInt("BOARD_REPLY_LEVEL")
						, rs.getInt("BOARD_REPLY_REF")
						, rs.getInt("BOARD_REPLY_STEP")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return result;
	}
	
	// insert
	public int insert(Connection con, BoardReplyDto dto) {
		int result = -1;
//		INSERT INTO MEMBER VALUES('kh'||K, 'pwd'||K, 'kh'||K||'@a.com', '이름'||K);
		String sql = "INSERT INTO BOARD_REPLY (BOARD_REPLY_ID, BOARD_ID, BOARD_REPLY_WRITER, BOARD_REPLY_CONTENT, BOARD_REPLY_WRITE_TIME, BOARD_REPLY_LOG_IP, BOARD_REPLY_LEVEL, BOARD_REPLY_REF, BOARD_REPLY_STEP)"
				+ "VALUES(?, ?, ?, ?, DEFAULT, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
		return result;
	}
	
	// update
	public int update(Connection con, BoardReplyDto dto) {
		int result = -1;
		String sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ?, WRITE_TIME = DEFAULT, LOG_IP = ? WHERE BOARD_ID = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			
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
