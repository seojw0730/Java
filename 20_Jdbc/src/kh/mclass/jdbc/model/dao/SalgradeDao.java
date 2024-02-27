package kh.mclass.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.mclass.jdbc.common.JdbcTemplate.*;
import kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeDao {
	public List<Salgrade> selectList(Connection con) {
		String sql = "select * from salgrade";
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
		String sql = "insert into salgrade values (?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getGrade());
			pstmt.setInt(2, vo.getLosal());
			pstmt.setInt(3, vo.getHisal());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int delete(Connection con, int grade) {
		int result = -1;
		String sql = "delete from salgrade where grade = ?";
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
}
