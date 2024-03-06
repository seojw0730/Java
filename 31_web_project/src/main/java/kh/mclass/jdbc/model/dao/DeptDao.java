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
	public Dept selectOne(Connection con, int deptno) {
		Dept result = null;
		String sql = "select * from dept where deptno = ?"; // TODO
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new Dept(); // TODO 아래 확인
				result.setDeptno(rs.getInt("deptno"));
				result.setDname(rs.getString("dname"));
				result.setLoc(rs.getString("loc"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}

	public List<Dept> selectList(Connection con) {
		List<Dept> result = null;
		String sql = "select * from dept";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
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

	public int update(Connection con, Dept vo) {
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
