package kh.mclass.jdbc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.mclass.jdbc.model.vo.Emp2;

public class EmpDao2 {

	public List<Emp2> selectList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		List<Emp2> empList = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "TIGER");
			stmt = conn.createStatement();
			rset = stmt.executeQuery("select * from emp");

			empList = new ArrayList<Emp2>();

			while (true) {
				Emp2 emp = new Emp2();

				emp.setEmpno(rset.getInt("empno"));
				emp.setEname(rset.getString("ename"));
				emp.setJob(rset.getString("job"));
				emp.setMgr(rset.getInt("mgr"));
				emp.setHiredate(rset.getDate("hiredate"));
				emp.setSal(rset.getDouble("sal"));
				emp.setComm(rset.getDouble("comm"));
				emp.setDeptno(rset.getInt("deptno"));

				empList.add(emp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null)
					rset.close();
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return empList;
	}

	public void insertEmp() {
	}

	public void deleteEmp() {
	}

}
