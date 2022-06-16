package com.yedam.app.common;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DAO {

	// 오라클 연결 정보(DAO 클래스에서만 사용)
	private String jdbc_driver;
	private String oracle_url;
	private String connectedId;
	private String connectedPwd;

	// 공통 필드(자식클래스에서도 사용)
	protected Connection conn;
	protected Statement stmt;
	protected PreparedStatement pstmt;
	protected ResultSet rs;

	public void connect() {
		try {
			dbconfig();
			// 1. JDBC 드라이버 로딩
			Class.forName(jdbc_driver);
			// 2. DB 접속
			conn = DriverManager.getConnection(oracle_url, connectedPwd, connectedId);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
		}
	}

	private void dbconfig() {
		String resource = "config/db.properties";
		Properties properties = new Properties();

		try {
			String filePath = ClassLoader.getSystemClassLoader().getResource(resource).getPath();
			properties.load(new FileInputStream(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		jdbc_driver = properties.getProperty("driver");
		oracle_url = properties.getProperty("url");
		connectedId = properties.getProperty("id");
		connectedPwd = properties.getProperty("pwd");

	}

	// 4. 자원해제하기
	public void disconnect() {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
