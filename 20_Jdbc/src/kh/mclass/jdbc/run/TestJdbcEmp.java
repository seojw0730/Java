package kh.mclass.jdbc.run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.model.vo.Emp;

public class TestJdbcEmp {
	public static void main(String[] args) {
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
			System.out.println("다 읽음. 끝.");
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

		if (empList == null) {
			System.out.println("오류로 데이터 읽기 실패");
		} else {
			System.out.println("사원 수: " + empList.size());
			if (empList.size() > 0) {
				for (Emp emp : empList) {
					System.out.println(emp);
				}
			}
		}
	}
}
