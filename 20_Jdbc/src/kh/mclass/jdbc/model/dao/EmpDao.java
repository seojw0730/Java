package kh.mclass.jdbc.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static kh.mclass.jdbc.common.JdbcTemplate.*;
import kh.mclass.jdbc.model.vo.Emp;

public class EmpDao {
//	private int empno;
//	private String ename;
//	private String job;
//	private int mgr;
//	private Date hiredate;
//	private double sal;
//	private double comm;
//	private int deptno;
	public List<Emp> selectList(Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Emp> result = null;
		String sql = "select * from emp";
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
		PreparedStatement pstmt = null;
		String sql = "insert into salgrade values (?,?,?,?,sysdate,?,?,?)";
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
			if (result > 0) {
				System.out.println("추가 성공");
			} else {
				System.out.println("추가 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int delete(Connection con, int deptno) {
		int result = -1;
		PreparedStatement pstmt = null;
		String sql = "delete from emp where deptno = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
}
