package com.dt.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	static Properties pros = null; //帮助读取和处理资源文件
	
	static { // 加载JDBCUtil
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 获取mysql连接
	public static Connection getMysqlConn() {
		try {
			Class.forName("mysqlDriver");
			return DriverManager.getConnection("mysqlURL", "mysqlUser", "mysqlPWD");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 

	}

	// 关闭数据库返回结果，关闭数据库执行语句，关闭数据库连接
	public static void close(ResultSet rs, Statement ps, Connection conn) {

		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 重写 close方法，只返回 Statement 和 Connection
	public static void close(Statement ps, Connection conn) {

		try {
			if (ps != null) {
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// 重写 close方法，只返回Connection
	public static void close(Connection conn) {

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
