package kh.mclass.semim.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import static kh.mclass.jdbc.common.JdbcTemplate.*;
import kh.mclass.semim.member.model.dto.MemberDto;
import kh.mclass.semim.member.model.dto.MemberInfoDto;
import kh.mclass.semim.member.model.dto.MemberLoginDto;

public class MemberDao {
	// selectInfologin
	public MemberInfoDto selectInfoLogin(Connection con, MemberLoginDto dto) {
		MemberInfoDto result = null;
		String sql = "SELECT MEM_ID, MEM_EMAIL, MEM_NAME FROM MEMBER WHERE MEM_ID = ? AND MEM_PWD = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPwd());
			
			rs = pstmt.executeQuery();
			// ResultSet 처리
			if(rs.next()) {
				result = new MemberInfoDto(rs.getString("MEM_ID"), rs.getString("MEM_EMAIL"), rs.getString("MEM_NAME"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return result;
	}
	
	// selectOne - login
	public int selectLogin(Connection con, MemberDto dto) {
		int result = -1;
		String sql = "SELECT COUNT(*) C FROM MEMBER WHERE MEM_ID = ?, MEM_PWD = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPwd());
			
			rs = pstmt.executeQuery();
			// ResultSet 처리
			if(rs.next()) {
				result = rs.getInt("C");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return result;
	}
	
	// selectOne - checkId
	public int selectCheckId(Connection con, String memId) {
		int result = -1;
		String sql = "SELECT COUNT(*) C FROM MEMBER WHERE MEM_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			// ResultSet 처리
			if(rs.next()) {
				result = rs.getInt("C");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(rs);
		close(pstmt);
		return result;
	}
	
	// selectList - all
	public List<MemberDto> selectAllList(Connection con) {
		List<MemberDto> result = null;
		String sql = "SELECT MEM_ID, MEM_PWD, MEM_EMAIL, MEM_NAME FROM MEMBER";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// ResultSet 처리
			if(rs.next()) {
				result = new ArrayList<MemberDto>();
				do {
					MemberDto dto = new MemberDto(
							rs.getString("MEM_ID")
							, rs.getString("MEM_PWD")
							, rs.getString("MEM_EMAIL")
							, rs.getString("MEM_NAME")
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
	public MemberDto selectOne(Connection con, String memId) {
		MemberDto result = null;
		String sql = "SELECT MEM_ID, MEM_PWD, MEM_EMAIL, MEM_NAME FROM MEMBER WHERE MEM_ID = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			pstmt.setString(1, memId);
			
			rs = pstmt.executeQuery();
			// ResultSet 처리
			if(rs.next()) {
				result = new MemberDto(
						rs.getString("MEM_ID")
						, rs.getString("MEM_PWD")
						, rs.getString("MEM_EMAIL")
						, rs.getString("MEM_NAME")
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
	public int insert(Connection con, MemberDto dto) {
		int result = -1;
//		INSERT INTO MEMBER VALUES('kh'||K, 'pwd'||K, 'kh'||K||'@a.com', '이름'||K);
		String sql = "INSERT INTO MEMBER (MEM_ID, MEM_PWD, MEM_EMAIL, MEM_NAME) VALUES(?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			pstmt.setString(1, dto.getMemId());
			pstmt.setString(2, dto.getMemPwd());
			pstmt.setString(3, dto.getMemEmail());
			pstmt.setString(4, dto.getMemName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
		return result;
	}
	
	// update
	public int update(Connection con, MemberDto dto) {
		int result = -1;
		String sql = "UPDATE MEMBER SET MEM_PWD = ?, MEM_EMAIL = ? WHERE MEM_ID = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMemPwd());
			pstmt.setString(2, dto.getMemEmail());
			pstmt.setString(3, dto.getMemId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
		return result;
	}
	// delete
	public int delete(Connection con, String memId) {
		int result = 0;
		String sql = "DELETE FROM MEMBER WHERE MEM_ID = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			// ? 자리
			pstmt.setString(1, memId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		close(pstmt);
		return result;
	}
}
