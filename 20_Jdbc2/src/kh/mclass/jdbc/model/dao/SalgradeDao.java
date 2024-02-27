package kh.mclass.jdbc.model.dao;

import static kh.mclass.jdbc.common.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeDao {
	public Salgrade selectOne(Connection con, int grade) {
		Salgrade result = null;
		String sql = "select * from salgrade where grade = ?"; // TODO
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, grade);
			// TODO
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new Salgrade(); // TODO 아래 확인
				result.setGrade(rs.getInt("grade"));
				result.setLosal(rs.getInt("losal"));
				result.setHisal(rs.getInt("hisal"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public List<Salgrade> selectList(Connection con) {
		String sql = "select * from Salgrade";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Salgrade> result = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<Salgrade>();
			while (rs.next()) {
				Salgrade vo = new Salgrade();
				vo.setGrade(rs.getInt("grade"));
				vo.setLosal(rs.getInt("losal"));
				vo.setHisal(rs.getInt("hisal"));
				result.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public int insert(Connection con, Salgrade vo) {
		int result = -1;
		String sql = "insert into Salgrade values (?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getGrade());
			pstmt.setInt(2, vo.getLosal());
			pstmt.setInt(3, vo.getHisal());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int delete(Connection con, int grade) {
		int result = -1;
		String sql = "delete from SALGRADE where grade = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, grade);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int update(Connection con, Salgrade vo) {
		int result = -1;
		String sql = "update "; // TODO
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			// TODO
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
