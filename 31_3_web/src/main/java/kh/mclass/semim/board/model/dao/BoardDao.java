package kh.mclass.semim.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.semim.board.model.dto.BoardDto;
import kh.mclass.semim.board.model.dto.BoardInsertDto;
import kh.mclass.semim.board.model.dto.BoardListDto;

import static kh.mclass.jdbc.common.JdbcTemplate.*;

public class BoardDao {
	// selectTotalCount
	public int selectTotalCount(Connection con) {
		int result = -1;
		String sql = "SELECT COUNT(*) CNT FROM BOARD";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// ResultSet 처리
			if(rs.next()) {
				result = rs.getInt("CNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return result;
	}
	
	// selectPageList
	public List<BoardListDto> selectPageList(Connection con, int start, int end) {
		List<BoardListDto> result = null;
		String sql = "SELECT T2.*"
				+ " FROM (SELECT T1.*, ROWNUM RN FROM (SELECT BOARD_ID, TITLE, CONTENT, WRITE_TIME, BOARD_WRITER, LOG_IP, READ_COUNT FROM BOARD ORDER BY BOARD_ID DESC) T1) T2"
				+ " WHERE RN BETWEEN ? AND ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
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
	
	// selectList - all
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
	public BoardDto selectOne(Connection con, int boardId) {
		BoardDto result = null;
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
				result = new BoardDto(
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
	
	// insert
	public int insert(Connection con, BoardInsertDto dto) {
		int result = -1;
//		INSERT INTO MEMBER VALUES('kh'||K, 'pwd'||K, 'kh'||K||'@a.com', '이름'||K);
		String sql = "INSERT INTO BOARD (BOARD_ID, TITLE, CONTENT, WRITE_TIME, BOARD_WRITER, LOG_IP, READ_COUNT) VALUES(SEQ_BOARD_ID.NEXTVAL, ?, ?, DEFAULT, ?, 'localhost', 0)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getBoardWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
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
