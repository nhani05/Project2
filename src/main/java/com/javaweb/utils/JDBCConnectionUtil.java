package com.javaweb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/estatebasic";
	private static final String USER_NAME = "root";
	private static final String PASS_WORD = "123456";
	
	public static Connection getConnections() {
		try {
			return DriverManager.getConnection(URL, USER_NAME, PASS_WORD);
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
