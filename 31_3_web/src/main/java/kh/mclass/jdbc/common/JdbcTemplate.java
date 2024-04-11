package kh.mclass.jdbc.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcTemplate {
	private JdbcTemplate() {
	}
	
	public static Connection getConnectionSemi(boolean isLocal) {
		Connection con = null;
		Properties prop = null;
		try {
			prop = new Properties();
			String currentPath = JdbcTemplate.class.getResource("").getPath();
			prop.load(new FileReader(currentPath + "driver.properties"));
			
			Class.forName(prop.getProperty("jdbc.driver"));
			if(isLocal) {
				con = DriverManager.getConnection(prop.getProperty("jdbc.semi.localhost.url")
						, prop.getProperty("jdbc.semi.username")
						, prop.getProperty("jdbc.semi.password"));
			} else{
				con = DriverManager.getConnection(prop.getProperty("jdbc.semi.dbserver.url")
						, prop.getProperty("jdbc.semi.username")
						, prop.getProperty("jdbc.semi.password"));
			}
			if (con != null)
				System.out.println("연결 성공");
			else
				System.out.println("연결 실패");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getConnection() {
		Connection con = null;
		Properties prop = null;
		try {
			prop = new Properties();
			String currentPath = JdbcTemplate.class.getResource("").getPath();
			prop.load(new FileReader(currentPath + "driver.properties"));

			Class.forName(prop.getProperty("jdbc.driver"));
			con = DriverManager.getConnection(prop.getProperty("jdbc.url"), prop.getProperty("jdbc.username"),
					prop.getProperty("jdbc.password"));
			if (con != null)
				System.out.println("연결 성공");
			else
				System.out.println("연결 실패");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
