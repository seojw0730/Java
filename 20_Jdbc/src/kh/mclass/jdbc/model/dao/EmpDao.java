package kh.mclass.jdbc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.model.vo.Emp;

// DAO(Data Access Object)
public class EmpDao {

	public List<Emp> selectList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<Emp> empList = null; // 오류인 상태를 유지
//		List<Emp> empList = new Arraylist<Emp>(); // 0 으로 출력됨
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // lib, jar, Class 확인
			// "jdbc:oracle:thin:@127.0.0.1:1521:XE"
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "TIGER");
			if (conn != null)
				System.out.println("연결 성공");
			else
				System.out.println("연결 실패");
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from emp");
			// List 생성
			empList = new ArrayList<Emp>(); // size: 0
			while (rset.next()) {
				// Emp 객체 생성
				Emp emp = new Emp();
				// Emp 객체 값 대입
				emp.setEmpno(rset.getInt("empno"));
				emp.setComm(rset.getDouble("comm"));
				emp.setDeptno(rset.getInt("deptno"));
				emp.setEname(rset.getString("ename"));
				emp.setHiredate(rset.getDate("hiredate"));
				emp.setJob(rset.getString("job"));
				emp.setMgr(rset.getInt("mgr"));
				emp.setSal(rset.getDouble("sal"));
				// List 객체 값 대입
				empList.add(emp);

//				System.out.println("한 행 있음");
//				System.out.println(rset.getInt("empno"));
//				System.out.println(rset.getString("ename"));
//				System.out.println(rset.getDouble("sal"));
			}
//			System.out.println(empList);
//			System.out.println("다 읽음. 끝.");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return empList;
	}

	public void insertEmp_stmt(Emp emp) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // lib, jar, Class 확인
			// "jdbc:oracle:thin:@127.0.0.1:1521:XE"
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "TIGER");
			if (conn != null)
				System.out.println("연결 성공");
			else
				System.out.println("연결 실패");
			stmt = conn.createStatement();
			int result = stmt.executeUpdate(
					"insert into emp " + "(EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO ) " + " values " + "("
							+ emp.getEmpno() + ", '" + emp.getEname() + "', '" + emp.getJob() + "' , " + emp.getMgr()
							+ "," + " SYSDATE, " + emp.getSal() + ", " + emp.getComm() + ", " + emp.getDeptno() + " )");
			System.out.println("결과 확인" + result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public int insertEmp(Emp emp) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1; // 오류 --> -1, insert 중 이상 --> 0
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // lib, jar, Class 확인
			// "jdbc:oracle:thin:@127.0.0.1:1521:XE"
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "TIGER");
			if (conn != null)
				System.out.println("연결 성공");
			else
				System.out.println("연결 실패");
			String sql = "insert into emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) values (?, ?, ?, ?, SYSDATE, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, emp.getEmpno());
			pstmt.setString(2, emp.getEname());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setDouble(5, emp.getSal());
			pstmt.setDouble(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptno());

			result = pstmt.executeUpdate();

//			System.out.println("결과 확인" + result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public void deleteEmp() {
	}

}
