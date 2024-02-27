package kh.mclass.jdbc.model.dao;

import static kh.mclass.jdbc.common.JdbcTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.model.vo.Dept;

public class DeptDao {
	public List<Dept> selectList(Connection con) {
		String sql = "select * from dept";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Dept> result = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<Dept>();
			while (rs.next()) {
				Dept vo = new Dept();
				vo.setDeptno(rs.getInt("deptno"));
				vo.setDname(rs.getString("dname"));
				vo.setLoc(rs.getString("loc"));
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

	public int insert(Connection con, Dept vo) {
		int result = -1;
		String sql = "insert into dept values (?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getDeptno());
			pstmt.setString(2, vo.getDname());
			pstmt.setString(3, vo.getLoc());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int delete(Connection con, int deptno) {
		int result = -1;
		String sql = "delete from dept where deptno = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
