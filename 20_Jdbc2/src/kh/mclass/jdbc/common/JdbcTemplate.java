package kh.mclass.jdbc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTemplate {
	private JdbcTemplate() {
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "scott", "TIGER");
			if (con != null)
				System.out.println("연결 성공");
			else
				System.out.println("연결 실패");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void autoCommit(Connection con, boolean autoCommit) {
		try {
			if (con != null)
				con.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void commit(Connection con) {
		try {
			if (con != null)
				con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection con) {
		try {
			if (con != null)
				con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection con) {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
