package kh.mclass.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.mclass.jdbc.common.JdbcTemplate.*;
import kh.mclass.jdbc.model.vo.Emp;

public class EmpDao {
	
	public Emp selectOne(Connection con, int empno) {
		Emp result = null;
		String sql = "select * from emp where empno = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = new Emp();
				result.setEmpno(rs.getInt("empno"));
				result.setEname(rs.getString("ename"));
				result.setJob(rs.getString("job"));
				result.setMgr(rs.getInt("mgr"));
				result.setHiredate(rs.getDate("hiredate"));
				result.setSal(rs.getDouble("sal"));
				result.setComm(rs.getDouble("comm"));
				result.setDeptno(rs.getInt("deptno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Emp> selectList(Connection con) {
		String sql = "select * from emp ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> result = null;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			result = new ArrayList<Emp>();
			while (rs.next()) {
				Emp vo = new Emp();
				vo.setEmpno(rs.getInt("empno"));
				vo.setEname(rs.getString("ename"));
				vo.setJob(rs.getString("job"));
				vo.setMgr(rs.getInt("mgr"));
				vo.setHiredate(rs.getDate("hiredate"));
				vo.setSal(rs.getDouble("sal"));
				vo.setComm(rs.getDouble("comm"));
				vo.setDeptno(rs.getInt("deptno"));
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

	public int insert(Connection con, Emp vo) {
		int result = -1;
		String sql = "insert into emp values (?,?,?,?,sysdate,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, vo.getEmpno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getJob());
			pstmt.setInt(4, vo.getMgr());
			pstmt.setDouble(5, vo.getSal());
			pstmt.setDouble(6, vo.getComm());
			pstmt.setInt(7, vo.getDeptno());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int delete(Connection con, int empno) {
		int result = -1;
		String sql = "delete from emp where empno = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, empno);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
