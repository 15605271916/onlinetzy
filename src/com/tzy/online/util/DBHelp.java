package com.tzy.online.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelp {

	private DBHelp() {

	}

	private static String driverName;
	private static String url;
	private static String user;
	private static String password;

	static {

		try {
			Properties pro = new Properties();
			pro.load(DBHelp.class.getResourceAsStream("db.config.properties"));

			driverName = pro.getProperty("driverName");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");

			Class.forName(driverName);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static Connection getconn() {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭数据库连接
	 * 
	 * @param conn
	 */
	public static void closeConn(Connection conn) {

		if (conn != null) {

			try {
				if (!conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
