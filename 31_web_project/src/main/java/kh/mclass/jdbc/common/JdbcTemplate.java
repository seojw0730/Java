package kh.mclass.jdbc.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcTemplate {
	private JdbcTemplate() {
	}

	public static Connection getConnection() {
		Connection con = null;
		Properties prop = new Properties();
		try {
			String currentPath = JdbcTemplate.class.getResource("").getPath();
			String currentPath2 = JdbcTemplate.class.getResource("./").getPath();
			String currentPath3 = JdbcTemplate.class.getResource("../../").getPath();
			System.out.println(currentPath);
			System.out.println(currentPath2);
			System.out.println(currentPath3);
			prop.load(new FileReader(currentPath + "driver.properties"));
			System.out.println(prop.getProperty("alert.msg"));
//			System.out.println(prop.getProperty("jdbc.url"));
			Class.forName(prop.getProperty("jdbc.driver"));
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(prop.getProperty("jdbc.url"), 
					prop.getProperty("jdbc.username"), 
					prop.getProperty("jdbc.password"));
			if (con != null)
				System.out.println("연결 성공");
			else
				System.out.println("연결 실패");
		} catch (Exception e) {
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
