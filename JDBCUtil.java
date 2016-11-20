package com.dt.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	static Properties pros = null; //������ȡ�ʹ�����Դ�ļ�
	
	static { // ����JDBCUtil
		pros = new Properties();
		try {
			pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// ��ȡmysql����
	public static Connection getMysqlConn() {
		try {
			Class.forName("mysqlDriver");
			return DriverManager.getConnection("mysqlURL", "mysqlUser", "mysqlPWD");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 

	}

	// �ر����ݿⷵ�ؽ�����ر����ݿ�ִ����䣬�ر����ݿ�����
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

	// ��д close������ֻ���� Statement �� Connection
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

	// ��д close������ֻ����Connection
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
